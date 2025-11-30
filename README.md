Implementing a Data Structure for a "Least Recently Used" Cache

Course: CS315 - Programming Languages

Paradigm: Functional Implementation

Language: Java

Project Overview

This project implements a Least Recently Used (LRU) Cache with an average time complexity of O(1) for both get and put operations.

In accordance with the Functional Paradigm assignment, this implementation avoids Object-Oriented class encapsulation (methods inside objects). Instead, it utilizes:

Pure Data Structures: Simple static classes (Node, CacheState) that hold data without behavior.

Static Functions: Standalone logic that accepts the state as an argument to perform operations.

Group Members

Kent Vincent Butaya

Josh Andrie de Ramas

Kerby Fabria

Christian John Legaspi

Theodore Pagalan

Carl Dominic Rejas

Prerequisites

Java Development Kit (JDK): Version 8 or higher.

File Structure

FunctionalLRU.java: Contains the main method, data definitions (Node, CacheState), and functional logic (get, put).

How to Compile and Run

Open your terminal or command prompt.

Navigate to the directory containing FunctionalLRU.java.

Compile the code:

javac FunctionalLRU.java


Run the application:

java FunctionalLRU


Logic Description

The cache utilizes two data structures working in tandem to achieve $O(1)$ efficiency:

Hash Map: Acts as an index for constant-time lookups.

Doubly Linked List: Maintains the order of usage (Head = Most Recently Used, Tail = Least Recently Used).

Operations

get(state, key):

Looks up the key in the Hash Map.

Unhooks the node from its current position in the list.

Moves the node to the Head of the list.

Returns the value.

put(state, key, value):

If the key exists, update the value and move the node to the Head.

If the key is new, create a node and add it to the Head.

Eviction: If the size exceeds capacity, the node at the Tail (LRU) is removed from both the list and the map.

Expected Output

When running the program, the output will match the example provided in the project proposal:

Initializing Cache with Capacity 4...
put(1, A)
put(2, B)
get(1) -> A
put(3, C)
put(4, D)
put(5, E)
get(3) -> C

Final Cache Contents (MRU -> LRU):
3:C
5:E
4:D
1:A
