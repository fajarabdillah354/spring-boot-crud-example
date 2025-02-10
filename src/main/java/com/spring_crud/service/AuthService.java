package com.spring_crud.service;


import com.spring_crud.models.entity.ERole;
import com.spring_crud.models.entity.RoleEntity;
import com.spring_crud.models.entity.UserEntity;
import com.spring_crud.models.payload.request.SigninRequest;
import com.spring_crud.models.payload.request.SignupRequest;
import com.spring_crud.models.payload.response.BaseResponse;
import com.spring_crud.models.payload.response.SigninResponse;
import com.spring_crud.models.payload.response.SignupResponse;
import com.spring_crud.repository.RoleRepository;
import com.spring_crud.repository.UserRepository;
import com.spring_crud.security.jwt.JwtService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.Set;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;


    @Autowired
    private ModelMapper modelMapper;

    public AuthService(AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder, UserRepository userRepository, RoleRepository roleRepository) {
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


    //SIGNUP SERVICE
    public SignupResponse signup(SignupRequest signupRequest) {

        UserEntity userEntity = modelMapper.map(signupRequest, UserEntity.class);
        userEntity.setEmail(signupRequest.getEmail());
        userEntity.setUsername(signupRequest.getUsername());
        userEntity.setPassword(passwordEncoder.encode(signupRequest.getPassword()));

        Set<String> strRoles = signupRequest.getRole();
        Set<RoleEntity> roles = new HashSet<>();
        if (strRoles == null || strRoles.isEmpty()){
            RoleEntity uRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new IllegalArgumentException("Error : Role is not found"));
            roles.add(uRole);
        }else {
            strRoles.forEach(role ->{
                switch (role){
                    case "ROLE_ADMIN":
                        RoleEntity adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new IllegalArgumentException("Error : Role is not found"));
                        roles.add(adminRole);
                        break;
                    case "ROLE_USER":
                        RoleEntity userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new IllegalArgumentException("Error : Role is not found"));
                        roles.add(userRole);
                        break;
                    default:
                        throw new IllegalArgumentException("Error : Role is not found");
                }
            });
        }

        userEntity.setRoleEntities(roles);


        UserEntity saved = userRepository.save(userEntity);

        return new SignupResponse(saved);
    }



    //SIGNIN SERVICE
    public UserEntity signin(SigninRequest signinRequest){

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signinRequest.getUsername(), signinRequest.getPassword()));

        return userRepository.findByUsername(signinRequest.getUsername())
                .orElseThrow();



    }


}
