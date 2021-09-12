package at.fhj.mdd.ss2020.metamodel;

public class MCronTrigger implements MTrigger {
	private String cronExpression;

	public MCronTrigger(String cronExpression) {
		super();
		this.cronExpression = cronExpression;
	}

	public String getCronExpression() {
		return cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

}
