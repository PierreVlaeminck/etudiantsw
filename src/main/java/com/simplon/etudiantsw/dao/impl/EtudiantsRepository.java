package com.simplon.etudiantsw.dao.impl;

import com.simplon.etudiantsw.entity.Etudiants;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantsRepository extends JpaRepository<Etudiants, Long> {
}
