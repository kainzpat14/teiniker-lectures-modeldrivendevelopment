package at.fhj.mdd.ss2020.metamodel;

public class MVersioningTrigger implements MTrigger {
	private String url;

	public MVersioningTrigger(String url) {
		super();
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
