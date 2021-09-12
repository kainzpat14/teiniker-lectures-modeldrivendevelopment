package at.fhj.mdd.ss2020.dsl.metamodel;

public class MPictureElement implements MElement {
	private String pictureUrl;

	public MPictureElement(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

}
