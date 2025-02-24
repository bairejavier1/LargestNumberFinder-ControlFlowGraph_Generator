# Largest Number Finder

## Purpose

The **Largest Number Finder** project is designed to implement and test a program that identifies the largest number from a set of integers. The main focus is to create a simple yet effective algorithm to find the largest number, along with unit tests to ensure the correctness of the implementation. This project also includes an analysis tool that generates a control flow graph (CFG) of the program.

The goal of this project is to:
- Implement a function that can find the largest number from a list of integers.
- Write unit tests to verify the correctness of the solution.
- Use Java and JUnit4 to structure and test the code.
- Generate a control_flow_graph.dot file of the program using a `ControlFlowGraph_Generator` file for visual analysis that can be later be tested on an open-source graph visualization software that allows you to create diagrams and visualizations of various types of graphs and networks. It uses the DOT language to describe the structure of a graph, which can then be rendered into images or other formats for easy viewing.

### Algorithm Used

The program uses a **greedy algorithm** to find the largest number from three given integers. Here's a breakdown of the algorithm:

1. **Input Handling**: The program uses a `Scanner` to take user input for three numbers (`num1`, `num2`, and `num3`).
2. **Initial Assumption**: The first number (`num1`) is assumed to be the largest initially (`largest = num1`).
3. **Comparison**:
    - The program compares `num2` with the current largest number. If `num2` is greater, it updates the largest number to `num2`.
    - After that, it compares `num3` with the current largest number. If `num3` is greater, it updates the largest number to `num3`.
4. **Output**: Finally, the program prints the largest of the three numbers.

This algorithm runs in constant time O(1), as it involves a fixed number of comparisons.

---

## Prerequisites

Before starting, make sure you have the following installed:

- **Java 21** (or a compatible version)
- **Maven** (for dependency management and running tests)
- **IntelliJ IDEA** (or a similar Java IDE)

## Getting Started

1. **Clone the repository**:

   ```bash
   git clone https://github.com/bairejavier1/LargestNumberFinder-ControlFlowGraph_Generator.git
   cd LargestNumberFinder

2. Open the cloned repository in IntelliJ IDEA:
   Launch IntelliJ IDEA (or any compatible IDE).
   Open the cloned repository folder by going to File > Open and selecting the folder you just cloned.
   IntelliJ will automatically detect the Maven project structure and index all the necessary files for you.

3. Build and Run the Program:
   To build the project, simply click the Build button in IntelliJ or use the shortcut Ctrl+F9.
   To run the program, right-click the LargestNumber file and select Run 'LargestNumber.main()'.
   The program will prompt you to enter three numbers. After inputting the numbers, the program will display the largest number.
4. Test Each Separate File:
   The project includes various files, such as the LargestNumber program and the ControlFlowGraph_Generator.
   You can test and experiment with the output of each file individually by running them in IntelliJ IDEA.
   For example, you can:
   Test the LargestNumber class by running it to see how it processes user input and finds the largest number.
   Experiment with the ControlFlowGraph_Generator to generate a .dot file that can be visualized with Graphviz.
5. View the Visual Representation of the Program:
   Once you have generated the .dot file using ControlFlowGraph_Generator, you can use an online Graphviz tool (such as Graphviz Online - https://graph.flyte.org/) to visualize the control flow graph.
   Simply upload or paste the content of the .dot file into the tool, and it will generate a visual representation of the program's control flow.

