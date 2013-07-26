lab1
===
* Nothing much in this lab.
* Learn to use the debugger: Different ways of stepping through execution
* Breaking down System.out.println()
Everything on the left of the dot is a class/object.
- *System* is a class.
- *out* is a reference variable pointing to another class, PrintStream.

Everything on the right of a dot is either an attribute or method.
- *out* is an attribute of System
- *println()* is an attribute of *out* which references to PrintStream.

* Think of 61a's evaluation of function calls and object call


** Python vs. Java OOP
* Notice that in Java, we declare the variables at the top of
the class definition. e.g. String s; 

But in python, we jump straight into the constructor and put all
instance variables there.

The reason for this is that Java is statically typed, so all
variables -- if you want to use them -- must have their type declared.

This defers from Python being dynamically typed, so you don't need
to declare the type, you just go straight into assignment.

Hence, the simple assignment in the constructor without declaration
in Python's OOP.
