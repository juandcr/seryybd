package com.mx.jcfi.cumple.seryy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mx.jcfi.cumple.seryy.entity.Message;
import com.mx.jcfi.cumple.seryy.iterador.PageRender;
import com.mx.jcfi.cumple.seryy.service.IMessageService;

@Controller
public class indexController {
	
	
	@Autowired
	IMessageService mensajeService;
	
	@GetMapping(value = "/")
	public String index() {		
		return "index";		
	}
	
	@GetMapping(value="/listar")
	public String listar( @RequestParam (name="page" ,defaultValue ="0") int page,Model model) {
		Pageable pageRequest = PageRequest.of(page, 5);
		Page <Message> mensajes= mensajeService.findAll(pageRequest);
		PageRender<Message> pageRender= new PageRender<Message> ("listar",mensajes);		
		model.addAttribute("page", pageRender);
		model.addAttribute("mensajes", mensajes);
		return "listar";
	}	
	

	
	@GetMapping(value="mensaje")
	public String newMensaje(Model model) {
		Message mensaje= new Message();
		model.addAttribute("mensaje", mensaje);
		return "form";
	}
	
	@PostMapping(value="mensaje")
	public String saveMensaje(Message mensaje) {
		mensajeService.save(mensaje);
		return "redirect:/";
	}
	
	
}
