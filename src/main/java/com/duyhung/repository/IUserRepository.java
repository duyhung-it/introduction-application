package com.duyhung.repository;

import com.duyhung.entity.User;

public interface IUserRepository {
    User findByEmailAndPass(String email,String pass);
}
