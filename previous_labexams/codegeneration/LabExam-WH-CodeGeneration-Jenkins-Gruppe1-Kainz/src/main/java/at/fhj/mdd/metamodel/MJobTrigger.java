package at.fhj.mdd.metamodel;

public class MJobTrigger implements MTrigger {
	private MJob job;

	public MJobTrigger(MJob job) {
		super();
		this.job = job;
	}

	public MJob getJob() {
		return job;
	}

	public void setJob(MJob job) {
		this.job = job;
	}

}
