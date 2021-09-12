package at.fhj.mdd.ss2020.generator;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import at.fhj.mdd.ss2020.JobSimulationExample;
import at.fhj.mdd.ss2020.TestCodeSimulator;
import at.fhj.mdd.ss2020.metamodel.MCronTrigger;
import at.fhj.mdd.ss2020.metamodel.MJob;
import at.fhj.mdd.ss2020.metamodel.MJobTrigger;
import at.fhj.mdd.ss2020.metamodel.MMailTask;
import at.fhj.mdd.ss2020.metamodel.MMavenTask;
import at.fhj.mdd.ss2020.metamodel.MShellTask;
import at.fhj.mdd.ss2020.simulator.JenkinsSimulator;

public class TestSimulator {
	@Test
	public void testSimulationExample() throws InterruptedException {
		JenkinsSimulator simulator = new JenkinsSimulator();
		Thread thread = new Thread(() -> {
			new JobSimulationExample().simulate(simulator);
		});
		thread.start();
		Thread.sleep(200);
		Assert.assertEquals("", simulator.toString());
		simulator.setVersionUpdated("https://github.com/me/mycoolproject.git");
		thread.join();
		Assert.assertEquals(
				"#/root/prepareJava.sh,#/root/prepareMaven.sh,mvn>clean,mvn>clean install deploy,#/root/prepareMail.sh,mailto:me@me.com",
				simulator.toString());
	}

	@Test
	public void testGenerator() {
		MJob job = new MJob("TestCode", new MJobTrigger(new MJob("BuildCode", new MCronTrigger("* * * * *"))));
		job.getPreBuildTasks().add(new MShellTask("/root/startSystem.sh"));
		job.getBuildTasks().add(new MMavenTask("test"));
		job.getPostBuildTasks().add(new MMailTask(Arrays.asList("me@me.com", "you@you.com")));

		new SimulatorGeneratorVisitor().visit(job);
	}

	@Test
	public void testCodeSimulator() throws InterruptedException {
		JenkinsSimulator simulator = new JenkinsSimulator();
		Thread thread = new Thread(() -> {
			new TestCodeSimulator().simulate(simulator);
		});
		thread.start();
		Thread.sleep(200);
		Assert.assertEquals("", simulator.toString());
		simulator.setJobExecuted("BuildCode");
		thread.join();
		System.out.println(simulator.toString());
		Assert.assertEquals("#/root/startSystem.sh,mvn>test,mailto:me@me.com,mailto:you@you.com", simulator.toString());
	}
}
