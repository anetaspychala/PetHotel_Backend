package org.example.pet.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.pet.entity.Role;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
public class UserDto {

    private Long id;
    @Length(min = 5, max = 50, message = "Login powinien miec od 5 do 50 znakow")
    private String login;
    @Email
    private String email;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Length(min = 8, max = 75, message = "Haslo powinno miec od 8 do 75 znakow")
    private String password;
    private Role role;

}