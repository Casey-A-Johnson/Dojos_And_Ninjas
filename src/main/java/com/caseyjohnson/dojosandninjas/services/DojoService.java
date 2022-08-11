package com.caseyjohnson.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caseyjohnson.dojosandninjas.models.Dojo;
import com.caseyjohnson.dojosandninjas.models.Ninja;
import com.caseyjohnson.dojosandninjas.repo.DojoRepo;
import com.caseyjohnson.dojosandninjas.repo.NinjaRepo;

@Service
public class DojoService {
	
	@Autowired
	private DojoRepo dojoRepo;
	
	@Autowired
	private NinjaRepo ninjaRepo;
	
	//----Get all Ninjas------
	public List<Ninja> allNinjas(){
		return ninjaRepo.findAll();
	}
	
	//----Get all Dojos-------
	public List<Dojo> allDojos(){
		return dojoRepo.findAll();
	}
	
	//----Create a Ninja-------
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
	//----Create a Dojo---------
	public Dojo createDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
	//----Find one Dojo----------
	public Dojo oneDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		}else {
			return null;
		}
	}
	
	
}
