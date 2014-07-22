package com.server;

import java.io.File;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.exception.FileManagerException;
import com.exception.SharesException;
import com.server.pojo.SharesDetails;

/**
 * Processes the file and output the companies with highest share price along with month and year
 * 
 * @author Vivek Arora
 *
 */
public class SharesManagerImpl implements SharesManager{

	@Override
	public void processShares(String file) throws SharesException {
		
		if(StringUtils.isNotBlank(file)){
			File inputFile = new File(file);
			
			FileManager fileManager = new CSVFileManager();
			try {
				Map<String, SharesDetails> sharesMap = fileManager.processFile(inputFile);
				Iterator<SharesDetails> iterator = sharesMap.values().iterator();
				while(iterator.hasNext()){
					SharesDetails next = iterator.next();
					
					System.out.println(next.toString());
				}
				
			} catch (FileManagerException e) {
				throw new SharesException(e);
			}
		}else{
			throw new SharesException("File name can not be blank or null");
		}		
	}

}
