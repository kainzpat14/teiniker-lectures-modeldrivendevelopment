import { beforeAll, describe, expect, test } from "vitest";
import { EmptyFileSystem, type LangiumDocument } from "langium";
import { expandToString as s } from "langium/generate";
import { parseHelper } from "langium/test";
import type { Model } from "dto-definition-language";
import { createDtoDefinitionServices, isModel } from "dto-definition-language";

let services: ReturnType<typeof createDtoDefinitionServices>;
let parse:    ReturnType<typeof parseHelper<Model>>;
let document: LangiumDocument<Model> | undefined;

beforeAll(async () => {
    services = createDtoDefinitionServices(EmptyFileSystem);
    parse = parseHelper<Model>(services.DtoDefinition);

    // activate the following if your linking test requires elements from a built-in library, for example
    // await services.shared.workspace.WorkspaceManager.initializeWorkspace([]);
});

describe('Parsing tests', () => {

    test('parse simple Model', async () => {
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

        // check for absence of parser errors the classic way:
        //  deactivated, find a much more human readable way below!
        // expect(document.parseResult.parserErrors).toHaveLength(0);

        expect(
            // here we use a (tagged) template expression to create a human readable representation
            //  of the AST part we are interested in and that is to be compared to our expectation;
            // prior to the tagged template expression we check for validity of the parsed document object
            //  by means of the reusable function 'checkDocumentValid()' to sort out (critical) typos first;
            checkDocumentValid(document) || s`
                DTOs:
                  ${document.parseResult.value?.dtos?.map(dto => dto.name)?.join('\n')}
            `
        ).toBe(s`
            DTOs:
              Person
              Student
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
