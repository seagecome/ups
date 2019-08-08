package com.talkortell.bbs.dal.mbg;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.mybatis.generator.api.GeneratedFile;
import org.mybatis.generator.exception.ShellException;
import org.mybatis.generator.internal.DefaultShellCallback;

public class BaseGenerator {
	protected String renameExample(String code){
		return code.replace("Example", "Criteria").replace("example", "criteria");
	}
	
	protected void changeGenFileContent(DefaultShellCallback callback, GeneratedFile file, String fileContent) {
		try {
			File directory = callback.getDirectory(file.getTargetProject(), file.getTargetPackage());
			File writename = new File(directory.getAbsolutePath().concat("/").concat(file.getFileName()));
			writename.delete();
			writename.createNewFile();
			
			try(BufferedWriter out = new BufferedWriter(new FileWriter(writename))){
				out.write(fileContent);
			}
			
		} catch (ShellException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
