package at.fhj.mdd.generics.model;

import at.fhj.mdd.generics.annotations.Setting;
import at.fhj.mdd.generics.annotations.SettingObject;

@SettingObject(name = "server")
public class ServerSettings {
	@Setting(key = "bindAddress")
	private String bindAddress;
	@Setting(key = "port")
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
