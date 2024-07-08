package com.example.Salarie.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.Salarie.Repo.SalarieRepo;
import com.example.Salarie.model.Salarie;

public class SalarieServiceTest {
	
	@InjectMocks
	SalarieService service;
	
	@Mock
	SalarieRepo repo;
	
	@BeforeEach
	public void setup() {
	    MockitoAnnotations.openMocks(this);
	}
	
	
	@Test
	void findAllTest()
	{
		service.findAll();
		verify(repo, times(1)).findAll();
	}
	
	@Test
	void deleteSalarie()
	{
		Long id = 1L;
		service.deleteSalarie(id);
		verify(repo, times(1)).deleteById(id);
	}
	
//	@Test
//	void updateSalarieTest()
//	{
//		Long id = 1L;
//		Salarie salarie = new Salarie();
//		salarie.setAdresse("La Defense");
//		salarie.setPrenom("Ken");
//		salarie.setSexe("M");
//		
//		when(repo.findById(id)).thenReturn(Optional.of(salarie));
//		when(repo.save(salarie)).thenReturn((updatedSalarie));
//		
//		Salarie updatedSalarie = service.updateSalarie(id, salarie);
//		
//		
//		
//		assertEquals(updatedSalarie.getAdresse(), salarie.getAdresse());
//		assertEquals(updatedSalarie.getPrenom(), salarie.getPrenom());
//		
//	}

}
