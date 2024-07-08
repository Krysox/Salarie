package com.example.Salarie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Salarie.model.Salarie;
import com.example.Salarie.service.SalarieService;

@RestController
public class SalarieController {
	
	@Autowired
	private SalarieService service;
	
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Salarie>> getAllSalarie()
	{
		try {
			
			List<Salarie> salaries = service.findAll();
			return new ResponseEntity<>(salaries, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/addSalarie")
	public ResponseEntity<Salarie> addSalarie(@RequestBody Salarie salarie)
	{
			Salarie createdSalarie = service.createSalarie(salarie);
			
			return new ResponseEntity<>(createdSalarie, HttpStatus.OK);
	}
	
	@PutMapping("/updateSalarie/{id}")
	public ResponseEntity<Salarie> updateSalarie(@RequestBody Salarie salarie, @PathVariable Long id)
	{
			Salarie updatedSalarie = service.updateSalarie(id, salarie);
			if (updatedSalarie == null)
			{
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<>(updatedSalarie, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteSalarie/{id}")
	public ResponseEntity<Salarie> deleteSalarie(@PathVariable Long id)
	{
			service.deleteSalarie(id);
			
			return new ResponseEntity<>(HttpStatus.OK);
	}

}
