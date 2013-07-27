lab19
===

* More Hashing
* Memoisation
* Binary Search

# Lab Exercises
## Activity 1: Hashing Tic-Tac-Toe Boards
* Basically, we have to *write* and *time* 2 Hash Functions that takes in
Tic-Tac-Toe boards.
1. Input is a String representation of the board. Then pass that
through String.hashcode().
    * Function takes 95-99 seconds to hash.
    * At first I thought how should I represent the string. I think
    just try to keep the parts that make the string unique, you'll
    be fine.
2. Input is a base 3 representation of the board. Same as String rep,
except change X's to 1, O's to 2, -'s to 0.
    * Function takes about 12x seconds to hash
    * I did a character replace using the map above, and then just
    did an Integer.parse on it. Lol.
