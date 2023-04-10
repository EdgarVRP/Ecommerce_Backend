package com.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")

public class Usuario {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	
	private Long id;
	private String nombre;
	private String apellido;
	private String email;
	private String password;
	private String telefono;
	private String nacimiento;
	private String calle;
	private String numero;
	private String colonia;
	private String municipio;
	private String estado;
	private String codigopostal;
	private String carritoProductos;
	private String carritoMolido;
	private String carritoTostado;
	private String carritoCantidad;
	private String esAdmin;
	
	public Usuario() { //empty constructor
		
	}

	public Usuario(Long id, String nombre, String apellido, String email, String password, String telefono,
			String nacimiento, String calle, String numero, String colonia, String municipio, String estado,
			String codigopostal, String carritoProductos, String carritoMolido, String carritoTostado,
			String carritoCantidad, String esAdmin) {
				
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.telefono = telefono;
		this.nacimiento = nacimiento;
		this.calle = calle;
		this.numero = numero;
		this.colonia = colonia;
		this.municipio = municipio;
		this.estado = estado;
		this.codigopostal = codigopostal;
		this.carritoProductos = carritoProductos;
		this.carritoMolido = carritoMolido;
		this.carritoTostado = carritoTostado;
		this.carritoCantidad = carritoCantidad;
		this.esAdmin = esAdmin;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(String nacimiento) {
		this.nacimiento = nacimiento;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCodigopostal() {
		return codigopostal;
	}

	public void setCodigopostal(String codigopostal) {
		this.codigopostal = codigopostal;
	}

	public String getCarritoProductos() {
		return carritoProductos;
	}

	public void setCarritoProductos(String carritoProductos) {
		this.carritoProductos = carritoProductos;
	}

	public String getCarritoMolido() {
		return carritoMolido;
	}

	public void setCarritoMolido(String carritoMolido) {
		this.carritoMolido = carritoMolido;
	}

	public String getCarritoTostado() {
		return carritoTostado;
	}

	public void setCarritoTostado(String carritoTostado) {
		this.carritoTostado = carritoTostado;
	}

	public String getCarritoCantidad() {
		return carritoCantidad;
	}

	public void setCarritoCantidad(String carritoCantidad) {
		this.carritoCantidad = carritoCantidad;
	}

	public String getEsAdmin() {
		return esAdmin;
	}

	public void setEsAdmin(String esAdmin) {
		this.esAdmin = esAdmin;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", password=" + password + ", telefono=" + telefono + ", nacimiento=" + nacimiento + ", calle="
				+ calle + ", numero=" + numero + ", colonia=" + colonia + ", municipio=" + municipio + ", estado="
				+ estado + ", codigopostal=" + codigopostal + ", carritoProductos=" + carritoProductos
				+ ", carritoMolido=" + carritoMolido + ", carritoTostado=" + carritoTostado + ", carritoCantidad="
				+ carritoCantidad + ", esAdmin=" + esAdmin + "]";
	}
	
}
