import { inject, Module } from 'langium';
import {
    createDefaultModule,
    createDefaultSharedModule,
    DefaultSharedModuleContext,
    LangiumServices,
    LangiumSharedServices,
    PartialLangiumServices
} from 'langium/lsp';
import { EntityDslGeneratedModule, EntityDslGeneratedSharedModule } from './generated/module.js';
import { EntityDslValidator, registerValidationChecks } from './entity-dsl-validator.js';

export type EntityDslAddedServices = {
    validation: {
        EntityDslValidator: EntityDslValidator;
    };
};

export type EntityDslServices = LangiumServices & EntityDslAddedServices;

export const EntityDslModule: Module<EntityDslServices, PartialLangiumServices & EntityDslAddedServices> = {
    validation: {
        EntityDslValidator: () => new EntityDslValidator()
    }
};

export function createEntityDslServices(context: DefaultSharedModuleContext): {
    shared: LangiumSharedServices;
    EntityDsl: EntityDslServices;
} {
    const shared = inject(
        createDefaultSharedModule(context),
        EntityDslGeneratedSharedModule
    );
    const EntityDsl = inject(
        createDefaultModule({ shared }),
        EntityDslGeneratedModule,
        EntityDslModule
    );
    registerValidationChecks(EntityDsl);
    return { shared, EntityDsl };
}
