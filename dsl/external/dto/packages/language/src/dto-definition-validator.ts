import type {  ValidationAcceptor, ValidationChecks } from 'langium';
import type { DTO, DtoDefinitionAstType } from './generated/ast.js';
import type { DtoDefinitionServices } from './dto-definition-module.js';

/**
 * Register custom validation checks.
 */
export function registerValidationChecks(services: DtoDefinitionServices) {
    const registry = services.validation.ValidationRegistry;
    const validator = services.validation.DtoDefinitionValidator;
    const checks: ValidationChecks<DtoDefinitionAstType> = {
        DTO: validator.checkFieldNameUnqiue
        //Person: validator.checkPersonStartsWithCapital
    };
    registry.register(checks, validator);
}

/**
 * Implementation of custom validations.
 */
export class DtoDefinitionValidator {
    checkFieldNameUnqiue(dto : DTO, accept: ValidationAcceptor): void {
        var usedFields = new Set();
        for(let field of dto.fields) {
            if(usedFields.has(field.name)) {
                accept('error', field.name+" is used more than once in dto "+dto.name, {node: field, property: 'name'})
            }
            usedFields.add(field.name)
        }
    }
    /*checkPersonStartsWithCapital(person: Person, accept: ValidationAcceptor): void {
        if (person.name) {
            const firstChar = person.name.substring(0, 1);
            if (firstChar.toUpperCase() !== firstChar) {
                accept('warning', 'Person name should start with a capital.', { node: person, property: 'name' });
            }
        }
    }*/

}
