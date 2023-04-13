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
		return usuarioRepository.findByEmailAndPassword(email, password)
				.orElseThrow(() -> new IllegalStateException("Usuario o contraseña incorrectos"));
	}

	public Usuario addUsuario(Usuario usuario) {
		Optional<Usuario> usuarioByName = usuarioRepository.findByEmail(usuario.getEmail());
		if (usuarioByName.isPresent()) {
			return new Usuario();
			// throw new IllegalStateException("El correo " + usuario.getEmail() + " ya esta
			// registrado");
		} else {
			return usuarioRepository.save(usuario);
		}
	}

	// Put
	// Busca el elemento para actualizarlo si no lo encuentra lo crea
	public Usuario updateUsuario(Usuario newUsuario, Long id) {
		return usuarioRepository.findById(id)
				.map(usuario -> {
					if (newUsuario.getNombre() != null && !newUsuario.getNombre().isEmpty()) {
						usuario.setNombre(newUsuario.getNombre());
					}
					if (newUsuario.getApellido() != null && !newUsuario.getApellido().isEmpty()) {
						usuario.setApellido(newUsuario.getApellido());
					}
					if (newUsuario.getEmail() != null && !newUsuario.getEmail().isEmpty()) {
						usuario.setEmail(newUsuario.getEmail());
					}
					if (newUsuario.getPassword() != null && !newUsuario.getPassword().isEmpty()) {
						usuario.setPassword(newUsuario.getPassword());
					}
					if (newUsuario.getTelefono() != null && !newUsuario.getTelefono().isEmpty()) {
						usuario.setTelefono(newUsuario.getTelefono());
					}
					if (newUsuario.getNacimiento() != null && !newUsuario.getNacimiento().isEmpty()) {
						usuario.setNacimiento(newUsuario.getNacimiento());
					}
					if (newUsuario.getCalle() != null && !newUsuario.getCalle().isEmpty()) {
						usuario.setCalle(newUsuario.getCalle());
					}
					if (newUsuario.getNumero() != null && !newUsuario.getNumero().isEmpty()) {
						usuario.setNumero(newUsuario.getNumero());
					}
					if (newUsuario.getColonia() != null && !newUsuario.getColonia().isEmpty()) {
						usuario.setColonia(newUsuario.getColonia());
					}
					if (newUsuario.getMunicipio() != null && !newUsuario.getMunicipio().isEmpty()) {
						usuario.setMunicipio(newUsuario.getMunicipio());
					}
					if (newUsuario.getEstado() != null && !newUsuario.getEstado().isEmpty()) {
						usuario.setEstado(newUsuario.getEstado());
					}
					if (newUsuario.getCodigo_postal() != null && !newUsuario.getCodigo_postal().isEmpty()) {
						usuario.setCodigo_postal(newUsuario.getCodigo_postal());
					}
					if (newUsuario.getCarrito_productos() != null) {
						usuario.setCarrito_productos(newUsuario.getCarrito_productos());
					}
					if (newUsuario.getCarrito_molido() != null) {
						usuario.setCarrito_molido(newUsuario.getCarrito_molido());
					}
					if (newUsuario.getCarrito_tostado() != null) {
						usuario.setCarrito_tostado(newUsuario.getCarrito_tostado());
					}
					if (newUsuario.getCarrito_cantidad() != null) {
						usuario.setCarrito_cantidad(newUsuario.getCarrito_cantidad());
					}

					return usuarioRepository.save(usuario);
				})
				.orElseGet(() -> {
					return usuarioRepository.save(newUsuario);
				});
	}

	// Actualiza algunos campos del elemento?
	// Transactional es como un commit si alfo falla regresa a su estado inicial
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