import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ResourceCentreTest {
	private Camcorder cc1;
	private Camcorder cc2;
	private Chromebook cb1;
	private Chromebook cb2;
	
	private ArrayList<Camcorder> camcorderList;
	private ArrayList<Chromebook> chromebookList;
	
	public ResourceCentreTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		// prepare test data
		cc1 = new Camcorder("CC0011", "Nikon HDSLR", 40);
		cc2 = new Camcorder("CC0012", "Sony DSC-RX100M7", 20);
		cb1 = new Chromebook("CB0011", "My Google Chromebook 1st", "Mac OS");
		cb2 = new Chromebook("CB0012", "SAMSUNG Chromebook 4+", "Win 10");

		camcorderList= new ArrayList<Camcorder>();
		chromebookList= new ArrayList<Chromebook>();
	}

	
	@Test
	public void addCamcorderTest() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1
		ResourceCentre.addCamcorder(camcorderList, cc1);		
		assertEquals("Test if that Camcorder arraylist size is 1?", 1, camcorderList.size());
		
		//The item just added is as same as the first item of the list
		assertSame("Test that Camcorder is added same as 1st item of the list?", cc1, camcorderList.get(0));
		
		//Add another item. test The size of the list is 2?
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test that Camcorder arraylist size is 2?", 2, camcorderList.size());
	
		
	}
	@Test
	public void addChromebookTest() {
		//fail("Not yet implemented");
		// write your code here
		assertNotNull("Test if there is valid Chromebook arraylist to add to", chromebookList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1
	    ResourceCentre.addChromebook(chromebookList, cb1);    
	    assertEquals("Test if that Chromebook arraylist size is 1?", 1, chromebookList.size());
	
	  //The item just added is as same as the first item of the list
	    assertSame("Test that Chromebook is added same as 2nd item of the list?", cc2, chromebookList.get(0));
	
	  //Add another item. test The size of the list is 2?
	    ResourceCentre.addChromebook(chromebookList, cb2);
	    assertEquals("Test that Camcorder arraylist size is 2?", 2, chromebookList.size());
	//
	}
	
	@Test
	public void retrieveAllCamcorderTest() {
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);
		
		//test if the list of camcorders retrieved from the SourceCentre is empty
				String allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);
				String testOutput = "";
				assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);
				
		//Given an empty list, after adding 2 items, test if the size of the list is 2
		ResourceCentre.addCamcorder(camcorderList, cc1);
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test if that Camcorder arraylist size is 2?", 2, camcorderList.size());
		
		//test if the expected output string same as the list of camcorders retrieved from the SourceCentre
		allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);

		testOutput = String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0011", "Nikon HDSLR", "Yes", "", 40);
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0012", "Sony DSC-RX100M7", "Yes", "", 20);
	
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);
		
	}
	@Test
	public void retrieveAllChromebookTest() {
		//fail("Not yet implemented");
		// write your code here

		// Test if Item list is not null but empty, so that can add a new item
				assertNotNull("Test if there is valid Camcorder arraylist to add to", chromebookList);
				
				//test if the list of chromebook retrieved from the SourceCentre is empty
						String allChromebook= ResourceCentre.retrieveAllChromebook(chromebookList);
						String CBtestOutput = "";
						assertEquals("Check that ViewAllchromebookList", CBtestOutput, allChromebook);
						
				//Given an empty list, after adding 2 items, test if the size of the list is 2
				ResourceCentre.addChromebook(chromebookList, cb1);
				ResourceCentre.addChromebook(chromebookList, cb2);
				assertEquals("Test if that Camcorder arraylist size is 2?", 2, chromebookList.size());
				
				//test if the expected output string same as the list of camcorders retrieved from the SourceCentre
				allChromebook= ResourceCentre.retrieveAllChromebook(chromebookList);

				CBtestOutput = String.format("%-10s %-30s %-10s %-10s %-20s\n","CB0011", "My Google Chromebook 1st", "Yes", "", "Mac OS");
				CBtestOutput += String.format("%-10s %-30s %-10s %-10s %-20s\n","CB0012", "SAMSUNG Chromebook 4+", "Yes", "", "Win 10");
				
				assertEquals("Check that ViewAllchromebookList", CBtestOutput, allChromebook);
						
	}

	@Test
	public void doLoanCamcorderTest() {
		//fail("Not yet implemented");
		// write your code here
		//Zuhaili
		ResourceCentre.addCamcorder(camcorderList, cc1);	
		ResourceCentre.addCamcorder(camcorderList, cc2);
		
		Boolean isLoaned1 = ResourceCentre.doLoanCamcorder(this.camcorderList, "CC0011", "0");
		Boolean isLoaned2 = ResourceCentre.doLoanCamcorder(this.camcorderList, "CC0012", "0");
		
		assertTrue("Test if available camcorder CC0011 can be loaned", isLoaned1);
		assertTrue("Test if available camcorder CC0012 can be loaned", isLoaned2);
		
		System.out.println("Pass: Normal test - loan available");
		
		

		Boolean isLoaned3 = ResourceCentre.doLoanCamcorder(this.camcorderList, "CC0011", "0");
		Boolean isLoaned4 = ResourceCentre.doLoanCamcorder(this.camcorderList, "CC0012", "0");
		
		assertFalse("Test if unavailable camcorder CC0011 can be loaned", isLoaned3);
		assertFalse("Test if unavailable camcorder CC0012 can be loaned", isLoaned4);

		System.out.println("Pass: Error test - loan unavailable");
		
		

		Boolean isLoaned5 = ResourceCentre.doLoanCamcorder(this.camcorderList, "CC0099", "0");
		Boolean isLoaned6 = ResourceCentre.doLoanCamcorder(this.camcorderList, "CC0100", "0");
		
		assertFalse("Test if available non-existent camcorder CC0099 can be loaned", isLoaned5);
		assertFalse("Test if available non-existent camcorder CC0100 can be loaned", isLoaned6);

		System.out.println("Pass: Error test - loan non-existent");
	}
	
	@Test
	public void doLoanChromebookTest() {
		//fail("Not yet implemented");
		// write your code here
		assertNotNull("Test if there is valid Chromebook arraylist to loan from", chromebookList);
		
		//Given an list with 2 item, after loaning 1 item, the size of the list is total 2 
		ResourceCentre.doLoanChromebook(chromebookList, "CB1", "11-11-1111");		
		assertEquals("Test if that Chromebook arraylist size is 0?", 2, chromebookList.size());
		
		//The item just loan is not an items of the list
		assertNotSame("Test that Chromebook is loaned is not same as 1st item of the list?", "CB1", chromebookList.get(0));
		assertNotSame("Test that Chromebook is loaned is not same as 1st item of the list?", "CB1", chromebookList.get(1));
		
		//loan item test The size of the list is 2?
		ResourceCentre.doLoanChromebook(chromebookList, "CB2", "11-11-1111");
		assertEquals("Test that chromebook arraylist size is 0?", 2, chromebookList.size());
	}
	
	@Test
	public void doReturnCamcorderTest() {
		//fail("Not yet implemented");
		// write your code here
		
		
		
	}
	@Test
	public void doReturnChromebookTest() {
		//fail("Not yet implemented");
		// write your code here
		//Zuhaili
		ResourceCentre.addChromebook(chromebookList, cb1);
		ResourceCentre.addChromebook(chromebookList, cb2); 
		ResourceCentre.doReturnChromebook(chromebookList, "CB0011");
		assertEquals( "Test if item is available",true, chromebookList.get(1).getIsAvailable());
		assertEquals( "Test if the item is on loan",false, chromebookList.get(1).getIsAvailable());

		ResourceCentre.doReturnChromebook(chromebookList,"");
		assertEquals( "Test if item is available","CB0011",chromebookList.get(0).getAssetTag());
	}
	
	@After
	public void tearDown() throws Exception {
		cc1 = null;
		cc2 = null;
		cb1 = null;
		cb2 = null;
		camcorderList = null;
		chromebookList = null;

	}


	

}
