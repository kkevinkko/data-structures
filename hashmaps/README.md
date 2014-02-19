# Hash Maps

Essence of Hash Map
* Standard Arrays are indexed by integers, Hash Maps maps a Key (usually a string?) to an index in a standard Array.
* The best part of Arrays are its computable addresses for O(1) access --
hash maps take cleverly chosen Keys and returns an index to an array.

Source: http://en.wikipedia.org/wiki/Hash_table

The idea of hashing is to distribute the entries (key/value pairs) across an array of buckets. Given a key, the algorithm computes an index that suggests where the entry can be found:

index = f(key, array_size)

Often this is done in two steps:

hash = hashfunc(key)
index = hash % array_size
