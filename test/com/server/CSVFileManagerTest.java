/**
 * 
 */
package com.server;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.exception.FileManagerException;
import com.server.pojo.SharesDetails;

/**
 * @author Sandy
 *
 */
public class CSVFileManagerTest {
	
	FileManager manager;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		manager = new CSVFileManager();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		manager = null;
	}

	/**
	 * Test method for {@link com.server.CSVFileManager#processFile(java.lang.String)}.
	 */
	@Test
	public void testMissingArguments() {
		
		File file = null;
		try {
			manager.processFile(file);
			fail("Control Should not have reached here");
		} catch (FileManagerException e) {
			assertTrue("Expected Exception FileManagerException", true);
		}
	}
	
	/**
	 * Test method for {@link com.server.CSVFileManager#processFile(java.lang.String)}.
	 */
	@Test
	public void testFileNotFound() {
		
		File file = new File("abc.exe");
		try {
			manager.processFile(file);
			fail("Control Should not have reached here");
		} catch (FileManagerException e) {
			assertTrue("Expected Exception FileManagerException", true);
		}
	}

	/**
	 * Test method for {@link com.server.CSVFileManager#processFile(java.lang.String)}.
	 */
	@Test
	public void testValidateCorrectData() {
		
		File file = new File("test_shares_data.csv");
		try {
			Map<String, SharesDetails> sharesMap = manager.processFile(file);
			if(sharesMap == null){
				fail("Result can not be null");
			}else{				
				assertEquals("2000", sharesMap.get("Company-A").getYear());	
				assertEquals("Mar", sharesMap.get("Company-A").getMonth());	
				assertEquals(1000.0, sharesMap.get("Company-A").getSharePrice(), 0);
				
				assertEquals("2007", sharesMap.get("Company-B").getYear());	
				assertEquals("Mar", sharesMap.get("Company-B").getMonth());	
				assertEquals(986.0, sharesMap.get("Company-B").getSharePrice(), 0);
				
				assertEquals("1993", sharesMap.get("Company-C").getYear());	
				assertEquals("Jun", sharesMap.get("Company-C").getMonth());	
				assertEquals(995.0, sharesMap.get("Company-C").getSharePrice(), 0);
				
				assertEquals("2002", sharesMap.get("Company-D").getYear());	
				assertEquals("Apr", sharesMap.get("Company-D").getMonth());	
				assertEquals(999.0, sharesMap.get("Company-D").getSharePrice(), 0);
				
				assertEquals("2008", sharesMap.get("Company-E").getYear());	
				assertEquals("Oct", sharesMap.get("Company-E").getMonth());	
				assertEquals(997.0, sharesMap.get("Company-E").getSharePrice(), 0);
				
			}
			
			
			
		} catch (FileManagerException e) {
			fail("Not expecting any exception");
		}
	}

}
