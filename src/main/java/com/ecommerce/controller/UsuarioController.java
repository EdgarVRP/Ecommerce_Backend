package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Usuario;
import com.ecommerce.service.UsuarioService;

@RestController
@RequestMapping(path = "/usuarios")
public class UsuarioController {

	private final UsuarioService usuarioService;

	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	// GET
	// Por defecto, obtiene todolos elementos de la tabla
	// Return los elemento
	@GetMapping
	public List<Usuario> getUsuarios() {
		return usuarioService.getUsuarios();
	}

	// Obtiene un elemento de la tabla por el id
	// Regresa
	@GetMapping(path = "/{id}")
	public Usuario getUsuario(@PathVariable("id") Long id) {
		return usuarioService.getUsuario(id);
	}

	// Obtiene un elemento de la tabla por el id
	// Regresa
	@GetMapping(path = "/login")
	public Usuario loginUsuario(
			@RequestParam(required = true) String email,
			@RequestParam(required = true) String password) {
		return usuarioService.loginUsuario(email, password);
	}

	// @RequestParam(required = false) String name,
	// @RequestParam(required = false) String info

	// POST
	// Crea un elemento
	// @RequestMapping(value="", method=RequestMethod.POST, produces="text/plain")
	// @PostMapping()
	// public String addUsuario(@RequestBody Usuario usuario) {
	// return "\"" + usuarioService.addUsuario(usuario) + "\"";
	// }

	@PostMapping()
	public Usuario addUsuario(@RequestBody Usuario usuario) {
		return usuarioService.addUsuario(usuario);
	}

	// PUT
	// Actualiza o crea un elemento
	@PutMapping(path = "/{id}")
	Usuario updateUsuarioJSON(@RequestBody Usuario usuario, @PathVariable("id") Long id) {
		return usuarioService.updateUsuario(usuario, id);
	}

	@PutMapping(path = "/url/{id}")
	public void updateUsuarioURL(@PathVariable("id") Long id,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String info) {
		usuarioService.updateUsuario(id, name, info);
	}

	// DELETE
	// Elimina un elemento de la tabla
	@DeleteMapping(path = "/{id}")
	public void deleteUsuario(@PathVariable("id") Long id) {
		System.out.println("Delete");
		usuarioService.deleteUsuario(id);
	}

}
