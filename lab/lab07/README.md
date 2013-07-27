lab7
===

* Covered Inheritance
* More importantly, Interfaces.

# Inheritance
## Why inheritance?
* Inheritance is a lot more than just preventing you from
copy and pasting code, and then editing to suit your needs *today*.
* It's the powerful idea that, if you do have to make changes
to your children objects *in the future*, you only need to change the
parent class then all children will automatically inherit the new change.
* And all you had to do is formally define the relationship
between classes at the start!
* It also makes making new objects a lot easier; just write the delta
methods or instance variables that differs from an existing object. This
**code reuse** is possible mainly due to **overriding**.

## Good Use Case
* The kind of things you want to inherit from is like libraries. Libraries
have well-tested code, you want them to inherit all their goodness.
* And especially if there is a large open source community working on that
library, you automatically inherit any changes that they make...
your code gets upgraded **without making any changes to your current code**!

# Interfaces
## What good is an interface if it's just a bunch of method signatures?
* Indeed, it would be useless in a language like Python.
* In Java, interface is a language construct.
* By explicitly saying that your class ```implements``` an interface,
you can take advantage of the compiler checking that promise. It ensures that
your class **promises** whatever that it says it will be (an interface of).
* If you promise that your object will be able to iterate, then Java
compiler will ensure that you do implement all the methods that make an
object an iterable object.
* Java is able to formally check this interface adherence. Many
languages don't have ways to enforce this interface idea formally.

## Good Use Case
* You want to declare that your object is a certain kind of thing. e.g.
it is a stack, etc.
* Then when other methods that take in Stacks as arguments,
you can pass in your object since it is technically a stack.
* http://stackoverflow.com/questions/90851/is-creating-interfacesfor-almost-every-class-justified-or-are-interfaces-overus?rq=1
* See iCanHazCheeseBurgerz example

# Callbacks
* Just the idea that a program calls a function, which will callback
another function.
