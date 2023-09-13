package com.example.Student_Management_System.Dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@Entity

@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "first_name", nullable = false)
    private String firstname;


    @Column(name = "last_name")
    private String lastname;


    @Column(name = "email")
    private String email;

public  Student(){

}
}
