package org.se.lab;

import java.util.HashMap;
import java.util.Map;

public class ConsoleLogin extends AbstractLogin {
	/*
	 * Simulate a database table
	 */

	private static final Map<String, String> userTable;

	static {
		userTable = new HashMap<String, String>();
		userTable.put("homer", "********");
		userTable.put("marge", "********");
		userTable.put("bart", "********");
		userTable.put("lisa", "********");
		userTable.put("maggie", "********");
	}

	public ConsoleLogin() {
		this(new ConsoleIODevice());
	}

	/*
	 * Constructor
	 */
	public ConsoleLogin(IODevice console) {
		setConsole(console);
	}

	/*
	 * Association: ---[1]-> console:IOUtils
	 */
	private IODevice console;

	public final void setConsole(IODevice console) {
		if (console == null)
			throw new NullPointerException();
		this.console = console;
	}

	public final IODevice getConsole() {
		return console;
	}

	/*
	 * Actions
	 */

	@Override
	protected void readUsername() {
		username = getConsole().readLine("username> ");
	}

	@Override
	protected void readPassword() {
		password = getConsole().readLine("password> ");
	}

	@Override
	protected boolean checkInputData() {
		return username.length() < 4 || password.length() < 8;
	}

	@Override
	protected boolean checkUserData() {
		return userTable.containsKey(username) && userTable.get(username).equals(password);
	}

	@Override
	protected void welcomeUser() {
		getConsole().writeLine("Welcome " + username + "!");
	}

	@Override
	protected void errorInvalidUserData() {
		getConsole().writeError("Error: you entered invalid user data!");
		throw new IllegalStateException();
	}

	@Override
	protected void errorLoginFailed() {
		getConsole().writeError("Login failed!");
		throw new IllegalStateException();
	}
}
