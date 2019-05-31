package com.josip.personal.address.book.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.josip.personal.address.book.data.access.layer.AddressRepository;
import com.josip.personal.address.book.data.access.layer.CityRepository;
import com.josip.personal.address.book.data.access.layer.ContactRepository;
import com.josip.personal.address.book.data.access.layer.CountryRepository;
import com.josip.personal.address.book.data.access.layer.SexRepository;
import com.josip.personal.address.book.presentation.layer.Address;
import com.josip.personal.address.book.presentation.layer.City;
import com.josip.personal.address.book.presentation.layer.Contact;
import com.josip.personal.address.book.presentation.layer.Country;
import com.josip.personal.address.book.presentation.layer.Sex;

/****
 * 
 * @author Josip Bošnjak
 * @since 24.5.2019 14:10
 * @version 1.0
 * <h2>Description</h2>
 * <strong>
 * This class receive request and send requests.
 * Data is sent to user view by repository.
 * First, list is generated and repository is used to 
 * receive data from database. 
 * Then, lambda expression is used to add data to the list.
 * List is added to the model then, which controller will
 * pass to the web site. User will see that data at the 
 * site.
 * 
 * </strong>
 */
@Controller
public class TemplateController {

	private final SexRepository sexRepository;
	private final CountryRepository countries;
	private final CityRepository cityRepository;
	private final AddressRepository addressRepository;
	private final ContactRepository contactRepository;
	private final String redirect="redirect:/template";
	private final String template="/template";
	
	
	@Autowired
	public TemplateController(SexRepository sexRepository, CountryRepository country, CityRepository cityRepository, AddressRepository addressRepository, ContactRepository contactRepository) {
		this.sexRepository=sexRepository;
		this.countries=country;
		this.cityRepository=cityRepository;
		this.addressRepository=addressRepository;
		this.contactRepository=contactRepository;
	}
	/***
	 * @author Josip Bošnjak
	 * @since 24.5.2019. 14:10
	 * @param model
	 * @return view template with generated form for insert new sex, country, city
	 */

	public List<Sex> findSexData(List<Sex> sex){
        sexRepository.findAll().forEach(i->sex.add(i));
        return sex;
	}
	public List<Country> findAllCountries(List<Country> country){
		countries.findAll().forEach(c->country.add(c));
		return country;
	}
	public List<City> findAllCities(List<City> city){
		cityRepository.findAll().forEach(cit->city.add(cit));
		return city;
	}
	public List<Address> findAllTheAddress(List<Address> address){
		addressRepository.findAll().forEach(adr->address.add(adr));
		return address;
	}
	/***
	 * @author Josip Bošnjak
	 * @since 30.5.2019 17:47
	 * @param o any object of any class
	 * @param id id for finding a record in database
	 * @return list if there is a instance classes
	 * <strong>Since when we are updating values, there is no values to
	 * update when user click update and then there in no entry in new name.
	 * This function receives an object, which is instance one of our 5
	 * classes, and then returning a list which will be added to the model.</strong> 
	 */
	public List<Object> addToList(Object o, String id){
		List<Object> objectList = new ArrayList<>();
		if(o instanceof Sex) {
		   objectList.add(sexRepository.findOne(id));	
		}else if(o instanceof Country) {
			objectList.add(countries.findOne(id));
		}else if(o instanceof City) {
			objectList.add(cityRepository.findOne(id));
		}else if(o instanceof Address) {
			objectList.add(addressRepository.findOne(id));
		}else if(o instanceof Contact) {
			objectList.add(contactRepository.findOne(id));
		}
		return objectList;
	}
	 @GetMapping({"/", "/template"})
	    public String template(Model model) {
			List<Sex> sex = new ArrayList<>();
            sex=findSexData(sex);
	       
	        model.addAttribute("se",sex);
	        model.addAttribute(new Sex());
	        
	        List<Country> country = new ArrayList<>();
	        country=findAllCountries(country);
	        model.addAttribute("countryList",country);
	        model.addAttribute(new Country());
	        
	        List<City> city=new ArrayList<>();
	        city=findAllCities(city);        
	        model.addAttribute("cities", city);
	        model.addAttribute(new City());
	        
	        List<Address> address=new ArrayList<>();
	        address=findAllTheAddress(address);
	        model.addAttribute("addr",address);
	        model.addAttribute(new Address());
	        
	        List<Contact> contact=new ArrayList<>();
	        contactRepository.findAll().forEach(cnt->contact.add(cnt));
	        model.addAttribute("conta",contact);
	        model.addAttribute(new Contact());
	        
	     
	        return template;
	    }

