lab8
===

How do you fall gracefully? Use Exceptions!

# Error Handling
## Where to place try catch blocks?
* Head First Java book says put it where it's "risky". But I think
that's kind of vague. We should be placing try catch blocks wherever
we're passing control out of our program.
For instance:
    * Getting user input (I/O)
    * Reading from a File (I/O)
    * Reading from an external source, e.g.URL
    * Getting network connections from operating system

So you shouldn't have try-catch blocks handling code within your control..
That would mean your code is buggy and you need to fix it yourself!
Exception catching should only catch stuff that got out of your
control.

## Exception Handling
* Catching the error is one thing, the other thing you should
do is to handle it.
* A weak way (though better than doing nothing or crashing) is to
handle the error.
* How would you know how to handle it?
    * That's when you need to define exceptions!
    * When you define exception types, you can catch the different
    exception types and react accordingly.
    * The point of the catch block is to try to recover from the
    error

## Exception Throwing
* To catch the error, someone must be throwing it.
* It's one of the methods in the try block that needs to implement
the ```throws``` keyword in their header.
* ```throw``` exception whenever it meets some criteria.

## Coupling Exceptions with Consistency Checker methods
* Consistency checker methods should throw exceptions. It should
contain all the logic that checks invariant maintenance.
* It should be called whenever you alter the state of the object. That
is, checking if the class invariants are maintained.

## Where to place consistency checkers?
* I now believe it should be placed in the JUnit tests, and not
in the production code.
    * Write a test to set up a mock situation, and call the isOK()
    method there
    * That way, you won't get isOK() calling each time during
    production
* The only time when you should place it in production code is
when the consistency checker doesn't make much of a performance
hit.
* Or put a lightweight isOK method version in the production code. Don't
include too many checks there. Or try to simplify to just a single
invariant to check.
