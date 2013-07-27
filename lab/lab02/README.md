lab2
===
Nothing much.

## Type Casting

* Is this similar to Coercion idea in 61a?

ref: http://stackoverflow.com/questions/1602122/casting-vs-coercion-in-python

# When to use ```private```

* Any attribute or method you expose to as public is fair game
for other classes that your co-workers make to call.
* If you leave your attribute as public, other people might take it
that you don't mind exposing your ```private variable.
* That means other developers in your team, or if you write open source
software, people who use your code think that your public attributes
are mutatable. But usually it isn't!
* Furthermore, if in the future, you want to perform some checks first,
their code will break. You should instead wrap the attribute with
a selector method. This way, if you want to make changes in the future,
their code will still be calling the same interface get method, but
you can still make changes to the underlying way of getting the
instance variable.

* In short, your attributes should never be part of the interface!
It should be gotten through an interface.
