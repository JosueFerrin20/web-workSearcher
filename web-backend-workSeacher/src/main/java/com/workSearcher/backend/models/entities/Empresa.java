package com.workSearcher.backend.models.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="empresa")
public class Empresa implements Serializable{
	
	private static final long serialVersionUID=1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Basic(optional= false)
	@Column(name="idEmpresa")
	private Integer idEmpresa;
	
	@Column (name="nombre")
	private String nombre;
	@Column (name="descripcion")
	private String descripcion;
	@Column (name="telefono")
	private String telefono;
	
	@OneToMany(mappedBy="empresa", fetch= FetchType.LAZY)
	private List<ofertaEmpleo> ofertaEmpleos;
	

	@JoinColumn(name="fk_experiencia", nullable=false)
	@OneToOne
	private Experiencia experiencia;
	
	public Empresa() {
		super();
	}
	
	public Empresa(Integer id) {
		super();
		this.idEmpresa=id;
	}
	
	public List<ofertaEmpleo> getOfertaEmpleos() {
		return ofertaEmpleos;
	}

	public void setOfertaEmpleos(List<ofertaEmpleo> ofertaEmpleos) {
		this.ofertaEmpleos = ofertaEmpleos;
	}

	public Integer getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Experiencia getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(Experiencia experiencia) {
		this.experiencia = experiencia;
	}

}
