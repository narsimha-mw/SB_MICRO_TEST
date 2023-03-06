package com.ics.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuperVisorRequest {

    private int user_id;

    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private String employee_id;
    private int fos_user_type;
    private int supervisor_id;
    private int manager_id;
//    private int market;
    private String created;
    private String modified;
}
