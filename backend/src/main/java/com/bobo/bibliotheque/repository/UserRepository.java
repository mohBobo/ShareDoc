package com.bobo.bibliotheque.repository;

import com.bobo.bibliotheque.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    List<User> findByEmail(String email);

}
