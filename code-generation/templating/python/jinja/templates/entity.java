{% macro type(attribute) -%}{% if attribute.type == MType.INT %}int{% else %}String{% endif %}{%- endmacro %}
{% macro parameter(attribute) -%}{{type(attribute)}} {{decapitalize(attribute.name)}}{%- endmacro %}
package org.se.lab;

public class {{entity.name.capitalize()}} {
    {% for attribute in entity.attributes %}
    private {{type(attribute)}} {{decapitalize(attribute.name)}};

    public {{type(attribute)}} get{{attribute.name.capitalize()}}() {
        return this.{{decapitalize(attribute.name)}};
    }

    public void set{{attribute.name.capitalize()}}({{parameter(attribute)}}) {
        this.{{decapitalize(attribute.name)}} = {{decapitalize(attribute.name)}};
    }
    {% endfor %}

    public {{entity.name.capitalize()}}({% for attribute in entity.attributes %}{{parameter(attribute)}}{{ ", " if not loop.last else "" }} {% endfor %}) {
        {% for attribute in entity.attributes %}
        this.{{decapitalize(attribute.name)}} = {{decapitalize(attribute.name)}};
        {% endfor %}
    }
}