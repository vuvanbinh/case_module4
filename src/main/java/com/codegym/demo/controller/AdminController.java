package com.codegym.demo.controller;

import com.codegym.demo.dto.request.SignInForm;
import com.codegym.demo.dto.request.SignUpForm;
import com.codegym.demo.dto.response.JwtResponse;
import com.codegym.demo.dto.response.ResponseMessage;
import com.codegym.demo.model.Classes;
import com.codegym.demo.model.Role;
import com.codegym.demo.model.Users;
import com.codegym.demo.model.RoleName;
import com.codegym.demo.security.jwt.JwtProvider;
import com.codegym.demo.security.userPrinciple.UserPrinciple;
import com.codegym.demo.service.classes.IClassesService;
import com.codegym.demo.service.role.IRoleService;
import com.codegym.demo.service.users.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class AdminController {

    @Autowired
    IUsersService usersService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    IRoleService roleService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    IClassesService classesService;

    @PostMapping("/signin")
    public ResponseEntity<?> login(@RequestBody SignInForm signInForm) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInForm.getEmail(), signInForm.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.createToken(authentication);
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        return ResponseEntity.ok(new JwtResponse(token,userPrinciple.getId(),userPrinciple.getFullName()
                , userPrinciple.getAvatar(), userPrinciple.getAuthorities()));

    }

    @PostMapping("/signup")
    public ResponseEntity<?> register(@Valid @RequestBody SignUpForm signUpForm) {
        if (usersService.existsByEmail(signUpForm.getEmail())) {
            return new ResponseEntity<>(new ResponseMessage("Email is existed!"), HttpStatus.OK);
        }
        Users users = new Users();
        users.setFullName(signUpForm.getFullName());
        users.setEmail(signUpForm.getEmail());
        users.setPhoneNumber(signUpForm.getPhoneNumber());
        users.setAddress(signUpForm.getAddress());
        users.setDob(signUpForm.getDob());
        users.setStatus(signUpForm.getStatus());
        users.setPassword(passwordEncoder.encode(signUpForm.getPassword()));
        Classes classes = null;
        if (signUpForm.getClassesId() == null) {
            users.setClasses(null);
        } else classes = classesService.findById(signUpForm.getClassesId()).get();
        users.setClasses(classes);
        users.setAvatar(signUpForm.getAvatar());
        Set<String> strRole = signUpForm.getRoles();
        Set<Role> roles = new HashSet<>();
        strRole.forEach(role -> {
            switch (role) {
                case "admin":
                    Role adminRole = roleService.findByName(RoleName.ADMIN).orElseThrow(() -> new RuntimeException("Role not found"));
                    roles.add(adminRole);
                    break;
                case "student":
                    Role studentRole = roleService.findByName(RoleName.STUDENT).orElseThrow(() -> new RuntimeException("Role not found"));
                    roles.add(studentRole);
                    break;
                case "ministry":
                    Role ministryRole = roleService.findByName(RoleName.MINISTRY).orElseThrow(() -> new RuntimeException("Role not found"));
                    roles.add(ministryRole);
                    break;

                default:
                    Role coachRole = roleService.findByName(RoleName.COACH).orElseThrow(() -> new RuntimeException("Role not found"));
                    roles.add(coachRole);
                    break;
            }
        });
        users.setRoles(roles);
        usersService.save(users);
        return new ResponseEntity<>(new ResponseMessage("Create success!"), HttpStatus.OK);
    }


    //Lấy ra danh sách tất cả học sinh trong trung tâm
    @GetMapping("/findAllStudent")
    public ResponseEntity<List<Users>> findAllStudent(){
        return new ResponseEntity<>(usersService.finAllByRoleName("STUDENT"),HttpStatus.OK);
    }

    //Lấy ra danh sách tất cả học sinh trong một lớp
     @GetMapping("/findAllStudentByClassesId/{id}")
    public ResponseEntity<List<Users>> findAllStudentByClassesId(@PathVariable Long id){
        return new ResponseEntity<>(usersService.finAllByClassesId(id),HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Optional<Users>>detailUser(@PathVariable("id") Optional<Users> users){
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @GetMapping("/findAllStudentByStatus/{status}")
    public ResponseEntity<Iterable<Users>> findAllStudentByStatus(@PathVariable String status){
        return new ResponseEntity<>(usersService.findAllByStatus(status),HttpStatus.OK);
    }

}
