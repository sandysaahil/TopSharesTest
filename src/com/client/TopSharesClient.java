package com.client;

import org.apache.commons.lang.StringUtils;

import com.exception.SharesException;
import com.server.SharesManager;
import com.server.SharesManagerImpl;



/**
 * Lists, for each Company, year and month in which the share price was highest.
 * 
 * @author Vivek Arora
 *
 */
public class TopSharesClient {
	
	public static void main(String[] args) {
		
		String file = args[0];
		if(StringUtils.isNotBlank(file)){
			
			SharesManager sharesManager = new SharesManagerImpl();
			try {
				sharesManager.processShares(file);
			} catch (SharesException e) {
				e.printStackTrace(); // Logger to be used here
				System.exit(0);
			}
			
		}else{
			System.err.println("Invalid Arguments. No filename passed");
			System.exit(0);
		}
		
	}

}
