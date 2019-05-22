package com.josip.personal.address.book.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.josip.personal.address.book.data.access.layer.SexRepository;

@Controller
@RequestMapping("/template")
public class TemplateController {

	private final SexRepository sexRepository;
	
	@Autowired
	public TemplateController(SexRepository sexRepository) {
		this.sexRepository=sexRepository;
	}
}
