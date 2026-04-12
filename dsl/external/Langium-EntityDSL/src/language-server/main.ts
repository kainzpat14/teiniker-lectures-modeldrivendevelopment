import { startLanguageServer } from 'langium/lsp';
import { NodeFileSystem } from 'langium/node';
import { createConnection, ProposedFeatures } from 'vscode-languageserver/node.js';
import { createEntityDslServices } from '../language/entity-dsl-module.js';

const connection = createConnection(ProposedFeatures.all);

const { shared, EntityDsl } = createEntityDslServices({ connection, ...NodeFileSystem });
shared.ServiceRegistry.register(EntityDsl);

startLanguageServer(shared);
