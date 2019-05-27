package com.josip.personal.address.book.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.josip.personal.address.book.data.access.layer.AddressRepository;
import com.josip.personal.address.book.data.access.layer.CityRepository;
import com.josip.personal.address.book.data.access.layer.CountryRepository;
import com.josip.personal.address.book.data.access.layer.SexRepository;
import com.josip.personal.address.book.presentation.layer.Address;
import com.josip.personal.address.book.presentation.layer.City;
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
	private final String redirect="redirect:/template";
	private final String template="template";
	
	@Autowired
	public TemplateController(SexRepository sexRepository, CountryRepository country, CityRepository cityRepository, AddressRepository addressRepository) {
		this.sexRepository=sexRepository;
		this.countries=country;
		this.cityRepository=cityRepository;
		this.addressRepository=addressRepository;
	}
	/***
	 * @author Josip Bošnjak
	 * @since 24.5.2019. 14:10
	 * @param model
	 * @return view template with generated form for insert new sex, country, city
	 */
	 @GetMapping({"/", "/template"})
	    public String template(Model model) {
	        List<Sex> sex = new ArrayList<>();
	        sexRepository.findAll().forEach(i->sex.add(i));
	       
	        model.addAttribute("se",sex);
	        model.addAttribute(new Sex());
	        
	        List<Country> country = new ArrayList<>();
	        countries.findAll().forEach(c->country.add(c));
	        model.addAttribute("countryList",country);
	        model.addAttribute(new Country());
	        
	        List<City> city=new ArrayList<>();
	        cityRepository.findAll().forEach(ci->city.add(ci));          
	        model.addAttribute("cities", city);
	        model.addAttribute(new City());
	        
	        List<Address> address=new ArrayList<>();
	        addressRepository.findAll().forEach(ad->address.add(ad));
	        model.addAttribute("address",address);
	        model.addAttribute(new Address());
	        return template;
	    }

	 /***
	  * @author Josip Bošnjak
	  * @since 25.5.2019 13:46
	  * @param name sex name
	  * @return redirect link to template since insertSex jsp does not exists
	  */
	 @PostMapping("/template/insertSex")
	 public String insertSex(@RequestParam("name") String name) {
		 Sex sex=new Sex();
		 sex.setName(name);
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
	 public String updateSex(@RequestParam("id")Long id,@RequestParam("name") String name) {
         Sex sex=new Sex();
         sex.setId(id);
         sex.setName(name);
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
	 @PostMapping("/template/insertCountry")
	 public String insertCountry(@RequestParam("name")String name,@RequestParam("alpha_2")String alpha_2,@RequestParam("alpha_3")String alpha_3) {
		 Country country=new Country();
		 country.setName(name);
		 country.setAlpha_2(alpha_2);
		 country.setAlpha_3(alpha_3);
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
	 public String updateCountry(@RequestParam("id") Long id,@RequestParam("name")String name,@RequestParam("alpha_2")String alpha_2,@RequestParam("alpha_3")String alpha_3) {
		 Country country=new Country();
		 country.setId(id);
		 country.setName(name);
		 country.setAlpha_2(alpha_2);
		 country.setAlpha_3(alpha_3);
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
	 public String insertCity(@RequestParam("name")String name, @RequestParam("zip_code")String zip_code, @RequestParam("country_id")Long country_id) {
		 City city=new City();
		 city.setName(name);
		 city.setZip_code(zip_code);
		 city.setCountry_id(country_id);
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
	 public String updateCity(@RequestParam("id")Long id,@RequestParam("name")String name, @RequestParam("zip_code")String zip_code, @RequestParam("country_id")Long country_id ) {
		 City city=new City();
		 city.setId(id);
		 city.setName(name);
		 city.setZip_code(zip_code);
		 city.setCountry_id(country_id);
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
}
