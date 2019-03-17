package com.agussuhardi.sample.api.sampleapi.controller;

import com.agussuhardi.sample.api.sampleapi.model.user.*;
import com.agussuhardi.sample.api.sampleapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    private static String getErrorMessage(BindingResult bindingResult) {
        ObjectError objectError = bindingResult.getAllErrors().get(0);
        if (objectError instanceof FieldError) {
            return ((FieldError) objectError).getField() + " " + objectError.getDefaultMessage();
        }
        return objectError.getDefaultMessage();
    }

    @GetMapping("get/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<GetUser> get(@PathVariable String id) {

        GetUser form = new GetUser();
        try {
            form.setUser(userService.getById(id));
        } catch (Exception e) {
            form.setError(e.getMessage());
            return ResponseEntity.status(500).body(form);
        }

        return ResponseEntity.ok(form);
    }

    @PostMapping("add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AddUserForm> add(@RequestBody @Valid AddUserForm form,
                                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            form.setError(getErrorMessage(bindingResult));
            return ResponseEntity.badRequest().body(form);
        }

        try {
            form.setUser(userService.add(form));

        } catch (Exception e) {
            form.setError(e.getMessage());
            return ResponseEntity.status(500).body(form);
        }
        return ResponseEntity.ok(form);
    }

    @PostMapping("edit")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UpdateUserForm> update(@RequestBody @Valid UpdateUserForm form,
                                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            form.setError(getErrorMessage(bindingResult));
            System.out.println(form.getError());
            return ResponseEntity.badRequest().body(form);
        }

        try {

            System.out.println(form.getUsername());
            form.setUser(userService.update(form));
            System.out.println("save edit");

        } catch (Exception e) {
            form.setError(e.getMessage());
            return ResponseEntity.status(500).body(form);
        }
        return ResponseEntity.ok(form);
    }

    @PostMapping("delete")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<DeleteUserForm> delete(@RequestBody @Valid DeleteUserForm form,
                                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            form.setError(getErrorMessage(bindingResult));
            return ResponseEntity.badRequest().body(form);
        }

        try {
            userService.delete(form.getId());

        } catch (Exception e) {
            form.setError(e.getMessage());
            return ResponseEntity.status(500).body(form);
        }
        return ResponseEntity.ok(form);
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ListUser> list(Pageable pageable) {

        ListUser form = new ListUser();
        try {
            form.setUsers(userService.list(pageable));
        } catch (Exception e) {
            form.setError(e.getMessage());
            return ResponseEntity.status(500).body(form);
        }

        return ResponseEntity.ok(form);
    }
}
