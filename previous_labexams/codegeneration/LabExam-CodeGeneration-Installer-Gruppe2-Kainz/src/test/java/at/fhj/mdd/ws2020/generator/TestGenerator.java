package at.fhj.mdd.ws2020.generator;

import org.junit.Assert;
import org.junit.Test;

import at.fhj.mdd.ws2020.InstallerBuilder;
import at.fhj.mdd.ws2020.MyInstallExecutor;
import at.fhj.mdd.ws2020.installer.VirtualInstaller;
import at.fhj.mdd.ws2020.metamodel.MInstaller;

public class TestGenerator {

	// @formatter:off
	private static final String EXPECTED_OUTPUT = ""+
			"Welcome\n" + 
			"Welcome to our installation\n" + 
			"#>preSetup.sh\n" + 
			"#mkdir /opt/myfolder\n" + 
			"#>downloadMySoftware.sh\n" + 
			"#>byebye.sh";
	// @formatter:on

	@Test
	public void testGenerator() {
		// @formatter:off
		MInstaller install = new InstallerBuilder()
				.preSetup()
					.print("Welcome", "Welcome to our installation")
					.execute("preSetup.sh")
				.setup()
					.mkdir("/opt/myfolder").cleanup().execute("cleanUpMyFolder.sh")
					.execute("downloadMySoftware.sh").cleanup().execute("cleanUpMyFolder.sh")
				.cleanup()
					.execute("byebye.sh")
				.toInstaller();
		// @formatter:on
		new InstallExecutorGeneratorVisitor().visit(install);
	}

	@Test
	public void testGeneratedExecutor() {
		VirtualInstaller installer = new VirtualInstaller();
		new MyInstallExecutor().execute(installer);
		Assert.assertEquals(normalize(EXPECTED_OUTPUT), normalize(installer.getOutput()));
	}

	private String normalize(String text) {
		return text.trim().replaceAll("\r", "");
	}

}
