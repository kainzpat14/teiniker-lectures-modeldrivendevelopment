package at.fhj.mdd.installer;

public interface Installer {
	boolean output(String header, String text);

	boolean execute(String command);

	boolean mkdir(String directory);

	boolean copy(String source, String destination);
}
