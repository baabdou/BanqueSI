package com.banque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banque.entities.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Long> {

}
