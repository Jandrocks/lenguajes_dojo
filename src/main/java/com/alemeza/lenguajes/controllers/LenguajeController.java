package com.alemeza.lenguajes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alemeza.lenguajes.models.LenguajeModelo;
import com.alemeza.lenguajes.services.LenguajeServ;

import jakarta.validation.Valid;


@Controller
public class LenguajeController {

	@Autowired
	private LenguajeServ lenguajeserv;	
	
	@GetMapping("/")
	public String raiz() {
		return "redirect:/lenguajes";
	}
	
	//listar
	@GetMapping("/lenguajes")
	public ModelAndView index(Model viewModel) {
		List<LenguajeModelo> langs = lenguajeserv.allLenguajes();
		viewModel.addAttribute("lenguaje", langs);
		return new ModelAndView("index.jsp");
	}
	//crear
	@GetMapping("/lenguaje/new")
	public String newLenguaje(@ModelAttribute("lenguajeNuevo") LenguajeModelo lang) {
		return "nuevoLenguaje.jsp";
	}

	@PostMapping("/lenguaje/new")
	public String newLenguaje(@Valid @ModelAttribute("lenguajeNuevo") LenguajeModelo lang, BindingResult result) {
		if (result.hasErrors()) {
			return "nuevoLenguaje.jsp";
		} else {
			lenguajeserv.createLenguaje(lang);
			return "redirect:/lenguajes";
		}
	}
	
	//edita
	@GetMapping("/lenguajes/edit/{id}")
	public String editarLenguaje(@ModelAttribute("editLenguaje") LenguajeModelo lang, Model model,
			@PathVariable("id") Long id) {
		model.addAttribute("lenguaje", lenguajeserv.findLangById(id));
		return "editarLenguaje.jsp";
	}
	
	//borrar
	@GetMapping("/lenguajes/delete/{id}")
	public String deleteLenguaje(@PathVariable("id") Long id) {
		lenguajeserv.deleteLenguaje(id);
		return "redirect:/lenguajes";
	}
	//muestra
	@GetMapping("/lenguajes/{id}")
	public String showLenguajes(@PathVariable("id") Long id, Model viewModel) {
		viewModel.addAttribute("lenguaje", lenguajeserv.findLangById(id));
		return "muestraLenguajesid.jsp";
	}


}
	
