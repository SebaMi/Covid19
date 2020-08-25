	package com.minici.covid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minici.covid.interfaces.PacienteService;
import com.minici.covid.model.Paciente;
import com.minici.covid.repository.PacienteRepository;

@Service
public class PacienteServiceImpl implements PacienteService {
	
	@Autowired
	private PacienteRepository repo;

	public Boolean save(Paciente paciente) {
		
		try {
			repo.save(paciente);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	public List<Paciente> listAll() {
        return repo.findAll();
    }

}
