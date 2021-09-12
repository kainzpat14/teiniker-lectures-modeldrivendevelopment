package at.fhj.mdd.ws2020.generics.model;

import at.fhj.mdd.ws2020.generics.annotations.YmlAttribute;
import at.fhj.mdd.ws2020.generics.annotations.YmlEntity;

@YmlEntity(name = "client")
public class ClientSettings {
	@YmlAttribute(name = "serverAddress")
	private String serverAddress;
	@YmlAttribute(name = "port")
	private int port;

	public ClientSettings(String serverAddress, int port) {
		super();
		this.serverAddress = serverAddress;
		this.port = port;
	}

	public String getServerAddress() {
		return serverAddress;
	}

	public void setServerAddress(String serverAddress) {
		this.serverAddress = serverAddress;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}
