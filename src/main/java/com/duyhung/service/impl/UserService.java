package com.duyhung.service.impl;


import com.duyhung.entity.User;
import com.duyhung.repository.IUserRepository;
import com.duyhung.repository.impl.UserRepository;
import com.duyhung.service.IUserService;

public class UserService implements IUserService {
    private IUserRepository repository;

    public UserService() {
        repository = new UserRepository();
    }

    @Override
    public User findByEmailAndPass(String email, String pass) {
        return repository.findByEmailAndPass(email,pass);
    }
}
