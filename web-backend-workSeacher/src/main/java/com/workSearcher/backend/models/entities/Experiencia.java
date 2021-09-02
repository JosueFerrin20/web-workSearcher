package com.workSearcher.backend.models.entities;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="experiencia")
public class Experiencia implements Serializable{
	
	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Basic(optional= false)
	@Column(name="idExperiencia")
	private Integer idExperiencia;
	
	@Column (name="fechaIngreso")
	private Calendar fechaIngreso;
	@Column (name="fechaSalida")
	private Calendar fechaSalida;
	@Column (name="empresaAnterior")
	private String empresaAnterior;
	@Column (name="motivoSalidaTrabajoAnterior")
	private String motivoSalidaTrabajoAnterior;
	@Column (name="puestoDesempeñado")
	private String puestoDesempeñado;

	@JoinColumn(name="fk_trabajador", referencedColumnName="idTrabajador")
	@ManyToOne
	private Trabajador trabajador;
	
	@OneToOne(mappedBy="experiencia")
	private Empresa empresa;
	
	public Trabajador getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}
	
	public Experiencia() {
		super();
	}
	
	public Experiencia(int id) {
		super();
		this.idExperiencia=id;
	}

	public Integer getIdExperiencia() {
		return idExperiencia;
	}

	public void setIdExperiencia(Integer idExperiencia) {
		this.idExperiencia = idExperiencia;
	}

	public Calendar getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Calendar fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Calendar getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Calendar fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getEmpresaAnterior() {
		return empresaAnterior;
	}

	public void setEmpresaAnterior(String empresaAnterior) {
		this.empresaAnterior = empresaAnterior;
	}

	public String getMotivoSalidaTrabajoAnterior() {
		return motivoSalidaTrabajoAnterior;
	}

	public void setMotivoSalidaTrabajoAnterior(String motivoSalidaTrabajoAnterior) {
		this.motivoSalidaTrabajoAnterior = motivoSalidaTrabajoAnterior;
	}

	public String getPuestoDesempeñado() {
		return puestoDesempeñado;
	}

	public void setPuestoDesempeñado(String puestoDesempeñado) {
		this.puestoDesempeñado = puestoDesempeñado;
	}
}
