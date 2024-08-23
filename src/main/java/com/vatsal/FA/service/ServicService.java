package com.vatsal.FA.service;

import com.vatsal.FA.dto.ServiceDto;

import java.util.List;

public interface ServicService {

    ServiceDto createService(ServiceDto serviceDto);

    List<ServiceDto> getAllServices();
}
