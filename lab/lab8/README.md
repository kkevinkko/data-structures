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
    * Reading from the internet URL
    * Getting network connections

So you shouldn't have try-catch blocks handling your own programs..
That would mean your code is buggy and you need to fix it yourself!
Exception catching should only catch stuff that got out of your
control.

* But catching the error is one thing, the other thing you should
do is to handle it.
* A weak way (though better than doing nothing or crashing) is to
handle the error.
* How would you know how to handle it?
    * That's when you need to define exceptions!
    * When you define exception types, you can catch the different
    exception types and react accordingly.
    * The point of the catch block is to try to recover from the
    error
* To catch the error, someone must be throwing it.
* It's one of the methods in the try block that needs to implement
the ```throws``` keyword in their header.