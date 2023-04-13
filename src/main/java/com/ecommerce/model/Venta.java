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
	private String id_usuario;
	private String id_producto;
	private String fecha_entrega;
	private String fecha_pago;
	private String precio_venta;
	private String tostado;
	private String molido;
	
	public Venta() { //empty constructor
		
	}

	public Venta(Long id, String id_usuario, String id_producto, String fecha_entrega, String fecha_pago,
			String precio_venta, String tostado, String molido) {
		this.id = id;
		this.id_usuario = id_usuario;
		this.id_producto = id_producto;
		this.fecha_entrega = fecha_entrega;
		this.fecha_pago = fecha_pago;
		this.precio_venta = precio_venta;
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
		return id_usuario;
	}

	public void setIdUsuario(String id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getIdProducto() {
		return id_producto;
	}

	public void setIdProducto(String id_producto) {
		this.id_producto = id_producto;
	}

	public String getFechaEntrega() {
		return fecha_entrega;
	}

	public void setFechaEntrega(String fecha_entrega) {
		this.fecha_entrega = fecha_entrega;
	}

	public String getFechaPago() {
		return fecha_pago;
	}

	public void setFechaPago(String fecha_pago) {
		this.fecha_pago = fecha_pago;
	}

	public String getPrecioVenta() {
		return precio_venta;
	}

	public void setPrecioVenta(String precio_venta) {
		this.precio_venta = precio_venta;
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
		return "Venta [id=" + id + ", id_usuario=" + id_usuario + ", id_producto=" + id_producto + ", fecha_entrega="
				+ fecha_entrega + ", fecha_pago=" + fecha_pago + ", precio_venta=" + precio_venta + ", tostado=" + tostado
				+ ", molido=" + molido + "]";
	}

	
}
