package com.lynxspa.sdm.processors.plannings;


public interface ExecuteCommandAdapter {

	/**
	 * 
	 * @param content
	 * @param pathname
	 * @param delete
	 * @param command
	 * @param _operatingSystem
	 * @return
	 * @throws Exception
	 */
	public boolean generateFile(String content, String pathname) throws Exception;
	
	public String executeCommand(String command, String _operatingSystem) throws Exception;
}
