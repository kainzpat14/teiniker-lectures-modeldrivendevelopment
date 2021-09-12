package at.fhj.mdd.ws2020.dsl;

import at.fhj.mdd.ws2020.dsl.metamodel.MInstaller;

public class InstallerBuilder {
	private MainInstallerStepBuilder pre;
	private BuildBuilder build;
	private MainInstallerStepBuilder post;

	public MainInstallerStepBuilder preSetup() {
		pre = new MainInstallerStepBuilder(this);
		return pre;
	}

	public BuildBuilder setup() {
		build = new BuildBuilder(this);
		return build;
	}

	public MainInstallerStepBuilder cleanup() {
		post = new MainInstallerStepBuilder(this);
		return post;
	}

	public MInstaller toInstaller() {
		MInstaller installer = new MInstaller();
		installer.setPreSetupSteps(pre.toSteps());
		installer.setSetupSteps(build.toSteps());
		installer.setCleanupSteps(post.toSteps());
		return installer;
	}
}
