package com.example.pet_manager.service.Impl;

import com.example.pet_manager.entity.Customer;
import com.example.pet_manager.repository.CustomerRepository;
import com.example.pet_manager.repository.UserRepository;
import com.example.pet_manager.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public void addCustomer(int idUser) {
        try{
            customerRepository.addCustomer(idUser);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
