package org.example.pet.configuration;

import lombok.RequiredArgsConstructor;
import org.example.pet.model.User;
import org.example.pet.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Optional<User> user =userRepository.findUserByLogin(username);
        return user.map(CustomUserDetails::new).orElseThrow(()-> new UsernameNotFoundException("User not found with name: "+ username));
    }

}
