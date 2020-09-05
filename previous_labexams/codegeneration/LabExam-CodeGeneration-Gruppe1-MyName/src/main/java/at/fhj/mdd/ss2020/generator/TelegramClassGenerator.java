package at.fhj.mdd.ss2020.generator;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import at.fhj.mdd.ss2020.metamodel.MTelegram;
import at.fhj.mdd.ss2020.metamodel.MTelegrams;

public class TelegramClassGenerator extends AbstractTelegramVisitor {

	private String pkg;
	private String basePath;
	private PrintWriter currentWriter;
	private Path target;

	public TelegramClassGenerator(String pkg, String basePath) {
		this.pkg = pkg;
		this.basePath = basePath;
	}

	@Override
	public void visit(MTelegrams telegrams) {
		String path = pkg.replace(".", "/");
		target = Paths.get(basePath, path);
		if (!Files.exists(target)) {
			try {
				Files.createDirectories(target);
			} catch (IOException ex) {
				throw new RuntimeException("Could not create directory " + target, ex);
			}
		}
		super.visit(telegrams);
	}

	public void visit(MTelegram telegram) {
		try {
			currentWriter = new PrintWriter(
					Files.newBufferedWriter(target.resolve(telegram.getName() + "Telegram.java")));
			// TODO: implement
			currentWriter.close();
		} catch (IOException ex) {
			throw new RuntimeException("Could not write telegram " + telegram.getName(), ex);
		}
	}

}
