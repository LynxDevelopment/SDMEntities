package com.lynxspa.sdm.processors.plannings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

public class StreamCaptureProcessor extends Thread {

	// Flujo de entrada
	InputStream is;
	// Tipo de Flujo: generalmente output o error
	String type;
	// Flujo de salida
	OutputStream os;
	// Variable para mostrar por la salida estandard (donde redireccionar la salida)
	boolean debug = false;
	// para guardar la salida generada (indica si se debe mostrar o no la salida por la salida estandard)
	String output = "";
	
	public void startCapture(InputStream is, String type, OutputStream redirect, boolean debug)
			throws Exception {
		this.is = is;
		this.type = type;
		this.os = redirect;
		this.debug = debug;
		
		
	}

	/**
	 * Constructor
	 * 
	 * @param is
	 *            InputStram
	 * @param type
	 *            tipo de flujo (OUTPUT o ERROR)
	 * @param redirect
	 *            OutputStream donde redireccionar la salida
	 * @param debug
	 *            indica si se debe mostrar o no la salida por la salida
	 *            estandard
	 */
	StreamCaptureProcessor(InputStream is, String type, OutputStream redirect,
			boolean debug) {
		this.is = is;
		this.type = type;
		this.os = redirect;
		this.debug = debug;
		
		this.start();
	}
	
	@Override
	public void run() {
		try {
			PrintWriter pw = null;
			if (os != null)
				pw = new PrintWriter(os);
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null) {
				// si hay fichero lo imprime a fichero
				if (pw != null)
					pw.println(line);
				if (debug)
					System.out.println(type + "> " + line);
				output = output + line + "\r\n";
			}
			if (pw != null)
				pw.flush();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	/**
	 * Recuperar el flujo de datos generado
	 * 
	 * @return un String con el output
	 */
	public String getOutput() {
		return output;
	}
}
