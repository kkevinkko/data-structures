// in JS, both the array's SIZE and TYPE is dynamic.
//
// ARRAY LITERAL notation
var arr = [];
// or, ARRAY OBJECT Construction: 1 arg => size of array
var arr = new Array(10);
// or, ARRAY OBJECT Construction: >1 args => elements to pass to constructor
var arr = new Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);


// ACCESS <=> GET
//
arr[0] // get first element
arr[arr.length - 1] // get last element (JS arrays have length property)

// SET
// Notice that you can SET as long as you can GET; Just do an Assignment!
arr[0] = 1;

// TODO: Look for backward compatibility ways of iterating
