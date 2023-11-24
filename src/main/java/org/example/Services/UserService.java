package org.example.Services;

import org.example.Repository.UserRepository;
import org.example.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepository;
   // private  PasswordEncoder passwordEncoder;

  @Autowired

    public UserService(UserRepository userRepository
                       //, PasswordEncoder passwordEncoder
  ) {
        this.userRepository = userRepository;
    //    this.passwordEncoder = passwordEncoder;
    }
//    @Autowired
//    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }

    public void newUser(User user) {
        userRepository.save(user);
    }
    public  boolean userExists(String email,String password) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
return  user.getPassword().equals(password);
         //   return passwordEncoder.matches(password, user.getPassword());
        }
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Implement your logic to load a user by username from the repository
        // and return a UserDetails object

        // Example:
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                // Add your authorities here if applicable
                Collections.emptyList()
        );
    }
}
