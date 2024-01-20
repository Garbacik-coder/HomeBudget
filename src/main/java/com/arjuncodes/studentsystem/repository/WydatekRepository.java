package com.arjuncodes.studentsystem.repository;

import com.arjuncodes.studentsystem.model.Wydatek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WydatekRepository extends JpaRepository<Wydatek,Integer> {
}
