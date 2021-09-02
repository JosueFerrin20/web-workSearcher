package com.workSearcher.backend.models.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AspiranteKey implements Serializable{
	
	private static final long serialVersionUID=1L;
	
	@Column (name="idOfertaEmpleo")
	private Integer idOfertaEmpleo;
	@Column (name="idTrabajador")
	private Integer idTrabajador;
	
	public AspiranteKey(Integer idOfertaEmpleo, Integer idTrabajador) {
		super();
		this.idOfertaEmpleo = idOfertaEmpleo;
		this.idTrabajador = idTrabajador;
	}
	
	public Integer getIdOfertaEmpleo() {
		return idOfertaEmpleo;
	}

	public void setIdOfertaEmpleo(Integer idOfertaEmpleo) {
		this.idOfertaEmpleo = idOfertaEmpleo;
	}

	public Integer getIdTrabajador() {
		return idTrabajador;
	}

	public void setIdTrabajador(Integer idTrabajador) {
		this.idTrabajador = idTrabajador;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idOfertaEmpleo, idTrabajador);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AspiranteKey other = (AspiranteKey) obj;
		return Objects.equals(idOfertaEmpleo, other.idOfertaEmpleo) && Objects.equals(idTrabajador, other.idTrabajador);
	}

}
