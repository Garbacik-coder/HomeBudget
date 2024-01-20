package com.arjuncodes.studentsystem.service;

import com.arjuncodes.studentsystem.model.Wydatek;

import java.util.List;

public interface WydatekService {
    public Wydatek saveStudent(Wydatek wydatek);
    public List<Wydatek> getAllStudents();
}
