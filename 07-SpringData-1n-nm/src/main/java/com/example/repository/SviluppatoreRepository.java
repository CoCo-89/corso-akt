package com.example.repository;

import com.example.entity.Sviluppatore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SviluppatoreRepository extends JpaRepository<Sviluppatore, Long> {
	//Anche qui non ci dilunghiamo con metodi accessori
}