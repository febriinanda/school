package com.nanda.school.service;

import com.nanda.school.entity.User;
import com.nanda.school.model.UserRegistrationRequest;
import com.nanda.school.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ValidationService validationService;

    @Transactional
    public void register(UserRegistrationRequest request){
        validationService.validate(request);
        if(userRepository.existsById(request.getUsername()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already registered");

        User user = new User(request);
        userRepository.save(user);
    }
}
