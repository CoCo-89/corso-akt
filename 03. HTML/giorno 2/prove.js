'use strict'; //impone utilizzo variabile
var contenitore = 'ABC123';
console.log(typeof contenitore);
var contenitore = 123;
console.log(typeof contenitore);
var contenitore1 = '12';
console.log(typeof contenitore1);
var contenitore2 = 4;
console.log(typeof contenitore2);
var risultato = contenitore1 * contenitore2;
console.log(risultato);
var isVerde = true;
console.log(typeof isVerde);
var o = {nome: 'Mario', eta: 25};//object literal, oggetto istanziato istantaneamente
console.log(o.nome);
console.log(typeof o);
var u;  //undefined
console.log(u); //sia valore
console.log(typeof u);  //che tipo
// var arr = [1,2,3,4];
// console.log(typeof arr);
let recipiente1 = 'abc123';
recipiente1 = 123;
console.log(typeof recipiente1);

saluta();

let saluta = function() {
    console.log('Ciao');
}


