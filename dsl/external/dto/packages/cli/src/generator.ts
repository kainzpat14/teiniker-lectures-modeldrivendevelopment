import { DTO, DtoReference, isSimpleType, SimpleType, type FieldType, type Model } from 'dto-definition-language';
import { toString } from 'langium/generate';
import * as fs from 'node:fs';
import * as path from 'node:path';
import { extractDestinationAndName } from './util.js';
import Handlebars from 'handlebars';

export function generateJava(model: Model, filePath: string, destination: string | undefined): string[] {
    const data = extractDestinationAndName(filePath, destination);
    const generatedFiles : string[] = [];
    for(const dto of model.dtos) {
        //later location of dto file in project src/main/dto, so java is in src/main/java/at/fhj
        const generatedFilePath = `${path.join(data.destination, "../src/main/java/at/fhj/",dto.name)}.java`;
        const parentPath = path.dirname(generatedFilePath);
        fs.mkdirSync(parentPath, { recursive: true });

        const fileNode = dtoToStringHandlebars(dto);

        if (!fs.existsSync(data.destination)) {
            fs.mkdirSync(data.destination, { recursive: true });
        }
        fs.writeFileSync(generatedFilePath, toString(fileNode));
        generatedFiles.push(generatedFilePath);
    }
    return generatedFiles;

}

function dtoToStringHandlebars(dto: DTO) {
    const templatePath = path.resolve("src", 'dto.hbs');
    const templateContent = fs.readFileSync(templatePath, 'utf-8');
    Handlebars.registerHelper('toJavaType', (type: FieldType) => toJavaType(type));
    const template = Handlebars.compile(templateContent);
    return template(dto);
}

/*
function dtoToString(dto: DTO) {
    return expandToString`
            package at.fhj;

            public record ${dto.name} (${dto.fields.map(field => fieldToString(field)).join(",")})
        `;
}

function fieldToString(field: Field) : string {
    return `${toJavaType(field.type)} ${field.name}`;
}*/

function toJavaType(type: FieldType) : string{
    if(isSimpleType(type)) {
        if((type as SimpleType).type == "Int") {
            return "Integer";
        }
        return (type as SimpleType).type;
    }
    return (type as DtoReference).ref.ref!.name;
}

