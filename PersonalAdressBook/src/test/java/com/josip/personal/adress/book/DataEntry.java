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
 * it contains functions which generates random data. This test class only generates 
 * values for sex and country, since we have foreign keys and also we cannot make
 * a list of cities. It will have to be inserted manually.
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
    
    /***
     * @author Josip Bošnjak
     * @since 21.5.2019 17:50
     * @return list of countries
     * <h2>Description</h2>
     * <strong>
     *  This function generate list of countries in the array.
     *  Also we need unique country names, so it will have at least 20 
     *  countries, and we will need only ten because of data. So we will have another
     *  function which will check for the unique values. Functionality 
     *  of this function is equals to generateSex, but also it will have
     *  call to check the list if there is unique value. Also it generates their country
     *  alpha1 and alpha2 codes.
     * </strong>
     */
    public static List<String> generateCountries(){
    	List<String> country=new ArrayList<String>();
    	String countries[]=new String[] {"Japan","South Korea","Croatia","Afganistan","Syria","United states of america","Norway","Peru","Mexico","Venezuela","China","Saudi Arabia","Qatar","Italy","Germany","Slovenia","Serbia","Russia","Ucraine","Belarus"};
    	String alpha1[] = new String[] {"JP","KR","HR","AF","SY","US","NO","PE","MX","VE","CN","SA","QA","IT","DE","SI","RS","RU","UA","BY"};
    	String alpha2[] = new String[] {"JPN","KOR","HRV","AFG","SYR","USA","NOR","PER","MEX","VEN","CHN","SAU","QAT","ITA","DEU","SVN","SRB","RUS","UKR","BLR"};
    	Random random=new Random();
    	for(int number=0;number<countries.length;number++) {
    		int index=random.nextInt(countries.length);
    		if(checkUnique(country, countries[index])==true) {
    			
    		
    		country.add(countries[index]);
    		country.add(alpha1[index]);
    		country.add(alpha2[index]);
    		country.add(",");
    		}else {
    			continue;
    		}
    	}
    	return country;
    }
    /**
     * 
     * @param list
     * @return true if unique value else return false
     */
    public static boolean checkUnique(List<String> list, String value) {
    	boolean isUnique=true;
    	for (String string : list) {
			if (string.equals(value)) {
				isUnique=false;
				break;
			}else {
				isUnique=true;
			}
		}
    	return isUnique;
    }
    /***
     * @author Josip Bošnjak
     * @since 21.5.2019 18:51
     * @param list sex list
     * @param list2 country list
     * 
     * <h2>Description</h2>
     * <strong>
     * This function creates a migration file, 
     * insert data to table with insertion queries from sex and country table 
     * and it checks if there is the same file name. If it is, then
     * it will change version to next number everything else will remain the same.
     * <strong>
     */
    public static void makeScript(List<String> list, List<String> list2) {
    	int version=2;
    	String filename="__dataEntry.sql";
    	String file="V"+String.valueOf(version)+filename;
    	System.out.println(file);
    	String query1="";
    	String query2="";
    }
	public static void main(String[] args) {
	 
		final int generate=5;
		List<String> generateList=generateSex(generate);
        printList(generateList);
        List<String> countries=generateCountries();
        printList(countries);
	    makeScript(generateList, countries);
	    
	   
	  

	}

}
