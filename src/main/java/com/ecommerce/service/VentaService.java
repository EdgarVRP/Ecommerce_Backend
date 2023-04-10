package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.model.Venta;
import com.ecommerce.repository.VentaRepository;

@Service
public class VentaService {

	private final VentaRepository ventaRepository;

	@Autowired
	public VentaService(VentaRepository ventaRepository) {
		this.ventaRepository = ventaRepository;

	}

	// Get
	// Obtiene el elemento de la tabla
	public List<Venta> getVentas() {
		return ventaRepository.findAll();
	}

	public Venta getVenta(Long id) {
		return ventaRepository.findById(id).orElseThrow(() -> new IllegalStateException("The element dont exist"));
	}

	// Post
	// Guarda un nuevo elemento
	public Venta addVenta(Venta venta) {
		return ventaRepository.save(venta);
	}

	// Put
	// Busca el elemento para actualizarlo si no lo encuentra lo crea
	public Venta updateVenta(Venta newVenta, Long id) {
		return ventaRepository.findById(id)
				.map(venta -> {
					venta.setIdUsuario(newVenta.getIdUsuario());
					return ventaRepository.save(venta);
				})
				.orElseGet(() -> {
					return ventaRepository.save(newVenta);
				});
	}

	//Actualiza algunos campos del elemento?
	//Transactional es como un commit si alfo falla regresa a su estado inicial
	@Transactional
	public void updateVenta(Long id, String name, String info) {
		Venta venta = ventaRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException("The element dont exist"));

		if ((name != null))
			if ((!name.isEmpty())) {
				venta.setIdUsuario(name);
			}
	}

	// Delete
	// Borra el elemento por id
	public void deleteVenta(Long id) {
		ventaRepository.deleteById(id);
	}

}
