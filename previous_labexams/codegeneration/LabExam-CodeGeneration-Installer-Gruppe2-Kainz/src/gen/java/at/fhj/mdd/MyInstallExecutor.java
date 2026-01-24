package at.fhj.mdd;

import at.fhj.mdd.installer.InstallExecutor;
import at.fhj.mdd.installer.Installer;

public class MyInstallExecutor implements InstallExecutor {

	@Override
	public void execute(Installer installer) {
		if(!installer.output("Welcome","Welcome to our installation")) {
			return;
		}
		if(!installer.execute("preSetup.sh")) {
			return;
		}
		if(!installer.mkdir("/opt/myfolder")) {
			installer.execute("cleanUpMyFolder.sh");			return;
		}
		if(!installer.execute("downloadMySoftware.sh")) {
			installer.execute("cleanUpMyFolder.sh");			return;
		}
		installer.execute("byebye.sh");
	}
}
