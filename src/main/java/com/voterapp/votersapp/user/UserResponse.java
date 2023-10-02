package com.voterapp.votersapp.dto.responses;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {

  private Long id;
  private String firstname;
  private String lastname;
  private String email;


}
