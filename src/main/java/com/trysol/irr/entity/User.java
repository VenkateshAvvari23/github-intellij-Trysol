package com.trysol.irr.entity;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name="user")
//@Setter
//@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phoneNo;

    @Column(name = "password")
    private String password;



}
