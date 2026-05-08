package org.se.lab;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.se.lab.metamodel.MEntity;
import org.se.lab.metamodel.MInteger;
import org.se.lab.metamodel.MString;
import org.se.lab.metamodel.MType;

import freemarker.cache.ClassTemplateLoader;
import freemarker.ext.beans.StringModel;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

public class FreeMarkerEntityGenerator {
	public void generate(MEntity entity, Path target) {
		Map<String, Object> root = constructTemplateParameters(entity);

		applyTemplate(target, root);
	}

	private void applyTemplate(Path target, Map<String, Object> root) {
		try {
			Template tmpl = getDefaultConfig().getTemplate("Entity.java");
			Writer output = Files.newBufferedWriter(target);
			tmpl.process(root, output);
			output.close();
		} catch (IOException | TemplateException ex) {
			throw new RuntimeException(ex);
		}
	}

	private Map<String, Object> constructTemplateParameters(MEntity entity) {
		Map<String, Object> root = new HashMap<>();
		root.put("entity", entity);
		addTemplateMethods(root);
		return root;
	}

	private void addTemplateMethods(Map<String, Object> root) {
		addAttributeTypeMethod(root);
	}

	private void addAttributeTypeMethod(Map<String, Object> root) {
		TemplateMethodModelEx attributeType = arguments -> {
			MType type = (MType) ((StringModel) arguments.get(0)).getWrappedObject();
			if (type instanceof MString) {
				return "String";
			} else if (type instanceof MInteger) {
				return "int";
			} else {
				throw new IllegalArgumentException("UnsupportedType: " + type.getClass().getName());
			}
		};
		root.put("attributeType", attributeType);
	}

	private Configuration getDefaultConfig() {
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
		cfg.setTemplateLoader(new ClassTemplateLoader(this.getClass().getClassLoader(), ""));
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		cfg.setLogTemplateExceptions(false);
		cfg.setWrapUncheckedExceptions(true);
		return cfg;
	}
}
