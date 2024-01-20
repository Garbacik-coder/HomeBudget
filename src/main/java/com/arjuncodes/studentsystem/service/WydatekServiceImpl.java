package com.arjuncodes.studentsystem.service;

import com.arjuncodes.studentsystem.model.Wydatek;
import com.arjuncodes.studentsystem.repository.WydatekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WydatekServiceImpl implements WydatekService {

    @Autowired
    private WydatekRepository wydatekRepository;

    @Override
    public Wydatek saveStudent(Wydatek wydatek) {
        return wydatekRepository.save(wydatek);
    }

    @Override
    public List<Wydatek> getAllStudents() {
        return wydatekRepository.findAll();
    }
}
