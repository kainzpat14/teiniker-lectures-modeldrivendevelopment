package at.fhj.mdd.ws2020.metamodel;

public class MCreateFolderStep implements MStep {
	private String folder;

	public MCreateFolderStep(String folder) {
		super();
		this.folder = folder;
	}

	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

}
