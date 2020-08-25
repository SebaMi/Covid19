package com.minici.covid.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SintomaPaciente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idpaciente_sintoma")
	private Long id;
	
	private Long idpaciente;
	
	private Long idsintoma;

	public Long getIdpaciente() {
		return idpaciente;
	}

	public void setIdpaciente(Long idpaciente) {
		this.idpaciente = idpaciente;
	}

	public Long getIdsintoma() {
		return idsintoma;
	}

	public void setIdsintoma(Long idsintoma) {
		this.idsintoma = idsintoma;
	}
			
}
