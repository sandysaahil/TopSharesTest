package com.server;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.lang.StringUtils;

import com.exception.FileManagerException;
import com.server.pojo.SharesDetails;

/**
 * File Manager processes only CSV files
 * 
 * @author Vivek Arora
 *
 */
public class CSVFileManager implements FileManager {

	@Override
	public Map<String, SharesDetails> processFile(File inputFile) throws FileManagerException {
		
		Map<String, SharesDetails> sharesMap = null;
		
		if(inputFile == null){
			throw new FileManagerException("File not Found");
		}
		try {
			Scanner scanner = new Scanner(inputFile);
			String header = scanner.next();
			
			
			sharesMap = new LinkedHashMap<String, SharesDetails>();
			SharesDetails sharesDetails = null;
			String[] sharesHeader = null;
			if(StringUtils.isNotBlank(header)){
				sharesHeader = header.split(",");
				 for(int counter = 2; counter < sharesHeader.length; counter++){ // counter is starting from 2 to skip year and month 
					 sharesMap.put(sharesHeader[counter], sharesDetails);
				 }				
			}else{
            	throw new FileManagerException("Invalid Data");
            }
						
			while(scanner.hasNext()){
				String line = scanner.next();
                String[] sharesDetailsData = line.split(",");
                
                int counter = 2; // after skipping year and month in csv file
                
                String year = sharesDetailsData[0];
                String month = sharesDetailsData[1];
                
                for(int i = counter; i < sharesDetailsData.length; i++){
                	
                	try {
						sharesDetails = new SharesDetails(year, month, Double.valueOf(sharesDetailsData[i]), sharesHeader[i]);
						
						if(sharesMap.get(sharesHeader[i]) == null){
							sharesMap.put(sharesHeader[i], sharesDetails);
						}else{
							
							SharesDetails sharesDetails2 = sharesMap.get(sharesHeader[i]);							
							int compareTo = sharesDetails.compareTo(sharesDetails2);
							
							if(compareTo > 0){
								sharesMap.put(sharesHeader[i], sharesDetails);
							}else{
								sharesMap.put(sharesHeader[i], sharesDetails2);
							}							
						}						
					} catch (NumberFormatException e) {
						throw new FileManagerException("Invalid Data");
					}                	
                }
			}
					
		} catch (FileNotFoundException e) {
			throw new FileManagerException("File not Found");
		}
			return sharesMap;
	}

}
