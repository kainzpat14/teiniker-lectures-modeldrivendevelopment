import { ValidationAcceptor, ValidationChecks } from 'langium';
import { EntityDslAstType, Entity, Model } from './generated/ast.js';
import type { EntityDslServices } from './entity-dsl-module.js';

export function registerValidationChecks(services: EntityDslServices): void {
    const registry = services.validation.ValidationRegistry;
    const validator = services.validation.EntityDslValidator;
    const checks: ValidationChecks<EntityDslAstType> = {
        Entity: validator.checkEntityNameStartsWithCapital,
        Model:  validator.checkUniqueEntityNames
    };
    registry.register(checks, validator);
}

export class EntityDslValidator {

    checkEntityNameStartsWithCapital(entity: Entity, accept: ValidationAcceptor): void {
        if (entity.name) {
            const firstChar = entity.name.substring(0, 1);
            if (firstChar.toUpperCase() !== firstChar) {
                accept('warning', 'Entity name should start with a capital letter.', {
                    node: entity,
                    property: 'name'
                });
            }
        }
    }

    checkUniqueEntityNames(model: Model, accept: ValidationAcceptor): void {
        const seen = new Set<string>();
        for (const entity of model.entities) {
            if (seen.has(entity.name)) {
                accept('error', `Duplicate entity name '${entity.name}'.`, {
                    node: entity,
                    property: 'name'
                });
            }
            seen.add(entity.name);
        }
    }
}
