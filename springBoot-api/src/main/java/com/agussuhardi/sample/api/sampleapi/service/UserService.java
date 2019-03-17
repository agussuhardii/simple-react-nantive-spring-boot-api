package com.agussuhardi.sample.api.sampleapi.service;

import com.agussuhardi.sample.api.sampleapi.dao.UserDao;
import com.agussuhardi.sample.api.sampleapi.model.user.AddUserForm;
import com.agussuhardi.sample.api.sampleapi.model.user.UpdateUserForm;
import com.agussuhardi.sample.api.sampleapi.orm.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User add(AddUserForm form) {

        User user = new User();
        user.setStatus(User.STATUS_ACTIVE);
        user.setAuthKey(UUID.randomUUID().toString());
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setUsername(form.getUsername());
        user.setPassword(form.getPassword());
        user.setPhoneNumber(form.getPhoneNumber());

        return userDao.save(user);
    }

    public User update(UpdateUserForm form) throws Exception {

        Optional<User> optional = userDao.findById(form.getId());

        if (!optional.isPresent()) throw new Exception("Data not found");

        User user = optional.get();
        user.setStatus(User.STATUS_ACTIVE);
        user.setAuthKey(UUID.randomUUID().toString());
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        if (form.getPassword() !=null)user.setPassword(form.getPassword());
        user.setPhoneNumber(form.getPhoneNumber());
        user.setUsername(form.getUsername());

        return userDao.save(user);
    }

    public User getById(String id) throws Exception {
        Optional<User> optional = userDao.findById(id);

        if (!optional.isPresent()) throw new Exception("Data not found");

        return optional.get();
    }

    public Page<User> list(Pageable pageable) {
        return userDao.findAll(pageable);
    }


    public void delete(String id) throws Exception {
        userDao.deleteById(id);
    }

}
