package at.fhj.mdd.ws2020.dsl.metamodel;

public class MInventoryOccurence implements MOccurence {
	private MItem item;
	private int count;

	public MInventoryOccurence(MItem item, int count) {
		super();
		this.item = item;
		this.count = count;
	}

	public MItem getItem() {
		return item;
	}

	public void setItem(MItem item) {
		this.item = item;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
