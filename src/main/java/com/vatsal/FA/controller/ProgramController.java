package com.vatsal.FA.controller;

import com.vatsal.FA.dto.ProgramDto;
import com.vatsal.FA.dto.ServiceDto;
import com.vatsal.FA.service.ProgramService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/programs")
public class ProgramController {

    private ProgramService programService;

    @PostMapping
    public ResponseEntity<ProgramDto> createProgram(@RequestBody ProgramDto programDto){
        ProgramDto savedProgram = programService.createProgram(programDto);
        return new ResponseEntity<>(savedProgram, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProgramDto>> getAllPrograms(){
        List<ProgramDto> programDtos = programService.getAllPrograms();
        return ResponseEntity.ok(programDtos);
    }
}
