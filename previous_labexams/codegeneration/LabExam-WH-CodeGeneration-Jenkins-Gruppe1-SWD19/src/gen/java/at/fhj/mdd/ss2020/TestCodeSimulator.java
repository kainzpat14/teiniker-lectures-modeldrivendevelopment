package at.fhj.mdd.ss2020;

import java.util.Arrays;
import at.fhj.mdd.ss2020.simulator.IJobSimulation;
import at.fhj.mdd.ss2020.simulator.JenkinsSimulator;

public class TestCodeSimulator implements IJobSimulation {

	@Override
	public void simulate(JenkinsSimulator simulator) {
		while (!simulator.isJobExecuted("BuildCode")) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) { /* ignored */ }
		}

		if (prebuild(simulator)) {
			build(simulator);
		}

		postbuild(simulator);
	}

	public boolean prebuild(JenkinsSimulator simulator) {
		if (!simulator.executeShell("/root/startSystem.sh")) {
			return false;
		}
		return true;
	}

	public boolean build(JenkinsSimulator simulator) {
		if (!simulator.maven("test")) {
			return false;
		}
		return true;
	}

	public boolean postbuild(JenkinsSimulator simulator) {
		if (!simulator.sendMail(Arrays.asList("me@me.com","you@you.com"))) {
			return false;
		}
		return true;
	}

}
