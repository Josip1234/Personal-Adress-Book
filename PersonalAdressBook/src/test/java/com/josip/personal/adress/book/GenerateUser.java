package com.josip.personal.adress.book;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOError;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

import com.github.javafaker.Faker;
import com.josip.personal.address.book.presentation.layer.User;

public class GenerateUser {
	
	static String[] roles=new String[] {"ADMIN","USER"};
	static String[] email=new String[] {"hotmail","gmail","unipu","efpu"};
	
	public static boolean addNumber(int number) {
		boolean isTrue=false;
		if(number%2==0) isTrue=true;
		else isTrue=false;
		return isTrue;
	}
	public static List<User> generateFakeUser(int number){
		List<User> userList=new ArrayList<>();
		
		
		for(int i=0;i<number;i++) {
			Faker faker = new Faker();
			User user = new User();
			user.setId(faker.number().randomNumber());
			user.setFirstName(faker.name().firstName());
			user.setLastName(faker.name().lastName());
			if(addNumber(i)==true) user.setAge(faker.number().numberBetween(18, 100));
			user.setEmail(user.getFirstName().toLowerCase()+user.getLastName().toLowerCase()
			+faker.number().numberBetween(0, 500)+"@"
					+email[faker.number().numberBetween(0, 3)]+"."+faker.internet().domainSuffix());
			user.setPassword(faker.pokemon().name()+String.valueOf(faker.number().numberBetween(1, 500)).toString());
			if(addNumber(i)==false) user.setRole(roles[0]);
			else user.setRole(roles[1]);
			userList.add(user);
		}
		return userList;
	}
	public static void printFakeUsers(List<User> users) {
		for (User user : users) {
			System.out.println(user);
		}
	}
	public static int input() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input number how many users you want to generate:");
		int number=scanner.nextInt();
		scanner.close();
		return number;
	}
	
    public static boolean saveDataToFile(List<User> users) {
    	boolean saved=false;
    	Map<String, String> map = new HashMap<String, String>();
    	for (User user2 : users) {
			map.put(user2.getEmail(), user2.getPassword());
		}
    	
    	PrintWriter printWriter;
		try {
			printWriter = new PrintWriter(new FileOutputStream("src/test/java/users.json",true));
			printWriter.println(map);
	    	printWriter.close();
	    	saved=true;
		} catch (FileNotFoundException e) {
			saved=false;
			
		}
    
    	return saved;
    }
  
    
	public static void main(String[] args) {
		List<User> user = new ArrayList<>();
		user=generateFakeUser(input());
		printFakeUsers(user);
	    System.out.println(saveDataToFile(user));
	    String insertIntoDatabase="INSERT INTO users(firstName,lastName,age,email,password,role) VALUES();";
		String location="src/main/resources/db/migration/";
		String fileName="V4__userdata";
		String fileExtension="."+"sql";
		String link=location+fileName+fileExtension;
		
		

	}

}
