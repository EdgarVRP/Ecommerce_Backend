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

import com.ecommerce.model.Venta;
import com.ecommerce.service.VentaService;

@RestController
@RequestMapping(path = "/ventas")
public class VentaController {

	private final VentaService ventaService;

	@Autowired
	public VentaController(VentaService ventaService) {
		this.ventaService = ventaService;
	}

	// GET
	// Por defecto, obtiene todolos elementos de la tabla
	// Return los elemento
	@GetMapping
	public List<Venta> getVentas() {
		return ventaService.getVentas();
	}

	// Obtiene un elemento de la tabla por el id
	// Regresa
	@GetMapping(path = "/{id}")
	public Venta getVenta(@PathVariable("id") Long id) {
		return ventaService.getVenta(id);
	}

	// POST
	// Crea un elemento
	@PostMapping()
	public Venta addVenta(@RequestBody Venta venta) {
		return ventaService.addVenta(venta);
	}

	// PUT
	// Actualiza o crea un elemento
	@PutMapping(path = "/{id}")
	Venta updateVentaJSON(@RequestBody Venta venta, @PathVariable("id") Long id) {
		return ventaService.updateVenta(venta, id);
	}

	@PutMapping(path = "/url/{id}")
	public void updateVentaURL(@PathVariable("id") Long id,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String info) {
		ventaService.updateVenta(id, name, info);
	}

	// DELETE
	// Elimina un elemento de la tabla
	@DeleteMapping(path = "/{id}")
	public void deleteVenta(@PathVariable("id") Long id) {
		ventaService.deleteVenta(id);
	}

}
