package com.toantr.webapp.service;

import com.toantr.webapp.model.User;

public interface UserService
{
    Iterable<User> findAll();
    void save(User user);
    void delete(Long id);
}
