package com.nni.gamevate.orchestrion.utils;

import com.badlogic.gdx.Gdx;

/**
 * Might run into issues when we deploy to android. still might want to look into log4j
 * this might be slow idk
 * @author Shane
 *
 */
public class Logger {

	
	public static void log(String message){		
		String fullClassName = Thread.currentThread().getStackTrace()[2].getClassName();
	    String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
	    className = "[" + className + "]";
	    String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
	    methodName = "[" + methodName + "]";
	    int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
	    String lineNum= "[" + lineNumber+ "]";
		Gdx.app.log(className + methodName + lineNum, message);
	}
	
	

}
