
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

function getType(attribute) {
    if(attribute.type == MType.int) {
        return "int"
    } else if(attribute.type == MType.string) {
        return "String"
    } else {
        throw "Unsupported type: "+attribute.type;
    }
}

const Handlebars = require("handlebars");
const fs = require('fs')
Handlebars.registerHelper('capitalize',capitalizeFirstLetter)
Handlebars.registerHelper('decapitalize',decapitalizeFirstLetter)
Handlebars.registerHelper('getType',getType)

let templateString = fs.readFileSync("entity.handlebars")
let template = Handlebars.compile(templateString.toString());
console.log(template({entity: {
        name: "MyEntity",
        attributes: [
            {name: "intAttr",type: MType.int},
            {name: "strAttr",type: MType.string}
        ]
    }}))