package com.test.scrumconnect.CompetencyTest.service;

import com.test.scrumconnect.CompetencyTest.dto.UserDataResponse;
import com.test.scrumconnect.CompetencyTest.model.UserData;
import com.test.scrumconnect.CompetencyTest.repository.UserDataRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class UserDataServiceImplTest {
    @Mock
    private UserDataRepository repository;

    @InjectMocks
    private UserDataServiceImpl serviceTest;


    @Test
    void whenValidInput_thenReturns201() throws Exception {
        UserData user = new UserData("Yucel", "Male", 22, "UK", new Date());
        when(repository.save(user)).thenReturn(user);
        UserDataResponse userResponse = serviceTest.saveUserData(user);
        assertEquals("Yucel", userResponse.getName());
        verify(repository, times(1)).save(user);
    }
}
