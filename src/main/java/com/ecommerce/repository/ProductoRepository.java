package com.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecommerce.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    /*
     * @Query("SELECT u FROM Producto u WHERE u.idProducto = ?1")
     * Optional<Producto> findById(Long id);
     */
}
