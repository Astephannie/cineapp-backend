package com.mitocode.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "comida")
public class Comida {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idComida;
	
	@Column(name= "nombre", nullable = false, length = 80)
	private String nombre;
	
	@Column(name= "precio", length = 2, columnDefinition = "decimal(5,2)")
	private Double precio;
	
	@JsonIgnore
	@Column(name= "foto", updatable = false)
	private byte[] foto;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "comida_venta", joinColumns = @JoinColumn(name = "id_comida", referencedColumnName = "idComida"), inverseJoinColumns = @JoinColumn(name = "id_venta", referencedColumnName = "idVenta"))
	private List<Venta> ventas;
	
	public Integer getIdComida() {
		return idComida;
	}
	public void setIdComida(Integer idComida) {
		this.idComida = idComida;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
}