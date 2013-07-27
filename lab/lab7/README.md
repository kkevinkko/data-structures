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
