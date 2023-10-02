package com.voterapp.votersapp.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "politicalParty")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PoliticalParty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}
