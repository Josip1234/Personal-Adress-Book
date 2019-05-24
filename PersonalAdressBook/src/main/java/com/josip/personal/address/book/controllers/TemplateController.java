package com.josip.personal.address.book.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.josip.personal.address.book.data.access.layer.SexRepository;
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
 * </strong>
 */
@Controller
public class TemplateController {

	private final SexRepository sexRepository;
	
	@Autowired
	public TemplateController(SexRepository sexRepository) {
		this.sexRepository=sexRepository;
	}
	
	 @GetMapping({"/", "/template"})
	    public String template(Model model) {
	        List<Sex> sex = new ArrayList<>();
	        sexRepository.findAll().forEach(i->sex.add(i));
	       
	        model.addAttribute("sex",sex);
	        return "template";
	    }

	
}
