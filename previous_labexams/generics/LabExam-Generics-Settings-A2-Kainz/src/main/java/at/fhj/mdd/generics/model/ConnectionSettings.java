package at.fhj.mdd.generics.model;

import at.fhj.mdd.generics.annotations.Setting;
import at.fhj.mdd.generics.annotations.SettingObject;

@SettingObject(name = "connection")
public class ConnectionSettings {
	@Setting(key = "serverAddress")
	private String serverAddress;
	@Setting(key = "port")
	private int port;

	public ConnectionSettings(String serverAddress, int port) {
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
