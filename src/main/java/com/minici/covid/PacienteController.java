package com.minici.covid;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.minici.covid.model.ListaSintomas;
import com.minici.covid.model.Paciente;
import com.minici.covid.model.SintomaPaciente;
import com.minici.covid.repository.SintomasRepository;


@CrossOrigin
@Controller
public class PacienteController {

	@Autowired
	PacienteServiceImpl repo;
	
	@Autowired 
	SintomasRepository repos;
	
	@Autowired
	private SintomaPacienteServiceImpl repo3;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
	    
		List<Paciente> pacientes = repo.listAll();
	    
	    for (Paciente paciente : pacientes) {
			System.out.println("Paciente: "+ paciente.getNombre() + " " + paciente.getApellido());
			System.out.println("Id: "+ paciente.getId());
		}
	    
	    model.addAttribute("pacientes", pacientes);
	     
	    return "index";
	}
	
	@GetMapping(value = "/sintomas")
	public ResponseEntity<List<ListaSintomas>> getSintomas() {
		
		List<ListaSintomas> sintomas = repos.findAll();
		
	/*	for (Sintomas sintoma : sintomas) {
			System.out.println("Sintoma: "+ sintoma.getSintoma());
			System.out.println("Id: "+ sintoma.getId());
		}*/
		
		ResponseEntity<List<ListaSintomas>> response;
		
		if(sintomas.size() != 0 ){
			response = new ResponseEntity<List<ListaSintomas>>(sintomas,HttpStatus.OK);
		} else {
			response = new ResponseEntity<List<ListaSintomas>>(sintomas,HttpStatus.BAD_REQUEST);
		}
		return response;
		
	}
	
	@RequestMapping("/new_paciente")
	public String showNewPacientePage(Model model) {
	    Paciente paciente = new Paciente();
	    
	    ArrayList<ListaSintomas> sintomas = (ArrayList<ListaSintomas>) repos.findAll();
	    paciente.setSintomas(sintomas);
	    
	/*    for (Sintomas sintoma : paciente.getSintomas()) {
			System.out.println("Sintoma: "+ sintoma.getSintoma());
		}*/
	    
	    model.addAttribute("paciente", paciente);
	     
	    return "new_paciente";
	}
	
   /* @GetMapping(value = "/new")
	public String getPacientes() {		
	
		return "paciente";
		
	}*/
    
/*    @RequestMapping("/post")
    public void agregarPaciente(@ModelAttribute ("paciente") Paciente paciente ) {
        System.out.println("Nombre: " + paciente.getNombre() + " " + paciente.getApellido());
        System.out.println("Edad: " + paciente.getEdad());
        int numero = 1;
        for (String sintoma : paciente.sintomas) {
			System.out.println("Sintoma "+ numero + ": " +sintoma);
			numero ++;
		}
        System.out.println("Genero: "+ paciente.getGenero());
        //System.out.println("DNI: "+ paciente.getDni());
    }*/
    
    @PostMapping (value = "/guardoPaciente")
	public ResponseEntity<Paciente> guardar(@RequestBody Paciente paciente){
		
    	System.out.println("Nombre: " + paciente.getNombre() + " " + paciente.getApellido());
    	
    	System.out.println("Edad: " + paciente.getEdad());
    	
    	System.out.println("Genero: "+ paciente.getGenero());
        
    	if( !repo.save(paciente)) 
    		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);;
		
    	if(!grabarSintomas(paciente.getSintomas(), paciente.getId()))
    		System.out.println("No se pudo grabar, lista de sintomas es: "+ paciente.getSintomas().size());
    	
		return new ResponseEntity<Paciente>(paciente ,HttpStatus.OK);
		
	}

	private Boolean grabarSintomas(ArrayList<ListaSintomas> sintomas, Long idPaciente) {
		
		for (ListaSintomas sintoma : sintomas) {
			System.out.println("Sintoma "+ sintoma.getId() + ": " +sintoma.getSintoma());
			SintomaPaciente st = new SintomaPaciente();
			st.setIdsintoma(sintoma.getId());
			st.setIdpaciente(idPaciente);
			
			if(!repo3.saveSintomas(st))
				return false;
		}
		return true;
	}
    
    @PostMapping("/crearPaciente")
    public String agregoPaciente(Model modelo, Paciente paciente) {
        
    	System.out.println("Nombre: " + paciente.getNombre() + " " + paciente.getApellido());
    	
    	System.out.println("Edad: " + paciente.getEdad());
    	
    	System.out.println("Genero: "+ paciente.getGenero());
        
    	repo.save(paciente);
    	
    	grabarSintomas(paciente.getSintomas(), paciente.getId());
        
        return "index";
    }
    
    @PostMapping("/agregarSintoma")
    public String agregarSintoma(Model modelo, ListaSintomas sintoma) {
        
    	System.out.println("Sintoma: "+ sintoma.getSintoma());
		
    	//System.out.println("Paciente: "+ sintoma.getPaciente());
        
    	repos.save(sintoma);
    	
        return "index";
    }
}
