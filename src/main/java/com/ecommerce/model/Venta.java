package com.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ventas")

public class Venta {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	
	private Long id;
	private String idUsuario;
	private String idProducto;
	private String fechaEntrega;
	private String fechaPago;
	private String precioVenta;
	private String tostado;
	private String molido;
	
	public Venta() { //empty constructor
		
	}

	public Venta(Long id, String idUsuario, String idProducto, String fechaEntrega, String fechaPago,
			String precioVenta, String tostado, String molido) {
		this.id = id;
		this.idUsuario = idUsuario;
		this.idProducto = idProducto;
		this.fechaEntrega = fechaEntrega;
		this.fechaPago = fechaPago;
		this.precioVenta = precioVenta;
		this.tostado = tostado;
		this.molido = molido;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public String getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public String getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}

	public String getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(String precioVenta) {
		this.precioVenta = precioVenta;
	}

	public String getTostado() {
		return tostado;
	}

	public void setTostado(String tostado) {
		this.tostado = tostado;
	}

	public String getMolido() {
		return molido;
	}

	public void setMolido(String molido) {
		this.molido = molido;
	}

	@Override
	public String toString() {
		return "Venta [id=" + id + ", idUsuario=" + idUsuario + ", idProducto=" + idProducto + ", fechaEntrega="
				+ fechaEntrega + ", fechaPago=" + fechaPago + ", precioVenta=" + precioVenta + ", tostado=" + tostado
				+ ", molido=" + molido + "]";
	}

	
}
