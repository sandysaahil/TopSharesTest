package com.server;

import java.io.File;
import java.util.Map;

import com.exception.FileManagerException;
import com.server.pojo.SharesDetails;

public interface FileManager {
	
	public Map<String, SharesDetails> processFile(File inputFile) throws FileManagerException;

}
