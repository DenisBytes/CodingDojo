package com.denis.authentication.services;

import java.util.Optional;

import com.denis.authentication.models.LoginUser;
import com.denis.authentication.models.User;
import com.denis.authentication.repositories.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import javax.swing.text.html.Option;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // TO-DO: Write register and login methods!
    public User register(User newUser, BindingResult result) {

        Optional<User> potentialUser = userRepository.findByEmail(newUser.getEmail());

        if(potentialUser.isPresent()){
            result.rejectValue("email","EmailTaken",
                    "the email has already been taken");
        }
        if(!newUser.getPassword().equals(newUser.getConfirm())) {
            result.rejectValue("confirm", "Matches",
                    "The Confirm Password must match Password!");
        }
        if(result.hasErrors()){
            return null;
        }
        else{
            String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
            newUser.setPassword(hashed);
            return userRepository.save(newUser);
        }
    }
    public User login(LoginUser newLoginObject, BindingResult result) {
        // TO-DO - Reject values:

        // Find user in the DB by email
        Optional<User> potentialUser = userRepository.findByEmail(newLoginObject.getEmail());

        // Reject if NOT present
        if(!potentialUser.isPresent()){
           result.rejectValue("email","EmailNotFound","the email does not exist");
        }else{
            // Reject if BCrypt password match fails
            if(!BCrypt.checkpw(newLoginObject.getPassword(), potentialUser.get().getPassword())) {
                result.rejectValue("password", "Matches", "Invalid Password!");
            }
        }

        // Return null if result has errors
        if(result.hasErrors()){
            return null;
        }else{
            return potentialUser.get();
        }
    }

    public User findUser(Long id){
        Optional<User> optionalUser = userRepository.findById(id);

        if(!optionalUser.isPresent()){
            return null;
        }
        else{
            return optionalUser.get();
        }
    }
}