	 /***
	  * @author Josip Bošnjak
	  * @since 25.5.2019 13:46
	  * @param name sex name
	  * @return redirect link to template since insertSex jsp does not exists
	  * if model validation is valid insert record into the database 
	  */
	 @PostMapping("/template/insertSex")
	 public String insertSex(@Valid Sex sex,Errors errors) {
		
		 if(errors.hasErrors()) {
			  
			  
			  return template;
		 }
		 sexRepository.save(sex);
			 
	      return redirect;
		 
		
	 }


	 
	 /***
	  * @author Josip Bošnjak
	  * @since 25.5.2019 15:00
	  * @param id
	  * @param name
	  * @return redirect to template after successfully update of record.
	  */
	 @PostMapping("/template/updateSex")
	 public String updateSex(@Valid Sex sex, Errors errors,Model model) {
         if(errors.hasErrors()) {
        	 model.addAttribute("se", addToList(sex, sex.getId().toString()));
        	 return template;
         }
         sexRepository.update(sex);
		 return redirect;
	 }
	
	 /***
	  * @author Josip Bošnjak
	  * @since 25.5.2019 17:16
	  * @param id 
	  * @return redirect to template site after successfully deletion
	  * <strong>Since we only need database id, we dont need a name
	  * as parameter in the function it will delete whole record 
	  * without name provided.</strong>
	  */
	 @PostMapping("/template/deleteSex")
	 public String deleteSex(@RequestParam("id")Long id) {
		 Sex sex=new Sex();
		 sex.setId(id);
		 sexRepository.delete(sex);
		 return redirect;
	 }
	 /***
	  * @author Josip Bošnjak
	  * @since 26.5.2019 11:16
	  * @param id
	  * @param name
	  * @param alpha_2
	  * @param alpha_3
	  * @return redirect if country is successfully inserted
	  */
	 /***
	  * Because your controller is annotated with @SessionAttributes("user") the model will be stored in session the first time it has been created. Subsequent requests will pull the model from session.
	  * @return
	  */
	 @ModelAttribute("sex")
	 public Sex createSex() {
	     return new Sex();
	 }
	 @ModelAttribute("country")
	 public Country createCountry() {
	     return new Country();
	 }
	 @ModelAttribute("city")
	 public City createCity() {
	     return new City();
	 }
	 @ModelAttribute("address")
	 public Address createAddress() {
	     return new Address();
	 }
	 @ModelAttribute("contact")
	 public Contact createContact() {
	     return new Contact();
	 }
	 
