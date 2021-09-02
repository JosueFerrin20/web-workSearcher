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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="trabajador")
public class Trabajador extends Persona implements Serializable{
	
	private static final long serialVersionUID=1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Basic(optional= false)
	@Column(name="idTrabajador")
	private Integer idTrabajador;
	
	@Column (name="gradoAcademico")
	private String gradoAcademico;
	@Column (name="titulo")
	private String titulo;
	@Column (name="tipo")
	private String tipo;
	
	@OneToMany(mappedBy="trabajador", fetch= FetchType.LAZY)
	private List<Experiencia> experiencias;
	
	@OneToMany(mappedBy="trabajador", fetch= FetchType.LAZY)
	private List<Curso> cursos;
	
	@OneToMany(mappedBy="trabajador", fetch= FetchType.LAZY)
	private List<Idioma> idiomas;
	
	public Trabajador() {
		super();
	}
	
	public Trabajador(Integer id) {
		super();
		this.idTrabajador=id;
	}
	
	public List<Experiencia> getExperiencias() {
		return experiencias;
	}

	public void setExperiencias(List<Experiencia> experiencias) {
		this.experiencias = experiencias;
	}
	
	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public List<Idioma> getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(List<Idioma> idiomas) {
		this.idiomas = idiomas;
	}

	public Integer getIdTrabajador() {
		return idTrabajador;
	}

	public void setIdTrabajador(Integer idTrabajador) {
		this.idTrabajador = idTrabajador;
	}

	public String getGradoAcademico() {
		return gradoAcademico;
	}

	public void setGradoAcademico(String gradoAcademico) {
		this.gradoAcademico = gradoAcademico;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
