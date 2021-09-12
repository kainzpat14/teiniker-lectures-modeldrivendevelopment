package at.fhj.mdd.ws2020;

import at.fhj.mdd.ws2020.installer.InstallExecutor;
import at.fhj.mdd.ws2020.installer.Installer;

public class ExampleInstallExecutor implements InstallExecutor {

	@Override
	public void execute(Installer installer) {
		if (!installer.output("Starting install", "Welcome to the installation of our cool product")) {
			return;
		}

		if (!installer.execute("prepareSystem.sh")) {
			return;
		}

		if (!installer.mkdir("/opt/myapplication")) {
			installer.execute("cleanupAppDir.sh");
			return;
		}

		if (!installer.copy("binary", "/opt/myapplication/binary")) {
			installer.execute("cleanupAppDir.sh");
			return;
		}

		installer.output("Success", "Your installation has been completed successfully");

	}

}
