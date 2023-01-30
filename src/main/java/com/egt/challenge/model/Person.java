package com.egt.challenge.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter



@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personId;

    @NotBlank(message = "Please enter your name")
    @Size(min = 4,max = 100,message = "First name '${validatedValue}' should be between {min} and {max}")
    @Column(length = 100,nullable = false)
    private String firstName;

    @NotBlank(message = "Please enter your last name")
    @Size(min = 4,max = 100,message = "First name '${validatedValue}' should be between {min} and {max}")
    @Column(length = 100,nullable = false)
    private String lastName;


    @Column
    @JsonFormat(pattern="MM-dd-yyyy")
    private LocalDate birthDate;


    @OneToOne(mappedBy = "person")
    private Address mainAddress;


    @OneToMany(mappedBy = "person")
    private Set<Address> additionalAddresses;




}
