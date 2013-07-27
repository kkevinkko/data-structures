lab4
===

## Arrays

```java
int[] simpleIntArray;
Integer[] intObjectArray;
Object[] objectArray;
Place[] placeArray;
```

* An array is a chunk of memory that is created to keep an **indexed**
collection of things (objects or primitives)
* Notice, it is like creating multiple lines of 
variable declaration except you refer to them via **indices**
```someArray[index]``` rather than their variable names ```someVariable1``` alone.
* Semantically, you are also declaring that a group of variables
together should be grouped in a common group name.

### Pros
* The fact that the group of variables are indexed means you can
jump to specific ones quickly, if you know the index key.
* This allows *random access* as opposed to sequential access. (http://en.wikipedia.org/wiki/Random_access)

### Cons
+ Arrays sizes are fixed. (Don't confuse with ArrayLists). So
you gotta know exactly how big a chunk of memory you need to reserve
for this array structure. If you want something expandable, use
one of the list variants.

### Size Declaration
* Notice Java doesn't require you to declare the size of the
array when you declare the variable type.
* instead, you declare the size during instantiation.

```java
placeArray = new Place[13];
```

### Filling in the (Array) blanks
* The instantiation of a size 13 array is akin to writing a bunch of 13
consecutive declaration statements -- we've only declared to Java that
we're using this space as a collection of integers. But haven't actually
given any of them values.

```java
placeArray = new Place[7];
```
is similar to
```java
Place place1;
Place place2;
Place place3;
Place place4;
Place place5;
Place place6;
Place place7;
```

which makes sense, why should Java instantiate Places for you?
How would it know which constructor to call?? It needs to separate
declaration from instantiation!

* The same thing applies to primitive values, exception they don't
get instantiated, but are given default values automatically.

* Give them values by assigning to the indices
```java
placeArray[0] = new Place(ant);
placeArray[1] = new Place(ant, someExit);
```

## Java vs Python Array/List similaries

* In Python, you can access items from the back via negative indices.
* Don't try to do that in Java. Will result in exception.

## Common Code
* Since instantiation is decoupled from declaration, you'll find
that although you can declare multiple statements with one line
```placeArray = new Place[1000000]```, you can't do the same
for assigments.
* So use a loop construct to quickly initialise all 1000000 of them.

```java
for (int i = 0; i < placeArray.length; i++) {
    placeArray[i] = new Place();
}
```

### To read arguments Array from main(String[] args)
```java
for (int i = 0; i < args.length; i++) {
    System.out.println(args[i])
}
```
