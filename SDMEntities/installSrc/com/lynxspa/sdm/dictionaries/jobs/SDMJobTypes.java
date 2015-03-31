package com.lynxspa.sdm.dictionaries.jobs;


public enum SDMJobTypes {

	BB_EQ("EQ", "BLOOMBERG_EQUITY", "Bloomberg Equity", "1/30 * * * * ?", "", "", "", ".tmp", ".done", ".error", ".sdm", "", true, false), 
	BB_FD("FD", "BLOOMBERG_FUND", "Bloomberg Fund", "1/30 * * * * ?", "", "", "", ".tmp", ".done", ".error", ".sdm", "", true, false), 
	BB_FI("FI", "BLOOMBERG_FIXINCOME", "Bloomberg Fix Income", "1/30 * * * * ?", "", "", "", ".tmp", ".done", ".error", ".sdm",	"", true, false), 
	BB_ET("ET", "BLOOMBERG_ETC", "Bloomberg ETC", "1/30 * * * * ?", "", "", "", ".tmp", ".done", ".error", ".sdm", "", true, false), 
	BB_FIELD("BLOOMBERGSTATIC", "IMPORTBLOOMBERGFIELDS", "IMPORTBLOOMBERGFIELDS", "1/30 * * * * ?", "", "", "", ".tmp", ".done", ".error", ".sdm", "", true, false);

	private String id;
	private String name;
	private String description;
	private String cronExpression;
	private String inputDirectory;
	private String commitDirectory;
	private String rollbackDirectory;
	private String temporalSuffix;
	private String commitSuffix;
	private String rollbackSuffix;
	private String pattern;
	private String classExe;
	private boolean isAllowMultithreading;
	private boolean allOrNothing;

	SDMJobTypes(String _id, String _name, String _description,
			String _cronExpression, String _inputDirectory,
			String _commitDirectory, String _rollbackDirectory,
			String _temporalSuffix, String _commitSuffix,
			String _rollbackSuffix, String _pattern, String _classExe,
			boolean _isAllowMultithreading, boolean _allOrNothing) {

		this.id = _id;
		this.name = _name;
		this.description = _description;
		this.cronExpression = _cronExpression;
		this.inputDirectory = _inputDirectory;
		this.commitDirectory = _commitDirectory;
		this.rollbackDirectory = _rollbackDirectory;
		this.temporalSuffix = _temporalSuffix;
		this.commitSuffix = _commitSuffix;
		this.rollbackSuffix = _rollbackSuffix;
		this.pattern = _pattern;
		this.classExe = _classExe;
		this.isAllowMultithreading = _isAllowMultithreading;
		this.allOrNothing = _allOrNothing;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getCronExpression() {
		return cronExpression;
	}

	public String getInputDirectory() {
		return inputDirectory;
	}

	public String getCommitDirectory() {
		return commitDirectory;
	}

	public String getRollbackDirectory() {
		return rollbackDirectory;
	}

	public String getTemporalSuffix() {
		return temporalSuffix;
	}

	public String getCommitSuffix() {
		return commitSuffix;
	}

	public String getRollbackSuffix() {
		return rollbackSuffix;
	}

	public String getPattern() {
		return pattern;
	}

	public String getClassExe() {
		return classExe;
	}

	public boolean isAllowMultithreading() {
		return isAllowMultithreading;
	}

	public boolean isAllOrNothing() {
		return allOrNothing;
	}

}
