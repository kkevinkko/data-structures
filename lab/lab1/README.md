lab1
===
* Nothing much in this lab.

## Debugger
* Learn to use the debugger: Different ways of stepping through execution

## Object Call Expression
* Breaking down an object call expression: *System.out.println()*

* Everything on the left of the dot is a class/object.
- *System* is a class.
- *out* is a reference variable pointing to another class, PrintStream.

* Everything on the right of a dot is either an attribute or method.
- *out* is an attribute of System
- *println()* is an attribute of *out* which references to PrintStream.

* Think of 61a's evaluation of function calls and object call (
subexpressions evaluated from left to right)


## Python vs. Java OOP
* Notice that in Java, we declare the variables at the top of
the class definition. e.g. String s; 

```java
public class Ant {
    String name;
    Place exit;

    public Ant(String name, Place exit = null) {
        this.name = name;
        this.exit = exit;
    }
}
```

But in python, we jump straight into the constructor and put all
instance variables *assignments* there.

```python
class Ant(Object):
    def __init__(self, name, exit=None):
        self.name = name
        self.exit = exit
```

The reason for this is that Java is a statically-typed language, so all
variables must have their type declared.

This defers from Python being dynamically-typed language, meaning you
don't need to declare the type, you just go straight into assignment.

Hence, the simple assignment in the constructor without declaration
in Python's OOP.

* Other differences

Feature | Java | Python
--- | --- | ---
Constructor | is a method with name of the class. | is the ```__init__``` magic method
Referencing self | Implicitly passes the ```this``` keyword in method definition | need to explicitly pass ```self``` (or anything else you like) to all methods definitions
Inheritance | Use ```extends``` keyword | Takes in the parent class as argument in class definition

## When to use ```this```

* Use it when you need to resolve conflicts between **local variable
and/or parameter names**, and the object's **attribute names**.

Suppose Human class has 2 attributes, ```age``` and ```name```

```java
public void change(int age) {
    String name = "Chang";

    this.name = name; // to resolve conflict in local variable name
    this.age = age; // to resolve conflict in parameter name
}
```

* Obviously, this means that local variable names and
formal parameter bindings gets looked up first before
instance variable names. (Think environment diagram)

## When to use ```static```

* Think environment diagrams:

* (This might not be entirely correct, but it helps to think about
environment extension)

Suppose you've just instantiated an object that has static variables/methods.

* You first extend the global environment by creating an object for
**the class itself**. (Class Object)
* Then you *extend the environment further* when you create an instance of the
object itself.

* The static variables/methods are probably stored in the "Class Object"
* The non-static variables/methods are stored in the instance itself.

* So use ```static``` when you need every instance object to
share a common class' variable or method.

* Implications: There is no ```this``` in a ```static``` method.
* You use ```static``` methods when a method doesn't depend
on any particular instance of the class, but still belongs to the
class as a whole.

## Lifetime of variables

* Local variables die when method call is done.
* Instance variables die when object is removed from heap.
* Static variables die when program ends. (since the Class is
there throughout the entire program execution)
