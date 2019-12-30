package com.banque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banque.entities.Groupe;

public interface GroupeRepository extends JpaRepository<Groupe, Long> {

}
