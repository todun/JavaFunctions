# README #

## Running tests
1. open terminal in project root : `cd /path/to/project/root`
2. run tests(maven build tool must be installed): `mvn clean test`

### requirements
1. Java 6+
2. maven build tool

### Requirement 1 ###

Write an  extension method  on string called IsNullOrEmpty.

Sample Inputs	|	Sample Outputs
-------------:	|	--------------:
null			|	true
“a”				|	false
“”				|	true
“null”			|	false

### Requirement 2 ###

Write a function that takes a single positive integer, and returns a collection / sequence of integers. The return value should contain those integers that are  positive divisors  of the input integer.

Sample Inputs	|	Sample Outputs
:-------------:	|	:--------------
60				|	{1, 2, 3, 4, 5, 6, 10, 12, 15, 20, 30, 60}
42				|	{1, 2, 3, 6, 7, 14, 21, 42}


### Requirements 3 ###

Write a function that takes three integer inputs and returns a single output. The inputs are the lengths of the sides of a triangle. The output is the area of that triangle.

Sample Inputs								|	Sample Outputs
:-------------:								|	:--------------:
3,4,5										|	6
Any inputs that are negative				|	(throw) InvalidTriangleException
Inputs that cannot form a valid triangle	|	(throw) InvalidTriangleException


### Requirements 4 ###

Write a function that takes an array of integers, and returns an array of integers. The return value should contain those integers which are most common in the input array.

Sample Inputs									|	Sample Outputs
-------------									|	--------------
{5, 4, 3, 2, 4, 5, 1, 6, 1, 2, 5, 4}			|	{5, 4}  *
{1, 2, 3, 4, 5, 1, 6, 7}						|	{1}
{1, 2, 3, 4, 5, 6, 7}							|	{1, 2, 3, 4, 5, 6, 7}

>>> note that order of the elements in the return array is not significant - so {5, 4} or {4, 5} is fine

### References ###

- Javadocs
- Stackoverflow
- Apache Commons Hash Bag