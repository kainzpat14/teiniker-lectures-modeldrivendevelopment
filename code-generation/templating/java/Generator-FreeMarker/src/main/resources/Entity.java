<#macro variableDeclaration attribute>${attributeType(attribute.type)} ${attribute.name?uncap_first}</#macro>
<#macro variableAssignment attribute>		this.${attribute.name?uncap_first} = ${attribute.name?uncap_first};
</#macro>

package org.se.lab;

@Entity
@Table(name = "${entity.name?upper_case}")
public class ${entity.name?cap_first} {
	<#list entity.properties as attribute> 
	<#if attribute.id>
	@Id
	</#if>
	private ${attributeType(attribute.type)} ${attribute.name?uncap_first};
	
	public void set${attribute.name?cap_first}(<@variableDeclaration attribute/>) {
		<@variableAssignment attribute/>
	}
	
	public ${attributeType(attribute.type)} get${attribute.name?cap_first}() {
		return ${attribute.name?uncap_first};
	}
	
	</#list>
	
	public ${entity.name?cap_first}(<#list entity.properties as attribute><@variableDeclaration attribute/><#sep>, </#list>) {
		<#list entity.properties as attribute> 
		<@variableAssignment attribute/>
		</#list>
	}
}