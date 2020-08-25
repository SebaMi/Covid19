package com.minici.covid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minici.covid.model.SintomaPaciente;

@Repository
public interface SintomaPacienteRepository  extends	JpaRepository <SintomaPaciente, Long>{

}
