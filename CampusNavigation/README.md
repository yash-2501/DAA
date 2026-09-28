<div align="center">

🧭 CAMPUS NAVIGATION & PATH FINDING

Design and Analysis of Algorithms — 5th Semester Mini Project

<p>
  <img src="https://img.shields.io/badge/Language-Java-orange?style=for-the-badge&logo=openjdk">
  <img src="https://img.shields.io/badge/Graph-Weighted-blue?style=for-the-badge">
  <img src="https://img.shields.io/badge/BFS-Implemented-success?style=for-the-badge">
  <img src="https://img.shields.io/badge/DFS-Implemented-purple?style=for-the-badge">
  <img src="https://img.shields.io/badge/Dijkstra-Implemented-green?style=for-the-badge">
  <img src="https://img.shields.io/badge/A*-Implemented-red?style=for-the-badge">
</p>

<p>
  <b>Java • Graph Algorithms • Path Finding • Complexity Analysis • Performance Evaluation</b>
</p>

<p>
  <i>
  A complete DAA mini project that models a college campus as a weighted graph
  and compares multiple path-finding algorithms.
  </i>
</p>

</div>

📚 Table of Contents

📌 Project Overview

🎯 Problem Statement

🚀 Objectives

🧠 DAA Concepts

🗺️ Campus Model

📍 Location Mapping

🔗 Graph Representation

🏗️ System Architecture

📁 Project Structure

⚙️ Algorithms

🌊 BFS

🌲 DFS

🛣️ Dijkstra

⭐ A*

⚖️ Algorithm Comparison

📐 Complexity Analysis

📄 Input Data

▶️ How to Run

🖥️ Program Menu

🧪 Testing

📊 Performance Analysis

📈 Performance Graph

🎓 Viva Questions

❌ Common Errors

✨ Advantages

⚠️ Limitations

🚀 Future Scope

🎤 Presentation

📝 Quick Revision

🏁 Conclusion

📌 Project Overview

Campus Navigation & Path Finding is a Java-based Design and Analysis of Algorithms project.

The project represents a college campus using a:

Weighted Undirected Graph

Each campus location is represented as a vertex, while roads between locations are represented as edges.

The distance of each road is stored as the edge weight.

The project implements four major algorithms:

BFS
DFS
Dijkstra
A*

The system allows the user to select:

Source Location
        ↓
Destination Location
        ↓
Path Finding Algorithm
        ↓
Path
        ↓
Distance
        ↓
Execution Time

The project also compares the algorithms experimentally and stores the results in:

results/results.csv

🎯 Problem Statement

In a college campus, students may need to travel between different locations such as:

Main Gate

Admin Building

IT Department

Library

Canteen

Laboratory

Parking

Auditorium

Sports Ground

Hostel

Finding a suitable route manually can be difficult when the number of locations increases.

Therefore, the objective of this project is to develop a graph-based campus navigation system that can find paths between locations using different graph algorithms.

The project also compares the theoretical complexity and actual execution time of the implemented algorithms.

🚀 Objectives

Main Objectives

Represent campus locations using a graph.

Represent roads using edges.

Store road distances as weights.

Implement BFS.

Implement DFS.

Implement Dijkstra.

Implement A*.

Calculate route distance.

Count route edges.

Measure execution time.

Compare algorithms.

Store results in CSV.

Display performance graph.

🧠 DAA Concepts

This project demonstrates the following DAA concepts:

Graph
Graph Traversal
Shortest Path
Weighted Graph
Adjacency List
Queue
Recursion
Priority Queue
Greedy Algorithm
Heuristic Search
Time Complexity
Space Complexity
Experimental Analysis

🗺️ Campus Model

The campus is represented as a graph.

                Sports Ground
                     |
                     |
                Auditorium
               /         \
              /           \
         Library -------- Laboratory
           |  \              |
           |   \             |
           |    \            |
     IT Department        Canteen
           |                 |
           |                 |
     Admin Building       Parking
           |
           |
       Main Gate

          Hostel

The actual connections and distances are stored in:

data/campus_data.txt

📍 Location Mapping

ID

Location

0

Main Gate

1

Admin Building

2

IT Department

3

Library

4

Canteen

5

Laboratory

6

Parking

7

Auditorium

8

Sports Ground

9

Hostel

Easy Memory

0 → Main Gate
1 → Admin
2 → IT
3 → Library
4 → Canteen
5 → Laboratory
6 → Parking
7 → Auditorium
8 → Sports Ground
9 → Hostel

