package org.example.Services;

import org.example.Repository.UserRepository;
import org.example.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

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
}
