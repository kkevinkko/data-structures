/**
 * Such a simple structure. Think of your interview. Before thinking
 * trees/graphs, start with a simple list (array), then think of records.
 * Then combining an Array of Records, you can use a 2D Array.
 */

// One implementation in JS - Use Object Literal

var tuple_object = {
    name : "property a",
    mark : 28,
    mark2 : 90
};

// Another implementation in JS - Use Arrays (Associative)

var tuple_array = [];

tuple_array["name"] = "property b";
tuple_array["mark"] = 28;
tuple_array["mark2"] = 90;

/**
 * Although, ref http://andrewdupont.net/2006/05/18/javascript-associative-arrays-considered-harmful/
 *
 * Explains the case for using Objects Over Arrays for Associative Arrays.
 */


// Should modify the object to prevent mutability.

console.log(tuple_object);
console.log(tuple_array);


