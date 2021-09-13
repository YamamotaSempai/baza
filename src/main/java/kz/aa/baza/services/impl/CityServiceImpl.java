package kz.aa.baza.services.impl;

import kz.aa.baza.services.CityService;
import kz.as.registry.City;
import kz.as.registry.CityServiceGrpc;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {
    private final ModelMapper modelMapper;
    private final CityServiceGrpc.CityServiceBlockingStub cityServiceStub;

    @Autowired
    public CityServiceImpl(ModelMapper modelMapper,
                           CityServiceGrpc.CityServiceBlockingStub cityServiceStub) {
        this.modelMapper = modelMapper;
        this.cityServiceStub = cityServiceStub;
    }

    @Override
    public City getById(@NonNull Long id) {
        City.CityResponse response = cityServiceStub.get(City.CityRequest.newBuilder().setId(id).build());
        return modelMapper.map(response, City.class);
    }
}
