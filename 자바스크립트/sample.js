
var person // 변수 선언
person = 'jieun' // 값의 할당
var person = 'jieunOh' // 변수 선언과 할당

let person = 'jieun' // 값의 할당
person = "jjieun"; // 값의 재할당
// let person = 'jieunOh' -> 불가 !

const person = 'jieun' // 값의 할당
// person = "jjieun"; // 값의 재할당 -> 불가 !
// lconst person = 'jieunOh' -> 불가 !

console.log(person); // undefined
var person; // 변수 선언
person = 'jieun'; // 값의 할당
console.log(person); // jieun

console.log(student); // ReferenceError: student is not defined
let student = "jieunOh";
console.log(student); // jieunOh