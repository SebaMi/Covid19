package com.minici.covid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minici.covid.model.ListaSintomas;

@Repository
public interface SintomasRepository extends JpaRepository <ListaSintomas, Long> {

}
