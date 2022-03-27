package com.example.springrestfuldemo.dao;

import com.example.springrestfuldemo.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
