package at.fhj.mdd.ss2020.metamodel;

import java.util.ArrayList;
import java.util.List;

public class MJob {
	private String name;
	private MTrigger trigger;
	private List<MPreBuildTask> preBuildTasks = new ArrayList<>();
	private List<MBuildTask> buildTasks = new ArrayList<>();
	private List<MPostBuildTask> postBuildTasks = new ArrayList<>();

	public MJob(String name, MTrigger trigger) {
		super();
		this.name = name;
		this.trigger = trigger;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MTrigger getTrigger() {
		return trigger;
	}

	public void setTrigger(MTrigger trigger) {
		this.trigger = trigger;
	}

	public List<MPreBuildTask> getPreBuildTasks() {
		return preBuildTasks;
	}

	public void setPreBuildTasks(List<MPreBuildTask> preBuildTasks) {
		this.preBuildTasks = preBuildTasks;
	}

	public List<MBuildTask> getBuildTasks() {
		return buildTasks;
	}

	public void setBuildTasks(List<MBuildTask> buildTasks) {
		this.buildTasks = buildTasks;
	}

	public List<MPostBuildTask> getPostBuildTasks() {
		return postBuildTasks;
	}

	public void setPostBuildTasks(List<MPostBuildTask> postBuildTasks) {
		this.postBuildTasks = postBuildTasks;
	}
}
