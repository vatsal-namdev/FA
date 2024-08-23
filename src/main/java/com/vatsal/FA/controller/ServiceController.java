package com.vatsal.FA.controller;

import com.vatsal.FA.dto.ServiceDto;
import com.vatsal.FA.service.ServicService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/services")
public class ServiceController {

    private ServicService servicService;

    @PostMapping
    public ResponseEntity<ServiceDto> createService(@RequestBody ServiceDto serviceDto){
            ServiceDto savedService =servicService.createService(serviceDto);
            return new ResponseEntity<>(savedService, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ServiceDto>> getAllServices(){
        List<ServiceDto> serviceDtos = servicService.getAllServices();
        return ResponseEntity.ok(serviceDtos);
    }
}
