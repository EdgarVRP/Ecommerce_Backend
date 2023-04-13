package com.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")

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
	private String codigo_postal;
	private String carrito_productos;
	private String carrito_molido;
	private String carrito_tostado;
	private String carrito_cantidad;
	private String es_admin;

	public Usuario() { // empty constructor

	}

	public Usuario(Long id, String nombre, String apellido, String email, String password, String telefono,
			String nacimiento, String calle, String numero, String colonia, String municipio, String estado,
			String codigo_postal, String carrito_productos, String carrito_molido, String carrito_tostado,
			String carrito_cantidad, String es_admin) {

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
		this.codigo_postal = codigo_postal;
		this.carrito_productos = carrito_productos;
		this.carrito_molido = carrito_molido;
		this.carrito_tostado = carrito_tostado;
		this.carrito_cantidad = carrito_cantidad;
		this.es_admin = es_admin;
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

	public String getCodigo_postal() {
		return codigo_postal;
	}

	public void setCodigo_postal(String codigo_postal) {
		this.codigo_postal = codigo_postal;
	}

	public String getCarrito_productos() {
		return carrito_productos;
	}

	public void setCarrito_productos(String carrito_productos) {
		this.carrito_productos = carrito_productos;
	}

	public String getCarrito_molido() {
		return carrito_molido;
	}

	public void setCarrito_molido(String carrito_molido) {
		this.carrito_molido = carrito_molido;
	}

	public String getCarrito_tostado() {
		return carrito_tostado;
	}

	public void setCarrito_tostado(String carrito_tostado) {
		this.carrito_tostado = carrito_tostado;
	}

	public String getCarrito_cantidad() {
		return carrito_cantidad;
	}

	public void setCarrito_cantidad(String carrito_cantidad) {
		this.carrito_cantidad = carrito_cantidad;
	}

	public String getEs_admin() {
		return es_admin;
	}

	public void setEs_admin(String es_admin) {
		this.es_admin = es_admin;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", password=" + password + ", telefono=" + telefono + ", nacimiento=" + nacimiento + ", calle="
				+ calle + ", numero=" + numero + ", colonia=" + colonia + ", municipio=" + municipio + ", estado="
				+ estado + ", codigopostal=" + codigo_postal + ", carrito_productos=" + carrito_productos
				+ ", carrito_molido=" + carrito_molido + ", carrito_tostado=" + carrito_tostado + ", carrito_cantidad="
				+ carrito_cantidad + ", es_admin=" + es_admin + "]";
	}

}