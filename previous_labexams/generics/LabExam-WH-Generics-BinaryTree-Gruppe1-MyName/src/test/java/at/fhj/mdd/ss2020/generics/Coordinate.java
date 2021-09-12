package at.fhj.mdd.ss2020.generics;

public class Coordinate implements Comparable<Coordinate> {
	private int x;
	private int y;

	public Coordinate(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	@Override
	public int compareTo(Coordinate o) {
		return (int) (Math.sqrt(x * x + y * y) - Math.sqrt(o.x * o.x + o.y * o.y));
	}

	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}

}