	 @PostMapping("/template/insertCountry")
	 public String insertCountry(@Valid Country country, Errors errors) {
		if(errors.hasErrors()) {
			return template;
		}
		 countries.save(country);
		 return redirect;
	 }
	 /***
	  * @author Josip Bošnjak
	  * @since 26.5.2019 12:07
	  * @param id
	  * @param name
	  * @param alpha_2
	  * @param alpha_3
	  * @return redirect if country is successfully updated
	  */
	 @PostMapping("/template/updateCountry")
	 public String updateCountry(@Valid Country country,Errors errors,Model model) {
		 if(errors.hasErrors()) {
			 model.addAttribute("countryList",addToList(country,country.getId().toString()));
			 return template;
		 }
		 countries.update(country);
		 return redirect;
	 }
	 /***
	  * @author Josip Bošnjak
	  * @since 26.5.2019 14:59
	  * @param id
	  * @return redirect to template if successfully deleted
	  */
	 @PostMapping("/template/deleteCountry")
	 public String deleteCountry(@RequestParam("id") Long id) {
		 Country country=new Country();
		 country.setId(id);
		 countries.delete(country);
		 return redirect;
	 }
	 /***
	  * @author Josip Bošnjak
	  * @since 26.5.2019 17:54
	  * @param name
	  * @param zip_code
	  * @param country_id
	  * @return redirect if successfuly inserted city
	  */
	 @PostMapping("/template/insertCity")
	 public String insertCity(@Valid City city,Errors errors) {
		 if(errors.hasErrors()) {
			 return template;
		 }
		 cityRepository.save(city);
		 return redirect;
	 }
	 /***
	  * @author Josip Bošnjak
	  * @since 26.5.2019 17:54
	  * @param id
	  * @param name
	  * @param zip_code
	  * @param country_id
	  * @return redirect if city is successfully updated
	  */
	 @PostMapping("/template/updateCity")
	 public String updateCity(@Valid City city, Errors errors, Model model) {
		 if(errors.hasErrors()) {
			 List<Country> country=new ArrayList<>();
			 model.addAttribute("cities", addToList(city,city.getId().toString()));
			 model.addAttribute("countryList",findAllCountries(country));
			 return template;
		 }
		 cityRepository.update(city);
		 return redirect;
	 }
	 /***
	  * @author Josip Bošnjak
	  * @since 26.5.2019 17:55
	  * @param id
	  * @return redirect to template if successfully deleted
	  */
	 @PostMapping("/template/deleteCity")
	 public String deleteCity(@RequestParam("id")Long id){
		 City city=new City();
		 city.setId(id);
		 cityRepository.delete(city);
		 return redirect;
	 }
	 /***
	  * @author Josip Bošnjak
	  * @since 27.5.2019 17:03
	  * @param street
	  * @param street_no
	  * @param city_id
	  * @return redirect if successfully inserted data into the table
	  */
	 @PostMapping("/template/insertAddress")
	 public String insertAddress(@Valid Address address, Errors errors) {
		 if(errors.hasErrors()) {
			 return template;
		 }
		 addressRepository.save(address);
		 return redirect;
	 }
	 /***
	  * @author Josip Bošnjak
	  * @since 27.5.2019 17:08
	  * @param id
	  * @param street
	  * @param street_no
	  * @param city_id
	  * @return redirect if update was successful
	  */
	 @PostMapping("/template/updateAddress")
	 public String updateAddress(@Valid Address address, Errors errors, Model model) {
		 if(errors.hasErrors()) {
			 List<City> city=new ArrayList<>();
			 List<Country> country=new ArrayList<>(); 
			 model.addAttribute("countryList",findAllCountries(country));
		     model.addAttribute("cities", findAllCities(city));
			 model.addAttribute("addr",addToList(address,address.getId().toString()));
			 return template;
		 }
		 addressRepository.update(address);
		 return redirect;
	 }
	 /***
	  * @author Josip Bošnjak
	  * @since 27.5.2019 17:11
	  * @param id
	  * @return redirect if successfully deleted
	  */
	 @PostMapping("/template/deleteAddress")
	 public String deleteAddress(@RequestParam("id")Long id) {
		 Address address = new Address();
		 address.setId(id);
		 addressRepository.delete(address);
		 return redirect;
	 }
	 /***
	  * @author Josip Bošnjak
	  * @since 27.5.2019 19:39
	  * @param first_name
	  * @param last_name
	  * @param phone
	  * @param email
	  * @param sex_id
	  * @param address_id
	  * @return redirect if data has been successfully saved into the database
	  */
	 @PostMapping("/template/insertContact")
	 public String insertContact(@Valid Contact contact, Errors errors) {
		 if(errors.hasErrors()) {
			 return template;
		 }
		 contactRepository.save(contact);
		 return redirect;
	 }
	 /***
	  * @author Josip Bošnjak
	  * @since 27.5.2019 19:42
	  * @param id
	  * @param first_name
	  * @param last_name
	  * @param phone
	  * @param email
	  * @param sex_id
	  * @param address_id
	  * @return redirect if data has been updated.
	  */
	 @PostMapping("/template/updateContact")
	 public String updateContact(@Valid Contact contact, Errors errors,Model model) {
		 if(errors.hasErrors()) {
			 List<Sex> sex=new ArrayList<>();
			 List<Country> count=new ArrayList<>();
			 List<City> city=new ArrayList<>();
			 List<Address> address=new ArrayList<>();
		     model.addAttribute("addr",findAllTheAddress(address));
			 model.addAttribute("cities", findAllCities(city));
			 model.addAttribute("countryList",findAllCountries(count));
			 model.addAttribute("se",findSexData(sex));
			 model.addAttribute("conta",addToList(contact, contact.getId().toString()));
			 return template;
		 }
		 contactRepository.update(contact);
		 return redirect;
	 }
	 /***
	  * @author Josip Bošnjak
	  * @since 27.5.2019 19:44
	  * @param id
	  * @return redirect if contact has been successfuly deleted from the database.
	  */
	 @PostMapping("/template/deleteContact")
	 public String deleteContact(@RequestParam("id")Long id) {
		 Contact contact=new Contact();
		 contact.setId(id);
		 contactRepository.delete(contact);
		 return redirect;
	 }
}
