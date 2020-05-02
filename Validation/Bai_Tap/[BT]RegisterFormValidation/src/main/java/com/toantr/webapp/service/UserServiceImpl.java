package com.toantr.webapp.service;

import com.toantr.webapp.model.User;
import com.toantr.webapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepository userRepository;
    @Override
    public Iterable<User> findAll()
    {
        return userRepository.findAll();
    }

    @Override
    public void save(User user)
    {
        userRepository.save(user);
    }

    @Override
    public void delete(Long id)
    {
        userRepository.deleteById(id);
    }
}
