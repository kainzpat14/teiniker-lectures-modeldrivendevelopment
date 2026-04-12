grammar DtoDefinition

entry Model:
    (dtos+=DTO)*;

DTO:
    'dto' name=ID '{'
        fields+=Field+
    '}';

Field:
    name=ID ':' type=FieldType 
    ;

FieldType:
    SimpleType   | DtoReference
;

SimpleType:
    type=('String'|'Int'|'Double'|'Boolean')
    ;

DtoReference: ref=[DTO];


hidden terminal WS: /\s+/;
terminal ID: /[_a-zA-Z][\w_]*/;

hidden terminal ML_COMMENT: /\/\*[\s\S]*?\*\//;
hidden terminal SL_COMMENT: /\/\/[^\n\r]*/;
