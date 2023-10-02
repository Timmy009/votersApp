package com.voterapp.votersapp.user;

import com.voterapp.votersapp.exception.UserAlreadyExistException;
import com.voterapp.votersapp.security.EmailConfig;

import com.voterapp.votersapp.security.Utils;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VotersUserService implements UserService{

    private final UserRepository userRepository;

    public final EmailConfig emailConfig;

    @Override
    public UserRegistrationResponse register(UserRegistrationRequest request) {
        Optional<User> user = userRepository.findAllByEmail(request.getEmail());
        if (user.isPresent()) {
          throw new UserAlreadyExistException("USER ALREADY EXIST");
        }
User newUser = new User();
        String password = Utils.generateDefaultPassword(8);
        newUser.setFirstName(request.getFirstName());
        newUser.setLastName(request.getLastName());

        newUser.setEmail(request.getEmail());

        userRepository.save(newUser);

        String emailSubject = "Document Management System! User Password";
        String emailBody = "Dear " + newUser.getFirstName() + ",<br><br>"
                + "Welcome to Timmy Voter App! Your account has been created successfully.<br>"
                + "Your password is: <strong>" + password + "</strong><br><br>"
                + "Please login using this password and change it after your first login.<br><br>"
                + "Thank you,<br>The Data Management System Team";
        String receiverEmail = newUser.getEmail();
      emailConfig.sendSimpleMail(receiverEmail,emailSubject,emailBody);
//        System.out.println("i am here");
UserRegistrationResponse response = new UserRegistrationResponse();
response.setMessage("REGISTERED");
        return response;
    }
}
