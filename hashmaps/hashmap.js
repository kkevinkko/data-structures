/**
 *
 * Suppose we have MANY objects in a list,
 * and we want to access a particular object in O(1),
 *
 * Do we want to run through the entire list to find it? Nope.
 *
 * We can use hash map to JUMP straight to it if we find a suitable key
 * in the object to hash into an index.
 *
 *
 */

var hashmap = {};

var obj1 = {
    "name" : "Anderson",
    "mark" : 97
};

// to hashmap.put(elem) as in java, just assign like to an associative array.

// put key/value pair
hashmap["p"] = "some value";
hashmap[obj1.name] = obj1;

// check if key in hashmap
console.log("p" in hashmap);

// remove key/value pair
delete  hashmap["p"];

console.log("p" in hashmap);

// get value via key in O(1) [because objects in JS are implemented as hash maps]

console.log(hashmap["Anderson"]);
