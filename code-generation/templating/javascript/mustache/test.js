
const MType = {
    int: 1,
    string: 1
}

// https://stackoverflow.com/questions/1026069/how-do-i-make-the-first-letter-of-a-string-uppercase-in-javascript
function capitalizeFirstLetter(string) {
    return string.charAt(0).toUpperCase() + string.slice(1);
}

function decapitalizeFirstLetter(string) {
    return string.charAt(0).toLowerCase() + string.slice(1);
}

function getType(type) {
    if(type == MType.int) {
        return "int"
    } else if(type == MType.string) {
        return "String"
    } else {
        throw "Unsupported type: "+type;
    }
}

var Mustache = require('mustache');
const fs = require('fs')

let templateString = fs.readFileSync("entity.mustache")
console.log(Mustache.render(templateString.toString(),{
    entity: {
        name: "MyEntity",
        attributes: [
            {name: "intAttr",type: getType(MType.int), last: false},
            {name: "strAttr",type: getType(MType.string), last: true}
        ]
    }, capitalize : function() {
        return function(text,render) {
            return capitalizeFirstLetter(render(text));
        }
    },decapitalize : function() {
        return function(text,render) {
            return decapitalizeFirstLetter(render(text));
        }
    }}))