🔗 Graph Representation

The project uses an Adjacency List.

Example:

0 → 1(100m), 4(220m)

1 → 0(100m), 2(120m), 4(150m)

2 → 1(120m), 3(80m), 5(100m), 7(180m)

3 → 2(80m), 7(120m), 5(130m)

4 → 1(150m), 6(100m), 0(220m), 9(250m)

In Java:

List<List<Edge>> adjacencyList;

Each edge contains:

int destination;
int weight;

🏗️ System Architecture

Working Flow

User
 ↓
Select Source
 ↓
Select Destination
 ↓
Select Algorithm
 ↓
Search Graph
 ↓
Generate Path
 ↓
Calculate Distance
 ↓
Measure Execution Time
 ↓
Display Result

📁 Project Structure

CampusNavigation/
│
├── src/
│   ├── Main.java
│   ├── Graph.java
│   ├── CampusDataLoader.java
│   ├── BFS.java
│   ├── DFS.java
│   ├── Dijkstra.java
│   ├── AStar.java
│   ├── PerformanceAnalyzer.java
│   └── PerformanceGraph.java
│
├── data/
│   └── campus_data.txt
│
├── results/
│   └── results.csv
│
├── screenshots/
│
├── report/
│
└── README.md

⚙️ Algorithms

The project implements:

Algorithm

Type

Weight

Heuristic

BFS

Traversal

❌

❌

DFS

Traversal

❌

❌

Dijkstra

Shortest Path

✅

❌

A*

Informed Search

✅

✅

🌊 BFS

Breadth First Search

BFS explores a graph level by level.

It uses:

Queue

Example:

        A
       / \
      B   C
     / \
    D   E

BFS:

A → B → C → D → E

Steps

1. Start from source.
2. Put source into queue.
3. Mark source visited.
4. Remove a vertex.
5. Visit its unvisited neighbors.
6. Add neighbors to queue.
7. Repeat.

Complexity

Time  = O(V + E)
Space = O(V)

Important

BFS finds the minimum number of edges in an unweighted graph.

It does not necessarily find the minimum physical distance in this weighted campus graph.

🌲 DFS

Depth First Search

DFS explores as deeply as possible before backtracking.

This implementation uses:

Recursion

Example:

        A
       / \
      B   C
     / \
    D   E

Possible DFS:

A → B → D → E → C

Steps

1. Visit current vertex.
2. Mark it visited.
3. Select an unvisited neighbor.
4. Recursively visit it.
5. Backtrack when required.

Complexity

Time  = O(V + E)
Space = O(V)

Important

DFS does not guarantee the shortest path.

🛣️ Dijkstra

Dijkstra's algorithm finds the shortest weighted path when edge weights are non-negative.

It uses:

PriorityQueue

Main Concept

Always process the vertex with the smallest known distance.

Example:

A --5-- B
A --2-- C
C --1-- B

Possible shortest route:

A → C → B

Distance:

2 + 1 = 3

Complexity

With a priority queue:

O((V + E) log V)

Important Condition

All edge weights must be non-negative.

⭐ A*

A* is an informed search algorithm.

The main formula is:

f(n) = g(n) + h(n)

Where:

g(n) = cost from source to current node

h(n) = estimated cost from current node to destination

f(n) = total estimated cost

The project uses Euclidean distance as its heuristic:

h(n) =
√((x1 - x2)² + (y1 - y2)²)

Example

If:

g(n) = 100
h(n) = 80

then:

f(n) = 180

Important

A* can guarantee an optimal path when the heuristic is appropriately admissible/consistent for the edge-cost model.

For a rigorous implementation, the coordinate units should be calibrated consistently with the road-distance weights.

⚖️ Algorithm Comparison

Feature

BFS

DFS

Dijkstra

A*

Graph traversal

✅

✅

❌

❌

Weighted graph

❌

❌

✅

✅

Shortest weighted path

❌

❌

✅

Depends on heuristic

Queue

✅

❌

❌

❌

Priority Queue

❌

❌

✅

✅

Recursion

❌

✅

❌

❌

Heuristic

❌

❌

❌

✅

Navigation use

Limited

Limited

✅

✅

📐 Complexity Analysis

Let:

V = Number of vertices
E = Number of edges

BFS

Time Complexity:
O(V + E)

Space Complexity:
O(V)

DFS

Time Complexity:
O(V + E)

