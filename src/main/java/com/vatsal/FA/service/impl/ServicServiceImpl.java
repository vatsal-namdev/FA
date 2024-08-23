package com.vatsal.FA.service.impl;

import com.vatsal.FA.dto.ServiceDto;
import com.vatsal.FA.entity.Service;
import com.vatsal.FA.mapper.ServiceMapper;
import com.vatsal.FA.repository.ServiceRepository;
import com.vatsal.FA.service.ServicService;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class ServicServiceImpl implements ServicService {

    private ServiceRepository serviceRepository;

    @Override
    public ServiceDto createService(ServiceDto serviceDto) {
        Service service = ServiceMapper.mapToService(serviceDto);
        Service savedService = serviceRepository.save(service);
        return ServiceMapper.mapToServiceDto(savedService);
    }

    @Override
    public List<ServiceDto> getAllServices() {
        List<Service> allServices = serviceRepository.findAll();
        return allServices.stream().map(serv -> ServiceMapper.mapToServiceDto(serv)).collect(Collectors.toList());
    }
}
