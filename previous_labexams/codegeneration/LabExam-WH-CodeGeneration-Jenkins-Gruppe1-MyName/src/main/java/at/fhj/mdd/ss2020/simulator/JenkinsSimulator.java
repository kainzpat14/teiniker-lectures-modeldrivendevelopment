package at.fhj.mdd.ss2020.simulator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JenkinsSimulator {
	private String cronReached;
	private String versionUpdated;
	private String jobExecuted;
	private Set<String> failures = new HashSet<>();

	private StringBuilder log = new StringBuilder();

	public String getCronReached() {
		return cronReached;
	}

	public void setCronReached(String cronReached) {
		this.cronReached = cronReached;
	}

	public String getVersionUpdated() {
		return versionUpdated;
	}

	public void setVersionUpdated(String versionUpdated) {
		this.versionUpdated = versionUpdated;
	}

	public String getJobExecuted() {
		return jobExecuted;
	}

	public void setJobExecuted(String jobExecuted) {
		this.jobExecuted = jobExecuted;
	}

	public Set<String> getFailures() {
		return failures;
	}

	public void setFailures(Set<String> failures) {
		this.failures = failures;
	}

	@Override
	public String toString() {
		return log.toString();
	}

	public boolean isCronReached(String expression) {
		boolean ok = expression.equals(cronReached);
		if (ok) {
			cronReached = null;
		}
		return ok;
	}

	public boolean isVersionUpdated(String url) {
		boolean ok = url.equals(versionUpdated);
		if (ok) {
			versionUpdated = null;
		}
		return ok;
	}

	public boolean isJobExecuted(String job) {
		boolean ok = job.equals(jobExecuted);
		if (ok) {
			jobExecuted = null;
		}
		return ok;
	}

	public boolean executeShell(String cmd) {
		log("#" + cmd);
		return !failures.contains("executeShell");
	}

	public boolean maven(String cmd) {
		log("mvn>" + cmd);
		return !failures.contains("maven");
	}

	public boolean sendMail(List<String> addresses) {
		for (String address : addresses) {
			log("mailto:" + address);
		}
		return !failures.contains("sendMail");
	}

	private void log(String message) {
		if (log.length() > 0) {
			log.append(",");
		}
		log.append(message);
	}

}
