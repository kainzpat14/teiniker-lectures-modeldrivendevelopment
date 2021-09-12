package at.fhj.mdd.ws2020.metamodel;

public class MTransportOccurence implements MOccurence {
	private MRoom room;

	public MTransportOccurence(MRoom room) {
		super();
		this.room = room;
	}

	public MRoom getRoom() {
		return room;
	}

	public void setRoom(MRoom room) {
		this.room = room;
	}

}
