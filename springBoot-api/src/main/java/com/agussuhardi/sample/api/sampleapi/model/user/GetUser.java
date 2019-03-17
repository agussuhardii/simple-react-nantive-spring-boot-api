package com.agussuhardi.sample.api.sampleapi.model.user;

import com.agussuhardi.sample.api.sampleapi.orm.User;
import lombok.Data;

@Data
public class GetUser {

    private String error;

    private User user;
}
