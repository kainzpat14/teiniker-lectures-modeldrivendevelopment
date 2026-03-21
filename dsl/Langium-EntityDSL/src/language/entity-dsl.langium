grammar EntityDsl

entry Model:
    entities+=Entity*;

Entity:
    'entity' name=ID '{'
        members+=Member*
    '}';

Member:
    Property | Relationship;

Property:
    name=ID ':' type=PrimitiveType;

Relationship:
    name=ID '->' target=[Entity];

PrimitiveType returns string:
    'string' | 'int' | 'boolean' | 'float' | 'date';

hidden terminal WS:         /\s+/;
hidden terminal ML_COMMENT: /\/\*[\s\S]*?\*\//;
hidden terminal SL_COMMENT: /\/\/[^\n]*/;

terminal ID: /[_a-zA-Z][\w_]*/;
