package com.example.pet_manager.service.Impl;

import com.example.pet_manager.entity.*;
import com.example.pet_manager.exception.APIException;
import com.example.pet_manager.repository.*;
import com.example.pet_manager.request.*;
import com.example.pet_manager.response.EntityCustomResponse;
import com.example.pet_manager.service.HostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

@Service
public class HostServiceImpl implements HostService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DoctorRepository doctorRepository;

    @Transactional
    @Override
    public EntityCustomResponse addDoctorUser(UserRequest userRequest) {
        User user = new User();
        user.setFullName(userRequest.getFullName());
        user.setGmail(userRequest.getFullName());
        user.setPassword(userRequest.getPassword());
        user.setAddress(userRequest.getAddress());
        user.setPhoneNumber(userRequest.getPhoneNumber());
        user.setStatus(userRequest.getStatus());

        User userDb =userRepository.save(user);
        if (ObjectUtils.isEmpty(userDb)) {
            //TODO : exception handler
        }

        Doctor doctor = new Doctor();
        doctor.setRoleId(userRequest.getDoctorRequest().getRoleId());
        doctor.setClinicId(userRequest.getDoctorRequest().getClinicId());
        doctor.setLinkMeet(userRequest.getDoctorRequest().getLinkMeet());
        doctor.setUser(userDb);
        Doctor doctorDB = doctorRepository.save(doctor);
        if (ObjectUtils.isEmpty(doctorDB)){
            throw new APIException(HttpStatus.INTERNAL_SERVER_ERROR, "add doctor account thất bại");
        }

        return new EntityCustomResponse(1, "Add Doctor account Success", 200, userDb);
    }
}
