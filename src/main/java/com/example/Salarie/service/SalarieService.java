package com.example.Salarie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Salarie.Repo.SalarieRepo;
import com.example.Salarie.model.Salarie;

@Service
public class SalarieService {
	
	@Autowired
	private SalarieRepo repo;
	
	
	public List<Salarie> findAll()
	{
		return repo.findAll();
	}
	
	public Salarie createSalarie(Salarie salarie)
	{
		return repo.save(salarie);
	}
	
	public Salarie getOne(Long id)
	{
		Salarie salarie = null;
		Optional<Salarie> salarieOpt = repo.findById(id);
		if (salarieOpt.isPresent())
		{
			salarie = salarieOpt.get();
		}
		return salarie;
	}
	
	public Salarie updateSalarie(Long id, Salarie newData)
	{
		Salarie salarie = getOne(id);
		if (salarie == null)
		{
			return null;
		}
		salarie.setPrenom(newData.getPrenom());
		salarie.setAdresse(newData.getAdresse());
		salarie.setSexe(newData.getSexe());
		salarie.setSalaire(newData.getSalaire());
		
		return repo.save(salarie);
		
	}
	
	public void deleteSalarie(Long id)
	{
		repo.deleteById(id);
	}

	
}
