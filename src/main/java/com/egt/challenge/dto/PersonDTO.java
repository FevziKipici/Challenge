package com.egt.challenge.dto;

import com.egt.challenge.model.Address;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class PersonDTO {


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
}
