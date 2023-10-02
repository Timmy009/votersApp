package com.voterapp.votersapp.mail;


import com.voterapp.votersapp.user.User;
import com.voterapp.votersapp.vote.Vote;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;


@Getter
@Setter
public class RegistrationCompleteEvent extends ApplicationEvent {
    private User user;
    private String applicationUrl;
    private Vote vote;


    public RegistrationCompleteEvent(User user, String applicationUrl) {
        super(user);
        this.user = user;
        this.applicationUrl = applicationUrl;
    }

    public RegistrationCompleteEvent (Vote vote) {
        super(vote);
        this.vote = vote;
    }
}
