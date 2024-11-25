# Algorithmic Task Solutions

This repository contains solutions for three algorithmic tasks implemented in Java. The code is efficient, well-documented, and adheres to best practices.

## Task Descriptions

### Task 1: Valid Parentheses Expressions
Count the number of valid parentheses expressions containing `N` pairs of brackets. The task uses **Catalan numbers** to compute the result efficiently. It also generates all valid combinations for a given `N`.

**Example Input:**

N = 3

**Example Output:**

Number of valid parentheses combinations: 5
All combinations:
((()))
(()())
(())()
()(())
()()()

---

### Task 2: Minimum Transportation Cost
Given a list of cities and the transportation costs between them, find the minimum cost paths between specified pairs of cities. The solution uses **Dijkstra's algorithm** for efficient pathfinding.

**Input Example:**

1
4
gdansk
2
2 1
3 3
bydgoszcz
3
1 1
3 1
4 4
torun
3
1 3
2 1
4 1
warszawa
2
2 4
3 1
2
gdansk warszawa
bydgoszcz warszawa

**Output Example:**

3
2

---

### Task 3: Sum of Digits in Factorial
Compute the sum of the digits in the factorial of a given number.

**Example Input:**

N = 100

**Example Output:**

648

---

## How to Run
Each task has its own `main` method and can be executed independently. Compile and run the `.java` files using a Java compiler.

---

## Requirements
- Java 11 or later.
