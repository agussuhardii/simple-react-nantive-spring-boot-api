package com.agussuhardi.sample.api.sampleapi.model.user;

import com.agussuhardi.sample.api.sampleapi.orm.User;
import lombok.Data;
import org.springframework.data.domain.Page;

@Data
public class ListUser {

    private String error;

    private Page<User> users;
}
