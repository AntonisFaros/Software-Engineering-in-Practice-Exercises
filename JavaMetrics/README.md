# Grade Histogram
A java application in order to create a histogram from a txt file containing grades.

# Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes

### Installation
* You need to build the application using(make sure you're on the right directory): 

```
cd Software-Engineering-in-Practice-Exercises/JavaMetrics
```

```
mvn package
```
* After you have built the jar you can run it by using :

```
java -jar JavaMetrics-0.0.1-SNAPSHOT.jar  [sourcefile] [string or regex]
```
* The program will create a file name metricc.txt containing all the calculated metrics into tmp/test which will be made into the root folder.

### UML Diagram
* [JavaMetrics](JavaMetrics.pdf)