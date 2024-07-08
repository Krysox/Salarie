package com.example.Salarie.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Salarie.model.Salarie;

@Repository
public interface SalarieRepo extends JpaRepository<Salarie, Long> {

}
