package com.example.pet_manager.service.Impl;

import com.example.pet_manager.entity.Host;
import com.example.pet_manager.repository.CustomerRepository;
import com.example.pet_manager.repository.HostRepository;
import com.example.pet_manager.service.HostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HostServiceImpl implements HostService {
    @Autowired
    HostRepository hostRepository;
    @Override
    public Host addHost(Host host) {
        try{
            return  hostRepository.save(host);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
