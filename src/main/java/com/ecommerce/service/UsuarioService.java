package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.model.Usuario;
import com.ecommerce.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;

	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;

	}

	// Get
	// Obtiene el elemento de la tabla
	public List<Usuario> getUsuarios() {
		return usuarioRepository.findAll();
	}

	public Usuario getUsuario(Long id) {
		return usuarioRepository.findById(id).orElseThrow(() -> new IllegalStateException("El usuario no existe"));
	}

	public Usuario loginUsuario(String email, String password) {
		return usuarioRepository.findByEmailAndPassword(email, password).orElseThrow(() -> new IllegalStateException("Usuario o contraseña incorrectos"));
	}

	public Usuario addUsuario(Usuario usuario) {
        Optional<Usuario> usuarioByName = usuarioRepository.findByEmail(usuario.getEmail());
        if (usuarioByName.isPresent()) {
			return new Usuario();
            // throw new IllegalStateException("El correo " + usuario.getEmail() + " ya esta registrado");
        } else {
			return usuarioRepository.save(usuario);
		}
    }

	// Put
	// Busca el elemento para actualizarlo si no lo encuentra lo crea
	public Usuario updateUsuario(Usuario newUsuario, Long id) {
		return usuarioRepository.findById(id)
				.map(usuario -> {
					usuario.setNombre(newUsuario.getNombre());
					return usuarioRepository.save(usuario);
				})
				.orElseGet(() -> {
					return usuarioRepository.save(newUsuario);
				});
	}

	//Actualiza algunos campos del elemento?
	//Transactional es como un commit si alfo falla regresa a su estado inicial
	@Transactional
	public void updateUsuario(Long id, String name, String info) {
		Usuario usuario = usuarioRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException("The element dont exist"));

		if ((name != null))
			if ((!name.isEmpty())) {
				usuario.setNombre(name);
			}
	}

	// Delete
	// Borra el elemento por id
	public void deleteUsuario(Long id) {
		usuarioRepository.deleteById(id);
	}
}
