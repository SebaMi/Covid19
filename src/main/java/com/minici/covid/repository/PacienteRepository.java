package com.minici.covid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minici.covid.model.Paciente;

@Repository
public interface PacienteRepository extends	JpaRepository <Paciente, Long>{

	

}