package at.fhj.mdd.ss2020.metamodel;

import java.util.List;

public class MMailTask implements MPostBuildTask {
	private List<String> mailAdresses;

	public MMailTask(List<String> mailAdresses) {
		super();
		this.mailAdresses = mailAdresses;
	}

	public List<String> getMailAdresses() {
		return mailAdresses;
	}

	public void setMailAdresses(List<String> mailAdresses) {
		this.mailAdresses = mailAdresses;
	}

}
