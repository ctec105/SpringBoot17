package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.IUsuarioDAO;
import com.example.demo.entity.Usuario;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private IUsuarioDAO usuarioDAO;

	@GetMapping("/")
	public String listarUsuarios(Model model) {
		model.addAttribute("usuarios", usuarioDAO.findAll());
		return "listarusuarios";
	}

	@GetMapping("/detalle/{id}")
	public String buscarUsuarioPorId(@PathVariable("id") Long id, Model model) {
		Usuario u = usuarioDAO.getOne(id);
		model.addAttribute("usuario", u);
		return "detalleusuario";
	}
	
}
