package com.test.scrumconnect.CompetencyTest.service;

import com.test.scrumconnect.CompetencyTest.dto.UserDataResponse;
import com.test.scrumconnect.CompetencyTest.model.UserData;
import com.test.scrumconnect.CompetencyTest.repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDataServiceImpl implements UserDataService{

    @Autowired
    private UserDataRepository repository;

    @Override
    public UserDataResponse saveUserData(UserData user) {
        UserData returnUser =repository.save(user);
        return UserDataResponse.builder().name(returnUser.getName()).build();

    }
}
