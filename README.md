An application which identifies the type of a triangle: Equilateral, Scalene, or Isosceles, from a given input.
It takes parameters from the user which represents the sides of a triangle.

## How to use
+ Build application.
+ Using command prompt or terminal, execute jar file.
+ Program waits and accepts input, separated by spaces, and interprets it as sides of a polygon (e.g., 33 33 10)
+ Application identifies what type of triangle it is: (Equilateral)


### Program Design

#### Extendability
The program is designed to be extensible in such a way that it can also identify other forms of a polygon,
if such a requirement will exist in the future.

#### Polymorphism
Since the program promises extendability, the application applies the Strategy Pattern when deciding which algorithm or code to execute when identifying the type of a polygon.


It is expected that different polygons will have different ways of determining polygon types. This means that, different polygon classifiers will have their own code implementations to determine the type.

The program is designed in a way that new implementations of identifying polygon types can just be "plugged in" and, by applying strategy pattern, it is determined at runtime (i.e., when user provides input), which code implementation/algorithm should be used.