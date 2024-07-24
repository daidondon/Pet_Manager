//package com.example.pet_manager.service.Impl;
//
//import com.example.pet_manager.dto.ProfileDTO;
//import com.example.pet_manager.entity.Customer;
//import com.example.pet_manager.entity.Role;
//import com.example.pet_manager.request.ProfileRequest;
//import com.example.pet_manager.response.AccountResponseForAdmin;
//import com.example.pet_manager.service.UserService;
//import com.example.pet_manager.entity.User;
//import com.example.pet_manager.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.security.core.authority.AuthorityUtils;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//
//@Service
//public class UserServiceImpl implements UserService {
//    @Autowired
//    UserRepository userRepository;
//
//    @Override
//    public User loginUser(String gmail, String password) {
//        Optional<User> existingUser = userRepository.findByGmail(gmail);
//        if (existingUser.isPresent()) {
//            User user = existingUser.get();
//            if (!user.getPassword().equals(password)) {
//               throw new BadCredentialsException("Wrong password");
//            }
//            return user;
//            }
//        else {
//            throw new IllegalArgumentException("User not found");
//        }
//
//        }
//    @Override
//    public ProfileDTO getUserByEmail(String gmail) {
//        Optional<User> existingUser = userRepository.findByGmail(gmail);
//        if (existingUser.isPresent()) {
//            ProfileDTO dto = new ProfileDTO();
//            dto.setAddress(existingUser.get().getAddress());
//            dto.setGmail(existingUser.get().getGmail());
//            dto.setPassword(existingUser.get().getPassword());
//            dto.setPhone_number(existingUser.get().getPhone_number());
//            dto.setFull_name(existingUser.get().getFull_name());
//            return dto;
//        }
//        else {
//            throw new IllegalArgumentException("User not found");
//        }
//
//    }
//
//    @Override
//    public int addUser(User user) {
//        try{
//            User newUser = userRepository.save(user);
//            return newUser.getId();
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//        }
//        return 0;
//    }
//    @Override
//    public User addNewUser(User user) {
//        try{
//            return userRepository.save(user);
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//        }
//        return null;
//    }
//
//    @Override
//    public Boolean isExistEmail(String email) {
//        return userRepository.existsByGmail(email);
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User userEntity = userRepository.findByGmail(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
//
//        Set<String> roles = findRolesByUsername(username);
//        List<GrantedAuthority> authorities = roles.stream()
//                .map(SimpleGrantedAuthority::new)
//                .collect(Collectors.toList());
//        return new org.springframework.security.core.userdetails.User(
//                userEntity.getGmail(),
//                userEntity.getPassword(),
//                authorities
//        );
//    }
//    @Override
//    public Boolean updateProfile(ProfileRequest request,String email) {
//        try{
//
//            Optional<User> userOptional = userRepository.findByGmail(email);
//            if(userOptional.isPresent()) {
//                userOptional.get().setPassword(request.getPassword());
//                userOptional.get().setPhone_number(request.getPhone_number());
//                userOptional.get().setFull_name(request.getFull_name());
//                userOptional.get().setAddress(request.getAddress());
//                userRepository.save(userOptional.get());
//                return true;
//            }else{
//                return false;
//            }
//
//        }catch(Exception e){
//            return false;
//        }
//    }
//
//    @Override
//    public User findUserByGmail(String gmail) {
//        try{
//
//            Optional<User> userOptional = userRepository.findByGmail(gmail);
//            return userOptional.orElseThrow(() -> new UsernameNotFoundException("User not found with gmail: " + gmail));
//
//        }catch(Exception e){
//            return null;
//        }
//    }
//
//    @Override
//    public void updateUser(User user) {
//        try{
//            userRepository.save(user);
//        }catch(Exception e){
//
//        }
//    }
//
//    @Override
//    public List<AccountResponseForAdmin> listAllAcountForAdmin() {
//        List<AccountResponseForAdmin> accounts = new ArrayList<>();
//        try{
//            List<User> list = userRepository.findAll();
//
//            for (User user : list) {
//                AccountResponseForAdmin item = new AccountResponseForAdmin();
//                item.setGmail(user.getGmail());
//                item.setAddress(user.getAddress());
//                item.setFull_name(user.getFull_name());
//                item.setPhone_number(user.getPhone_number());
//                item.setRoles(findRolesByUsername(user.getGmail()));
//                item.setStatus(user.getStatus());
//                accounts.add(item);
//            }
//        }catch(Exception e){
//            return null;
//        }
//        return accounts;
//    }
//
//    @Override
//    public Set<String> findRolesByUsername(String username) {
//        Optional<User> optionalUser = userRepository.findByGmail(username);
//        User user = optionalUser.orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
//
//        Set<String> roles = userRepository.findRolesByUsername(username);
//
//        return roles;
//    }
//
//
//}
//
//
