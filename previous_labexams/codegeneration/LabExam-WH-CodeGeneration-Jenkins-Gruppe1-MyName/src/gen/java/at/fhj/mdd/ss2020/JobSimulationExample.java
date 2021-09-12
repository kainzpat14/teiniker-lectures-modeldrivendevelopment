package at.fhj.mdd.ss2020;

import java.util.Arrays;

import at.fhj.mdd.ss2020.simulator.IJobSimulation;
import at.fhj.mdd.ss2020.simulator.JenkinsSimulator;

public class JobSimulationExample implements IJobSimulation {

	@Override
	public void simulate(JenkinsSimulator simulator) {
		while (!simulator.isVersionUpdated("https://github.com/me/mycoolproject.git")) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				/* ignored */ }
		}

		if (prebuild(simulator)) {
			build(simulator);
		}

		postbuild(simulator);

	}

	public boolean prebuild(JenkinsSimulator simulator) {
		if (!simulator.executeShell("/root/prepareJava.sh")) {
			return false;
		}
		if (!simulator.executeShell("/root/prepareMaven.sh")) {
			return false;
		}
		return true;
	}

	public boolean build(JenkinsSimulator simulator) {
		if (!simulator.maven("clean")) {
			return false;
		}
		if (!simulator.maven("install deploy")) {
			return false;
		}
		return true;
	}

	public boolean postbuild(JenkinsSimulator simulator) {
		if (!simulator.executeShell("/root/prepareMail.sh")) {
			return false;
		}
		if (!simulator.sendMail(Arrays.asList("me@me.com"))) {
			return false;
		}
		return true;
	}

}
