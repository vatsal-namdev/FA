package com.vatsal.FA.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {

    private Long id;
    private String name;
    private List<ServiceDto> services;
    private List<ProgramDto> programs;
}
