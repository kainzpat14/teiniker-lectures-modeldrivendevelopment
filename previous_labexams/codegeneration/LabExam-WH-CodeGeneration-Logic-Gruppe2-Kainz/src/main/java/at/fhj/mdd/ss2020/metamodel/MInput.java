package at.fhj.mdd.ss2020.metamodel;

public class MInput implements MCurrentSource {
	private String name;

	public MInput(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
