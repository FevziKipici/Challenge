package com.egt.challenge.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter


@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



//    @JsonIgnore
//    @ManyToOne



    @OneToOne
    @JoinColumn(name="person_id")
    private Person person;

    //@NotBlank(message = "Please enter your street")
    @Column(length = 255,nullable = false)
    private String street1;

    private String street2;

    @NotBlank(message = "Please enter your city")
    @Column(length = 100,nullable = false)
    private String city;

    @NotBlank(message = "Please enter your state")
    @Column(length = 100,nullable = false)
    private String state;

    @NotBlank(message = "Please enter your zipcode")
    @Column(length = 100,nullable = false)
    private String zipCode;

}
