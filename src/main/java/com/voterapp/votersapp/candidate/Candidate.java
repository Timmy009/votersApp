package com.voterapp.votersapp.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "candidates")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne (fetch = FetchType.EAGER)
    private Position post;
    private String email;
    @OneToOne (fetch = FetchType.EAGER)
    private PoliticalParty politicalParty;
}
