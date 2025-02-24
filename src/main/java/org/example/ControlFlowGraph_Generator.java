package org.example;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.stmt.IfStmt;
import com.github.javaparser.ast.stmt.Statement;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleDirectedGraph;
import com.github.javaparser.JavaParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class ControlFlowGraph_Generator {

    public static void main(String[] args) throws IOException {
        // Path to your Java source code file
        String filePath = "src/main/java/org/example/LargestNumber.java";  // Update with your actual path

        // Parse the Java file
        FileInputStream in = new FileInputStream(new File(filePath));
        JavaParser parser = new JavaParser();
        CompilationUnit cu = parser.parse(in).getResult().get();

        // Create the Control Flow Graph
        Graph<String, DefaultEdge> graph = new SimpleDirectedGraph<>(DefaultEdge.class);

        // Parse the main method (assuming it is there)
        cu.findAll(MethodDeclaration.class).forEach(method -> {
            if (method.getNameAsString().equals("main")) {
                String startNode = "START";
                graph.addVertex(startNode);
                NodeWrapper previousNode = new NodeWrapper(startNode);

                method.getBody().ifPresent(body -> {
                    body.getStatements().forEach(statement -> {
                        if (!statement.isBlockStmt()) { // Ignore block statements
                            previousNode.setNode(addStatementToGraph(statement, graph, previousNode.getNode()));
                        }
                    });
                });
            }
        });

        // Output the graph structure in DOT format
        generateDotFile(graph, "control_flow_graph.dot");
    }

    private static String addStatementToGraph(Statement statement, Graph<String, DefaultEdge> graph, String previousNode) {
        String currentNode = statement.toString().trim().replace("\"", "\\\"");
        graph.addVertex(currentNode);
        graph.addEdge(previousNode, currentNode);

        if (statement.isIfStmt()) {
            IfStmt ifStmt = statement.asIfStmt();
            String conditionNode = ifStmt.getCondition().toString().trim();
            String ifBranchNode = "IfBranch";
            String elseBranchNode = "ElseBranch";

            graph.addVertex(conditionNode);
            graph.addVertex(ifBranchNode);
            graph.addVertex(elseBranchNode);

            graph.addEdge(previousNode, conditionNode);
            graph.addEdge(conditionNode, ifBranchNode);
            graph.addEdge(conditionNode, elseBranchNode);

            return ifBranchNode;
        }

        return currentNode;
    }

    private static void generateDotFile(Graph<String, DefaultEdge> graph, String filePath) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        writer.write("digraph G {\n");

        for (DefaultEdge edge : graph.edgeSet()) {
            String source = graph.getEdgeSource(edge);
            String target = graph.getEdgeTarget(edge);
            writer.write("    \"" + source + "\" -> \"" + target + "\";\n");
        }

        writer.write("}\n");
        writer.close();
        System.out.println("DOT file has been generated: " + filePath);
    }

    static class NodeWrapper {
        private String node;

        public NodeWrapper(String node) {
            this.node = node;
        }

        public String getNode() {
            return node;
        }

        public void setNode(String node) {
            this.node = node;
        }
    }
}