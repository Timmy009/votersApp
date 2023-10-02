package com.voterapp.votersapp.dto.requests;


import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreatePoliticalPartyRequest {
    private String name;
}
