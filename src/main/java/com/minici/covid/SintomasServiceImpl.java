package com.minici.covid;

import org.springframework.beans.factory.annotation.Autowired;

import com.minici.covid.interfaces.SintomasService;
import com.minici.covid.model.ListaSintomas;
import com.minici.covid.repository.SintomasRepository;

public class SintomasServiceImpl implements SintomasService {
	
	@Autowired
	private SintomasRepository repos;

	public Boolean saveSintomas(ListaSintomas sintoma) {
		try {
		
			repos.save(sintoma);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
}