Space Complexity:
O(V)

Dijkstra

Using a priority queue:

Time Complexity:
O((V + E) log V)

Space Complexity:
O(V)

A*

A* does not have one useful fixed practical runtime independent of the heuristic.

Its performance depends on:

Graph
+
Edge Weights
+
Heuristic Quality

📄 Input Data

File:

data/campus_data.txt

Contents:

# Campus Navigation Data
# Format:
# source,destination,distance

0,1,100
1,2,120
2,3,80
1,4,150
4,6,100
2,5,100
3,7,120
7,8,200
6,9,150

# Additional alternative routes

0,4,220
2,7,180
5,7,160
4,9,250
3,5,130

Format:

source,destination,distance

Example:

0,1,100

means:

Main Gate
    |
  100m
    |
Admin Building

▶️ How to Run

1. Open Project

Open:

CampusNavigation

in VS Code.

2. Open Terminal

Run:

cd "C:\Users\dell\Desktop\coding\collage\DAA\CampusNavigation"

3. Compile

javac src\*.java

4. Run Main Program

java -cp src Main

5. Run Performance Graph

First generate:

results/results.csv

by selecting:

7. Compare All Algorithms

Then run:

java -cp src PerformanceGraph

🖥️ Program Menu

==============================================
       CAMPUS NAVIGATION & PATH FINDING
==============================================
1. Display Campus Location IDs
2. Display Campus Graph
3. Find Path using BFS
4. Find Path using DFS
5. Find Shortest Path using Dijkstra
6. Find Path using A*
7. Compare All Algorithms
8. Exit
==============================================

🧪 Testing

Test Case 1

Source = 0
Destination = 7

Meaning:

Main Gate → Auditorium

Test Case 2

Source = 0
Destination = 0

Expected:

Distance = 0
Edges = 0

Test Case 3

Source = 7
Destination = 0

The graph is undirected, so reverse traversal is possible when a route exists.

Test Case 4

Source = 2
Destination = 9

Run all four algorithms and compare:

Path
Edges
Distance
Execution Time

Test Case 5

Invalid source:

20

Expected:

Invalid Source ID!

📊 Performance Analysis

Recorded test:

Source = 0
Destination = 7

Results from one run:

Algorithm

Edges

Distance

Execution Time

BFS

3

400 m

2,198,700 ns

DFS

4

420 m

1,606,900 ns

Dijkstra

3

400 m

3,465,600 ns

A*

3

400 m

166,400 ns

Interpretation

For this particular run:

BFS found a 3-edge route.

DFS found a 4-edge route.

Dijkstra found a 400 m weighted route.

A* found a 400 m route.

Execution time varied between algorithms.

Note: These are measurements from one run on one machine. Runtime can change between executions because of JVM warm-up, operating-system scheduling, hardware, and other factors.

For a stronger experiment, repeat each test many times and compare average or median runtime.

📄 Results CSV

After selecting:

7. Compare All Algorithms

the program creates:

results/results.csv

Example:

Algorithm,Source,Destination,Edges,Distance,ExecutionTimeNs
BFS,0,7,3,400,2198700
DFS,0,7,4,420,1606900
Dijkstra,0,7,3,400,3465600
A*,0,7,3,400,166400

View CSV

Get-Content results\results.csv

Open with Notepad

notepad results\results.csv

Open Folder

explorer results

📈 Performance Graph

The project contains:

PerformanceGraph.java

It reads:

results/results.csv

and creates a Java Swing bar graph.

Run:

java -cp src PerformanceGraph

Flow:

Algorithm
    ↓
Execution Time
    ↓
CSV
    ↓
PerformanceGraph
    ↓
Bar Chart

🎓 Viva Questions

Q1. What is a graph?

A graph is a data structure consisting of vertices and edges.

Q2. Why did you use a graph?

Because campus locations can be represented as vertices and roads as edges.

Q3. What is a weighted graph?

A graph where each edge has an associated weight.

In this project:

Weight = Distance in meters

Q4. What is BFS?

Breadth First Search explores vertices level by level using a queue.

Q5. What is DFS?

Depth First Search explores deeply before backtracking and can be implemented using recursion.

Q6. What is Dijkstra?

Dijkstra finds shortest weighted paths when edge weights are non-negative.

Q7. What is A*?

A* is a heuristic-guided search algorithm using:

f(n) = g(n) + h(n)

Q8. What is g(n)?

