package com.shop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.model.AppUsers;

@Repository
public interface UserRepository extends JpaRepository<AppUsers, String> {

    public Optional<AppUsers> getUserByContactNumber(String contactNumber);

}
