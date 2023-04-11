package com.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productos")

public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)

	private Long id;
	private String nombre;
	private String rutaimagen;
	private String region;
	private String cosecha;
	private String altura;
	private Integer humedad;
	private String proceso;
	private String preparacion;
	private String variedad;
	private Double precio;
	private Integer inventario;
	private String nota;
	private Integer puntuacion;

	public Producto() { // empty constructor

	}

	public Producto(Long id, String nombre, String rutaimagen, String region, String cosecha, String altura,
			Integer humedad, String proceso, String preparacion, String variedad, Double precio, Integer inventario,
			String nota, Integer puntuacion) {
		this.id = id;
		this.nombre = nombre;
		this.rutaimagen = rutaimagen;
		this.region = region;
		this.cosecha = cosecha;
		this.altura = altura;
		this.humedad = humedad;
		this.proceso = proceso;
		this.preparacion = preparacion;
		this.variedad = variedad;
		this.precio = precio;
		this.inventario = inventario;
		this.nota = nota;
		this.puntuacion = puntuacion;
	}

	public String getNota() {
		return this.nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public Integer getPuntuacion() {
		return this.puntuacion;
	}

	public void setPuntuacion(Integer puntuacion) {
		this.puntuacion = puntuacion;
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

	public String getRutaimagen() {
		return rutaimagen;
	}

	public void setRutaimagen(String rutaimagen) {
		this.rutaimagen = rutaimagen;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCosecha() {
		return cosecha;
	}

	public void setCosecha(String cosecha) {
		this.cosecha = cosecha;
	}

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public Integer getHumedad() {
		return humedad;
	}

	public void setHumedad(Integer humedad) {
		this.humedad = humedad;
	}

	public String getProceso() {
		return proceso;
	}

	public void setProceso(String proceso) {
		this.proceso = proceso;
	}

	public String getPreparacion() {
		return preparacion;
	}

	public void setPreparacion(String preparacion) {
		this.preparacion = preparacion;
	}

	public String getVariedad() {
		return variedad;
	}

	public void setVariedad(String variedad) {
		this.variedad = variedad;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getInventario() {
		return inventario;
	}

	public void setInventario(Integer inventario) {
		this.inventario = inventario;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", rutaimagen=" + rutaimagen + ", region=" + region
				+ ", cosecha=" + cosecha + ", altura=" + altura + ", humedad=" + humedad + ", proceso=" + proceso
				+ ", preparacion=" + preparacion + ", variedad=" + variedad + ", precio=" + precio + ", inventario="
				+ inventario + ", nota=" + nota + ", puntuacion=" + puntuacion + "]";
	}

}
