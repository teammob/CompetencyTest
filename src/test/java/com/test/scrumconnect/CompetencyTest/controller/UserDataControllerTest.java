package com.test.scrumconnect.CompetencyTest.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.scrumconnect.CompetencyTest.dto.UserDataRequest;
import com.test.scrumconnect.CompetencyTest.dto.UserDataResponse;
import com.test.scrumconnect.CompetencyTest.service.UserDataService;
import org.hamcrest.core.StringContains;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.logging.Logger;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = UserDataController.class)
public class UserDataControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UserDataService userDataService;

    @InjectMocks
    private UserDataController customerController;

    private final static Logger logger = Logger.getLogger(UserDataControllerTest.class.getName());

    @Test
    void whenValidInput_thenReturns201() throws Exception {
        UserDataRequest user = new UserDataRequest("Sema", "female", 22, "UK");

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/save")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isCreated());
    }

    @Test
    void whenValidInput_thenReturns400() throws Exception {
        UserDataRequest user = new UserDataRequest("Sema", "female", 22);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/save")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void whenValidInput_thenReturnsUserName() throws Exception {

        UserDataRequest user = new UserDataRequest("Sema", "female", 22, "UK");

        UserDataResponse userDataResponse = new UserDataResponse(user.getName());
        when(userDataService.saveUserData(any())).thenReturn(userDataResponse);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/save")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", is("Sema")))
                .andReturn();

    }

    @Test
    void whenNullValue_thenReturns400AndErrorResult() throws Exception {
        UserDataRequest user = new UserDataRequest("Sema", "female", 22);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/save")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(StringContains.containsString("Please provide country")))
                .andReturn();

    }
}
