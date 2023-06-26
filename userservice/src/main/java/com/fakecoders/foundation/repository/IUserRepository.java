package com.fakecoders.foundation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fakecoders.foundation.entities.User;

public interface IUserRepository extends JpaRepository<User, String> {

}
