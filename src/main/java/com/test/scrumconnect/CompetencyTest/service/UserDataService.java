package com.test.scrumconnect.CompetencyTest.service;

import com.test.scrumconnect.CompetencyTest.dto.UserDataResponse;
import com.test.scrumconnect.CompetencyTest.model.UserData;


public interface UserDataService {

    UserDataResponse saveUserData(UserData user);

}
