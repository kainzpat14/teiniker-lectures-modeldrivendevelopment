package at.fhj.mdd.ws2020.dsl.metamodel;

public abstract class MNumberedEntityStep extends MStep {

	private String entityKey;
	private int count;

	public MNumberedEntityStep(String shortDescription, String description, boolean optional, String entityKey,
			int count) {
		super(shortDescription, description, optional);
		this.entityKey = entityKey;
		this.count = count;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getEntityKey() {
		return entityKey;
	}

	public void setEntityKey(String entityKey) {
		this.entityKey = entityKey;
	}

}
