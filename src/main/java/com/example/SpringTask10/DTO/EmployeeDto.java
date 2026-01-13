package com.example.SpringTask10.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto {

    @NotBlank(message = "name should not blank or empty")
    private String name;

    @NotBlank(message = "email should not be blank")
    @Email(message = "email should be in proper format")
    private String email;

    @NotBlank(message = "Phone should not be blank")
    @Pattern(regexp = "[6-9][0-9]{9}+",
             message = "enter valid indian number")
    private String phone;

    @NotBlank(message = "address should not be empty or blank")
    private String address;
}
