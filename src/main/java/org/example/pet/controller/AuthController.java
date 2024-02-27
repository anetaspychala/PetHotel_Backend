package org.example.pet.controller;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.pet.dto.UserDto;
import org.example.pet.entity.*;
import org.example.pet.exceptions.UserExistingWithEmail;
import org.example.pet.exceptions.UserExistingWithName;
import org.example.pet.model.User;
import org.example.pet.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> addUser(@Valid @RequestBody UserDto userDto){
        try{
        userService.register(userDto);
    return ResponseEntity.ok(new AuthResponse(Code.SUCCESS));}
        catch (UserExistingWithName e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new AuthResponse(Code.A4));
        }
        catch (UserExistingWithEmail e2){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new AuthResponse(Code.A5));
        }}
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user, HttpServletResponse response){
       return userService.login(response, user);}

    @GetMapping("/validate")
    public ResponseEntity<AuthResponse> validateToken(HttpServletRequest request, HttpServletResponse response){
        try{
        userService.validateToken(request, response);
        return ResponseEntity.ok(new AuthResponse(Code.PERMIT));}
        catch (IllegalArgumentException | ExpiredJwtException e){
            return ResponseEntity.status(401).body(new AuthResponse(Code.A3));
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ValidationMessage handleValidationException(
            MethodArgumentNotValidException ex
    ){
        return new ValidationMessage(ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }

}