The actual cost from source to current node.

Q9. What is h(n)?

The estimated cost from current node to destination.

Q10. What is a heuristic?

A heuristic estimates the remaining cost to reach the destination.

Q11. Which data structure does BFS use?

Queue

Q12. Which data structure does Dijkstra use?

PriorityQueue

Q13. Does DFS guarantee shortest path?

No.

Q14. Does BFS guarantee shortest physical distance in this project?

No, because the graph has weighted edges.

Q15. What is the time complexity of BFS?

O(V + E)

Q16. What is the time complexity of DFS?

O(V + E)

Q17. What is Dijkstra's complexity with a priority queue?

O((V + E) log V)

Q18. Why use an adjacency list?

It stores the neighbors of each vertex efficiently.

Q19. Why measure execution time?

To experimentally compare the algorithms in addition to theoretical complexity analysis.

Q20. What is the main DAA concept demonstrated?

Comparison of different algorithms for solving the same graph path-finding problem.

❌ Common Errors

Error 1

Campus data file not found

Fix

Make sure you are in:

CampusNavigation

Then:

java -cp src Main

Error 2

Could not find or load main class Main

Run:

javac src\*.java

Then:

java -cp src Main

Error 3

javac is not recognized

Check:

java -version
javac -version

You need a Java JDK installed and available in PATH.

✨ Advantages

Easy campus representation.

Real-world application of graphs.

Multiple algorithms.

Weighted path support.

Path distance calculation.

Execution-time measurement.

CSV performance results.

Graphical performance visualization.

Easy to expand.

Good for DAA practical and mini project.

Useful for viva demonstration.

⚠️ Limitations

Campus data is static.

No GPS.

No live traffic.

No mobile application.

No database.

No interactive map.

Execution time varies between runs.

A* depends on the quality and calibration of its heuristic.

🚀 Future Scope

The project can be extended into a complete campus navigation application.

Future Features

GPS
 ↓
Interactive Map
 ↓
Database
 ↓
Web Application
 ↓
Mobile Application
 ↓
Real-Time Navigation

Possible additions:

GPS integration

Interactive campus map

Login system

Database

Building search

Emergency routes

Wheelchair-accessible routes

Dynamic road weights

Real-time navigation

Mobile application

QR-based location detection

Multiple destination routing

🎤 Presentation

Recommended 15-slide presentation:

Slide

Topic

1

Title

2

Problem Definition

3

Objectives

4

Graph Representation

5

System Workflow

6

BFS

7

DFS

8

Dijkstra

9

A*

10

Implementation

11

Complexity

12

Test Case

13

Performance

14

Advantages & Future Scope

15

Conclusion

📝 Quick Revision

GRAPH
= Vertices + Edges

CAMPUS
= Locations + Roads

WEIGHT
= Distance

BFS
= Queue
= Level by Level
= O(V + E)

DFS
= Recursion / Stack
= Depth First
= O(V + E)

DIJKSTRA
= PriorityQueue
= Weighted Shortest Path
= Non-negative Weights

A*
= PriorityQueue
= f(n) = g(n) + h(n)
= Heuristic Search

🧠 One-Minute Viva Revision

Why Graph?
→ Campus locations and roads naturally form a graph.

Why Weighted Graph?
→ Roads have different distances.

Why BFS?
→ To demonstrate breadth-first traversal.

Why DFS?
→ To demonstrate depth-first traversal.

Why Dijkstra?
→ To find shortest weighted paths.

Why A*?
→ To demonstrate heuristic-guided path finding.

Why CSV?
→ To store experimental performance results.

Why Performance Graph?
→ To visually compare execution times.

Main DAA Concept?
→ Theoretical + experimental algorithm comparison.

🏁 Conclusion

The Campus Navigation & Path Finding project demonstrates the practical application of graph algorithms to a real-world campus navigation problem.

The campus is represented as an undirected weighted graph, where locations are vertices and roads are weighted edges.

The project implements:

BFS
DFS
Dijkstra
A*

It also calculates:

Path
Number of Edges
Distance
Execution Time

Finally, the project stores experimental results in CSV format and provides a performance graph.

The project therefore connects theoretical DAA concepts with a practical Java implementation.

<div align="center">

🧭 CAMPUS NAVIGATION & PATH FINDING

Java • Graph Algorithms • DAA • Path Finding

BFS • DFS • Dijkstra • A*

🎓 5th Semester DAA Mini Project

</div> ```