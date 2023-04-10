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
	@PutMapping(path = "/{id}")
	Producto updateProductoJSON(@RequestBody Producto producto, @PathVariable("id") Long id) {
		return productoService.updateProducto(producto, id);
	}

	@PutMapping(path = "/url/{id}")
	public void updateProductoURL(@PathVariable("id") Long id,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String info) {
		productoService.updateProducto(id, name, info);
	}

	// DELETE
	// Elimina un elemento de la tabla
	@DeleteMapping(path = "/{id}")
	public void deleteProducto(@PathVariable("id") Long id) {
		productoService.deleteProducto(id);
	}

}
