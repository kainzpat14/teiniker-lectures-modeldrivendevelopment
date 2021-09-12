package at.fhj.mdd.ws2020.metamodel;

public class MPrecondition {
	private MItem item;
	private int requiredQuantity;

	public MPrecondition(MItem item, int requiredQuantity) {
		super();
		this.item = item;
		this.requiredQuantity = requiredQuantity;
	}

	public MItem getItem() {
		return item;
	}

	public void setItem(MItem item) {
		this.item = item;
	}

	public int getRequiredQuantity() {
		return requiredQuantity;
	}

	public void setRequiredQuantity(int requiredQuantity) {
		this.requiredQuantity = requiredQuantity;
	}

}
