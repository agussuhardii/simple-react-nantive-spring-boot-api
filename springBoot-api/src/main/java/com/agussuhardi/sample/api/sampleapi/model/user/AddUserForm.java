package com.agussuhardi.sample.api.sampleapi.model.user;

import com.agussuhardi.sample.api.sampleapi.orm.User;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AddUserForm {

    @NotNull
    private String firstName;

    private String lastName;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String phoneNumber;

    private String error;

    private User user;
}
