package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Producto;
import com.ecommerce.service.ProductoService;

@RestController
@RequestMapping(path = "/productos")
public class ProductoController {

	private final ProductoService productoService;

	@Autowired
	public ProductoController(ProductoService productoService) {
		this.productoService = productoService;
	}

	// GET
	// Por defecto, obtiene todolos elementos de la tabla
	// Return los elemento
	@GetMapping
	public List<Producto> getProductos() {
		return productoService.getProductos();
	}

	// Obtiene un elemento de la tabla por el id
	// Regresa
	@GetMapping(path = "/{id}")
	public Producto getProducto(@PathVariable("id") Long id) {
		return productoService.getProducto(id);
	}

	// POST
	// Crea un elemento
	@PostMapping()
	public Producto addProducto(@RequestBody Producto producto) {
		return productoService.addProducto(producto);
	}

	// PUT
	// Actualiza o crea un elemento
	@PutMapping(path = "/{id}/test")
	Producto updateProductoJSON(@RequestBody Producto producto, @PathVariable("id") Long id) {
		return productoService.updateProducto(producto, id);
	}

	@PutMapping(path = "{id}")
	public void updateProducto(@PathVariable("id") Long id,
			@RequestParam(required = false) String nombre,
			@RequestParam(required = false) String rutaimagen,
			@RequestParam(required = false) String region,
			@RequestParam(required = false) String cosecha,
			@RequestParam(required = false) String altura,
			@RequestParam(required = false) Integer humedad,
			@RequestParam(required = false) String proceso,
			@RequestParam(required = false) String preparacion,
			@RequestParam(required = false) String variedad,
			@RequestParam(required = false) Double precio,
			@RequestParam(required = false) Integer inventario,
			@RequestParam(required = false) String nota,
			@RequestParam(required = false) Integer puntuacion) {
		productoService.updateProducto(
				id,
				nombre,
				rutaimagen,
				region,
				cosecha,
				altura,
				humedad,
				proceso,
				preparacion,
				variedad,
				precio,
				inventario,
				nota,
				puntuacion);
	}

	// DELETE
	// Elimina un elemento de la tabla
	@DeleteMapping(path = "/{id}")
	public void deleteProducto(@PathVariable("id") Long id) {
		productoService.deleteProducto(id);
	}

}
