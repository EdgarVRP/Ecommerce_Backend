package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.model.Producto;
import com.ecommerce.repository.ProductoRepository;

@Service
public class ProductoService {

	private final ProductoRepository productoRepository;

	@Autowired
	public ProductoService(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;

	}

	// Get
	// Obtiene el elemento de la tabla
	public List<Producto> getProductos() {
		return productoRepository.findAll();
	}

	public Producto getProducto(Long id) {
		return productoRepository.findById(id).orElseThrow(() -> new IllegalStateException("The element dont exist"));
	}

	// Post
	// Guarda un nuevo elemento
	public Producto addProducto(Producto producto) {
		System.out.println("Producto agregado: " + producto.toString());
		return productoRepository.save(producto);
	}

	// Put
	// Busca el elemento para actualizarlo si no lo encuentra lo crea
	public Producto updateProducto(Producto newProducto, Long id) {
		return productoRepository.findById(id)
				.map(producto -> {
					producto.setNombre(newProducto.getNombre());
					return productoRepository.save(producto);
				})
				.orElseGet(() -> {
					return productoRepository.save(newProducto);
				});
	}

	// Actualiza algunos campos del elemento?
	// Transactional es como un commit si alfo falla regresa a su estado inicial
	@Transactional
	public void updateProducto(
			Long id,
			String nombre,
			String rutaimagen,
			String region,
			String cosecha,
			String altura,
			Integer humedad,
			String proceso,
			String preparacion,
			String variedad,
			Double precio,
			Integer inventario,
			String nota,
			Integer puntuacion) {
		Producto productoBuscado = productoRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException("The element dont exist"));
		if (nombre != null)
			productoBuscado.setNombre(nombre);
		if (rutaimagen != null)
			productoBuscado.setRutaimagen(rutaimagen);
		if (region != null)
			productoBuscado.setRegion(region);
		if (cosecha != null)
			productoBuscado.setCosecha(cosecha);
		if (altura != null)
			productoBuscado.setAltura(altura);
		if (humedad != null)
			productoBuscado.setHumedad(humedad);
		if (proceso != null)
			productoBuscado.setProceso(proceso);
		if (preparacion != null)
			productoBuscado.setPreparacion(preparacion);
		if (variedad != null)
			productoBuscado.setVariedad(variedad);
		if (precio != null)
			productoBuscado.setPrecio(precio);
		if (inventario != null)
			productoBuscado.setInventario(inventario);
		productoRepository.save(productoBuscado);
		System.out.println("Producto actualizado: " + productoBuscado.toString());
	}

	// Delete
	// Borra el elemento por id
	public void deleteProducto(Long id) {
		productoRepository.deleteById(id);
	}

}
