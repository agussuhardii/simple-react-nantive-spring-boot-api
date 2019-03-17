package com.agussuhardi.sample.api.sampleapi.model.user;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class DeleteUserForm {

    private String error;

    @NotNull
    private String id;
}
