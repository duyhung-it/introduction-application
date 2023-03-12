package com.duyhung.service;

import com.duyhung.entity.User;

public interface IUserService {
    User findByEmailAndPass(String email,String pass);
}
