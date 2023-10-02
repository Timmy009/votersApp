package com.voterapp.votersapp.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
@Slf4j
public class UserController {

    private final UserService userService;

    @PutMapping
    public ResponseEntity<UserRegistrationResponse> register(@RequestBody UserRegistrationRequest registerUserRequest){
        log.info("hello");
        try {
            UserRegistrationResponse response = userService.register(registerUserRequest);
            log.info("response:: {}", response);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception exception) {
            exception.printStackTrace();
            UserRegistrationResponse response = new UserRegistrationResponse();
            response.setMessage(exception.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }


    @GetMapping
    public String register(){
        return "demo";
    }


}
