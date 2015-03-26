package com.lynxspa.sdm.processors.plannings;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.log4j.Logger;

import com.lynxspa.exception.FPMException;
import com.lynxspa.sdm.dictionaries.logs.LogErrorDict;


public class ExecuteCommandProcessor implements ExecuteCommandAdapter {
	
	private final String PERMISO_LECTURA = "chmod +x ";
	private final Logger logger = Logger.getLogger(ExecuteCommandProcessor.class.getName());

	private final String SHELL = "/bin/sh";
	private final String CMD = "cmd.exe";
	private String output = null;
	private String error = null;
	
	private final String UNIX ="Unix"; 
	private final String WINDOWS ="Windows";

	public String executeCommand(String _command, String _operatingSystem) throws Exception {
		String reply=null;
		
		try{
			
			String permisos = null;
			if (UNIX.equals(_operatingSystem) && isCommandAPath(_command)){
				logger.debug("Asignando Permisos");
				permisos = PERMISO_LECTURA + _command;
				execute(permisos, _operatingSystem);
				error = getError();
				if (error != null) {
					if (error.length() > 0)
						throw new Exception("Permission denied : " + error);
				}
				logger.debug("Permisos asignados");
			}

			logger.debug("Ejecutando Comando..."+_command);
			execute(_command, _operatingSystem);
			logger.debug("Comando ejecutado");
			
			reply = getOutput() + (getError()!=null?" Error:"+getError():"");
			
		}catch (Exception e){
			throw new FPMException(LogErrorDict.EXECUTE_COMMAND_ERROR,new Object[]{_command},e);
		}
		return reply;
	}
	
	private boolean isCommandAPath(String _command) throws Exception{
		boolean reply=false;
		File newFile = new File (_command);
		reply = newFile.isFile();
		return reply;
	}

	/**
	 * Execute the command
	 * 
	 */
	private void execute(String _command, String _system) throws Exception {
		output = null;
		error = null;
		StreamCaptureProcessor errorGobbler = null;
		StreamCaptureProcessor outputGobbler = null;
		Process proc = null;
		Runtime rt = null;
		try {
			if (_command == null){
				throw new Exception("command is null");
			}
			rt = Runtime.getRuntime();
			String[] data = getData(_command, _system);
			proc = rt.exec(data);
			
			errorGobbler = new StreamCaptureProcessor(proc.getErrorStream(), "ERROR", null, true);
			outputGobbler = new StreamCaptureProcessor(proc.getInputStream(), "OUTPUT", null, true);
			
			proc.waitFor();

		}catch (Throwable t) {
			throw new Exception(t);
		} finally {
			output = outputGobbler.getOutput();
			error = errorGobbler.getOutput();
		}
	}
	
	private  String[] getData(String _command, String _system) throws Exception{
		String [] reply = null;
		if (_system == null) {
			throw new Exception("OPerating System Not specified");
		}
		if(WINDOWS.equalsIgnoreCase(_system))
			reply = new String []{CMD,"/K",_command};
		else if(UNIX.equalsIgnoreCase(_system))
			reply = new String []{SHELL,"-c",_command};
		return reply;
	}
	
	/**
	 * Generates a file with the value of the content parameter
	 * @param _pathName
	 * @param _content
	 * @return
	 * @throws Exception
	 */
	public boolean generateFile (String _pathName, String _content) throws Exception{
		String content = null;
		boolean reply = false;
		File fGenerated = null;
		FileOutputStream fout = null;
		try {
			logger.debug("Generando fichero [" + _pathName + "]");
			fGenerated = new File(_pathName);
			fout = new FileOutputStream(fGenerated);
			fout.write(content.getBytes());
			if (fout != null)
				fout.close();
			reply = true;
			logger.debug("Fichero generado correctamente");
		}catch (Exception e){
			throw new FPMException(LogErrorDict.GENERATE_FILE_ERROR,new Object[]{_pathName,_content},e);
		}
		return reply;
	}
	
	public String getError() {
		return error;
	}
	
	public String getOutput(){
		return output;
	}
}
