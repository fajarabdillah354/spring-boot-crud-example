package com.spring_crud.controller;


import com.spring_crud.models.entity.UserEntity;
import com.spring_crud.models.payload.request.SigninRequest;
import com.spring_crud.models.payload.request.SignupRequest;
import com.spring_crud.models.payload.response.BaseResponse;
import com.spring_crud.models.payload.response.SigninResponse;
import com.spring_crud.models.payload.response.SignupResponse;

import com.spring_crud.repository.UserRepository;
import com.spring_crud.security.jwt.JwtService;
import com.spring_crud.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;

@RestController
@RequestMapping("/api/auth")
public class AuthController {


    @Autowired
    private UserRepository userRepository;


    @Autowired
    private AuthService authService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("/register")
    public ResponseEntity<BaseResponse<SignupResponse>> register(@Valid @RequestBody SignupRequest signupRequest){

        if (userRepository.existsByUsername(signupRequest.getUsername())){
            return new ResponseEntity<>(new BaseResponse<>("username is taken!"), HttpStatus.BAD_REQUEST);
        }

        if (userRepository.existsByEmail(signupRequest.getEmail())){
            return new ResponseEntity<>(new BaseResponse<>("email is taken!"), HttpStatus.BAD_REQUEST);
        }

        SignupResponse signupResponse = authService.signup(signupRequest);

        BaseResponse<SignupResponse> response = new BaseResponse<>();
        response.setSuccess(true);
        response.setMessage("User registered successfully");
        response.setTimeStamps(LocalDateTime.now());
        response.setData(signupResponse);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }


    @PostMapping("/login")
    public ResponseEntity<SigninResponse> login(@Valid @RequestBody SigninRequest signinRequest){

        UserEntity user = authService.signin(signinRequest);

        String jwtToken = jwtService.generateToken(user);

        SigninResponse signinResponse = new SigninResponse();
        signinResponse.setToken(jwtToken);
        signinResponse.setExpiredIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(signinResponse);
    }



    //Handler Method Error
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handlerErrors(MethodArgumentNotValidException e){
        var errors = new HashMap<String, String>();
        e.getBindingResult().getAllErrors()
                .forEach(objectError -> {

                    String fieldError = ((FieldError) objectError).getField();
                    String messageError = objectError.getDefaultMessage();

                    errors.put(fieldError, messageError);

                });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }




}
