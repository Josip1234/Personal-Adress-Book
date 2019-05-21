package com.josip.personal.adress.book;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



/***
 * 
 * @author Josip Bošnjak
 * @category Test class
 * @version 1.0
 * @since 21.5.2019. 10:26
 * 
 * 
 * This class inserts random generated data into the migrate file which 
 * inserts data into database. Also it checks if migration file name already exists.
 * If it exists, it will change random version of that file by adding one to the version.
 * If that version e too, it will add until there is available. Also, 
 * it contains functions which generates random data.
 */

public class DataEntry {
	/**
	 * @since 21.5.2019. 14:00
	 * @param numberOfRecords
	 * @return generated list of sex which depends on number of records
	 * 
	 * <i>This function generates random male female m or f data
	 * which depends on number of records.
	 * </i>
	 * <h2>How this algorithm works</h2>
	 * <strong>
	 * First, initialize array and add some values.
	 * Initialize list as array list, because it can be extended,
	 * it is very useful in this case to use array list, not linked list or
	 * array. 
	 * Initialize random values.
	 * While number is smaller than number of records 
	 * get random index include last element of array.
	 * Add value to the list. 
	 * Then return random list of sex.
	 * </strong>
	 */
    public static List<String> generateSex(int numberOfRecords) {
    	String[] combinations= new String[]{"male","female","m","f"};
    	List<String> sexList=new ArrayList<String>();
    	Random random=new Random();
    	for(int number=0;number<numberOfRecords;number++) {
    		int index=random.nextInt(combinations.length);
    		sexList.add(combinations[index]);
    	}
    	return sexList;
    	
    }
    /***
     * @author Josip Bošnjak
     * @param list
     * @since 21.5.2019 14:22
     * 
     * <h2>Description</h2>
     * <strong>For each element type string in the list
     * print element by element in the list.</strong>
     */
    public static void printList(List<String> list) {
    	for (String string : list) {
			System.out.println(string);
		}
    }
	public static void main(String[] args) {
	 
		final int generate=5;
		List<String> generateList=generateSex(generate);
        printList(generateList);
	   
	   
	   
	  

	}

}
