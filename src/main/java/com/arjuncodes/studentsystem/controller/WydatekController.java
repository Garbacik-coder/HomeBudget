package com.arjuncodes.studentsystem.controller;

import com.arjuncodes.studentsystem.model.Wydatek;
import com.arjuncodes.studentsystem.service.WydatekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class WydatekController {
    @Autowired
    private WydatekService wydatekService;

    @PostMapping("/add")
    public String add(@RequestBody Wydatek wydatek){
        wydatekService.saveStudent(wydatek);
        return "New student is added";
    }

    @GetMapping("/getAll")
    public List<Wydatek> list(){
        return wydatekService.getAllStudents();
    }
}
