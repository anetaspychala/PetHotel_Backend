package org.example.pet.controller;

import lombok.RequiredArgsConstructor;
import org.example.pet.dto.UserDto;
import org.example.pet.service.UserService;
import org.example.pet.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth/admin")
public class AdminPanel {

    private final UserService userService;
    @GetMapping("/allUsers")
    public List<UserDto> listUsers(User user){
        List<UserDto> userList = userService.getUserDtoList();
        return userList;
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.ok("User deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting user");
        }
    }

    @PutMapping("/editUser/{id}")
    public ResponseEntity<?> editUser(@PathVariable Long id, @RequestBody UserDto updatedUserDto) {
        try {
            UserDto editedUser = userService.editUser(id, updatedUserDto);
            return ResponseEntity.ok(editedUser);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error editing user");
        }
    }
}
