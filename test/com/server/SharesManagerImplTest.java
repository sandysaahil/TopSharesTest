/**
 * 
 */
package com.server;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.exception.SharesException;

/**
 * @author Sandy
 *
 */
public class SharesManagerImplTest {
	
	SharesManager manager;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		manager = new SharesManagerImpl();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		manager = null;
	}

	/**
	 * Test method for {@link com.server.SharesManagerImpl#processShares(java.lang.String)}.
	 */
	@Test
	public void testMissingArguments() {
		
		String file = null;
		try {
			manager.processShares(file);
			fail("Control Should not have reached here");
		} catch (SharesException e) {
			assertTrue("Expected SharesException", true);
		}
	}
	
	/**
	 * Test method for {@link com.server.SharesManagerImpl#processShares(java.lang.String)}.
	 */
	@Test
	public void testFileNotFound() {
		
		String file = "abc.exe";
		try {
			manager.processShares(file);
			fail("Control Should not have reached here");
		} catch (SharesException e) {
			assertTrue("Expected SharesException", true);
		}
	}

}
