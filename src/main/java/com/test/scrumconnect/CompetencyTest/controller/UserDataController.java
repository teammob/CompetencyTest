package com.test.scrumconnect.CompetencyTest.controller;

import com.test.scrumconnect.CompetencyTest.dto.UserDataRequest;
import com.test.scrumconnect.CompetencyTest.dto.UserDataResponse;
import com.test.scrumconnect.CompetencyTest.model.UserData;
import com.test.scrumconnect.CompetencyTest.service.UserDataService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping(value = "/api/v1")
@Api(tags = "userData")
class UserDataController {

    @Autowired
    private UserDataService userDataservice;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "${Controller.saveUserData}")
    @ApiResponses(value = {//
            @ApiResponse(code = 500, message = "Service has a problem"), //
            @ApiResponse(code = 400, message = "Not Valid Data")})
    public ResponseEntity<UserDataResponse> saveUserData(@ApiParam("UserData") @Valid @RequestBody UserDataRequest reqData, BindingResult result) throws MethodArgumentNotValidException, NoSuchMethodException {

        if (result.hasErrors()) {
            throw new MethodArgumentNotValidException(
                    new MethodParameter(this.getClass().getDeclaredMethod("saveUserData", UserDataRequest.class, BindingResult.class), 0),
                    result);
        }
        UserData user = new UserData(reqData.getName(), reqData.getSex(), reqData.getAge(), reqData.getCountry(), new Date());
        UserDataResponse response = userDataservice.saveUserData(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
