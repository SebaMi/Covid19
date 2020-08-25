package com.minici.covid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minici.covid.interfaces.SintomaPacienteService;
import com.minici.covid.model.SintomaPaciente;
import com.minici.covid.repository.SintomaPacienteRepository;

@Service
public class SintomaPacienteServiceImpl implements SintomaPacienteService{
	
	@Autowired
	private SintomaPacienteRepository repo3;

	public Boolean saveSintomas(SintomaPaciente sintoma) {
		try {
		
			repo3.save(sintoma);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
