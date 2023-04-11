package com.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecommerce.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query("SELECT u FROM Usuario u WHERE u.email = ?1")
    Optional<Usuario> findByEmail(String email);

    @Query("SELECT u FROM Usuario u WHERE u.email = ?1 AND u.password = ?2")
    Optional<Usuario> findByEmailAndPassword(String email, String password);

    // @Query("SELECT COUNT(u.id) FROM Usuario u WHERE u.email=:email") 
    // Long countUsersWithEmail(String email);

//     @Query("SELECT t FROM Tutorial t")
// List<Tutorial> findAll();

// @Query("SELECT t FROM Tutorial t WHERE t.published=true")
// List<Tutorial> findByPublished();

	// Usuario findByUsername(String username);
    // Optional<Usuario> findByEmail(String email);
}
