package com.josip.personal.address.book.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.josip.personal.address.book.data.access.layer.SexRepository;

@Controller
public class TemplateController {

	private final SexRepository sexRepository;
	
	@Autowired
	public TemplateController(SexRepository sexRepository) {
		this.sexRepository=sexRepository;
	}
	
	@RequestMapping(value="/")
	public String getTemplate() {
		return "template";
	}
	
}
