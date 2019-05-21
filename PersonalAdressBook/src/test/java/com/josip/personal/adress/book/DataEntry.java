package com.josip.personal.adress.book;

import java.util.ArrayList;
import java.util.List;



/***
 * 
 * @author Josip Bošnjak
 * @category Test class
 * @version 1.0
 * @since 21.5.2019. 10:26
 * 
 * This class inserts random generated data into the migrate file which 
 * inserts data into database. Also it checks if migration file name already exsists.
 * If it exists, it will change random version of that file by adding one to the version.
 * If that version exsists too, it will add until there is available. Also, 
 * it contains functions which generates random data.
 */

public class DataEntry {
	/**
	 * 
	 * @param numberOfRecords
	 * @return generated list of sex which depends on number of records
	 * 
	 * This function generates random male female m or f data
	 * which depends on number of records.
	 */
    public static List<String> generateSex(int numberOfRecords) {
    	String[] combinations= new String[]{"male","female","m","f"};
    	List<String> sexList=new ArrayList<String>();
    	return sexList;
    	
    }
	public static void main(String[] args) {
	

	   
	   
	   
	  

	}

}
