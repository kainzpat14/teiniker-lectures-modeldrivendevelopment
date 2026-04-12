import { afterEach, beforeAll, describe, expect, test } from "vitest";
import { EmptyFileSystem, type LangiumDocument } from "langium";
import { expandToString as s } from "langium/generate";
import { clearDocuments, parseHelper } from "langium/test";
import type { DtoReference, Model } from "dto-definition-language";
import { createDtoDefinitionServices, isModel, isSimpleType, SimpleType } from "dto-definition-language";

let services: ReturnType<typeof createDtoDefinitionServices>;
let parse:    ReturnType<typeof parseHelper<Model>>;
let document: LangiumDocument<Model> | undefined;

beforeAll(async () => {
    services = createDtoDefinitionServices(EmptyFileSystem);
    parse = parseHelper<Model>(services.DtoDefinition);

    // activate the following if your linking test requires elements from a built-in library, for example
    // await services.shared.workspace.WorkspaceManager.initializeWorkspace([]);
});

afterEach(async () => {
    document && clearDocuments(services.shared, [ document ]);
});

describe('Linking tests', () => {

    test('linking of DTOS', async () => {
        document = await parse(`
            dto Person {
                firstName: String
                lastName: String
            }

            dto Student {
                person: Person
                matNr: Int
            }
        `);

        expect(
            // here we first check for validity of the parsed document object by means of the reusable function
            //  'checkDocumentValid()' to sort out (critical) typos first,
            // and then evaluate the cross references we're interested in by checking
            //  the referenced AST element as well as for a potential error message;
            checkDocumentValid(document)
                || document.parseResult.value.dtos.map(dto => dto.name+"("+dto.fields.map(field => field.name + ":" + (isSimpleType(field.type)?(field.type as SimpleType).type:(field.type as DtoReference).ref.ref!.name)).join(",")+")").join('\n')
        ).toBe(s`
            Person(firstName:String,lastName:String)
            Student(person:Person,matNr:Int)
        `);
    });
});

function checkDocumentValid(document: LangiumDocument): string | undefined {
    return document.parseResult.parserErrors.length && s`
        Parser errors:
          ${document.parseResult.parserErrors.map(e => e.message).join('\n  ')}
    `
        || document.parseResult.value === undefined && `ParseResult is 'undefined'.`
        || !isModel(document.parseResult.value) && `Root AST object is a ${document.parseResult.value.$type}, expected a 'Model'.`
        || undefined;
}
