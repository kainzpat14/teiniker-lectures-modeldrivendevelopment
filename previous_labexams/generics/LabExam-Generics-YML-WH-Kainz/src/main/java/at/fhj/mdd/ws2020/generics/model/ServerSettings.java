package at.fhj.mdd.ws2020.generics.model;

import at.fhj.mdd.ws2020.generics.annotations.YmlAttribute;
import at.fhj.mdd.ws2020.generics.annotations.YmlEntity;

@YmlEntity(name = "server")
public class ServerSettings {
	@YmlAttribute(name = "bindAddress")
	private String bindAddress;
	@YmlAttribute(name = "port")
	private int port;

	public ServerSettings(String bindAddress, int port) {
		super();
		this.bindAddress = bindAddress;
		this.port = port;
	}

	public String getBindAddress() {
		return bindAddress;
	}

	public void setBindAddress(String bindAddress) {
		this.bindAddress = bindAddress;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}
