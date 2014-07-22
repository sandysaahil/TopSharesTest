package com.server;

import com.exception.SharesException;

public interface SharesManager {

	/**
	 * Processes the file and output the companies with highest share price along with month and year
	 * 
	 * @param file
	 * @throws SharesException
	 */
	public void processShares(String file) throws SharesException;
}
