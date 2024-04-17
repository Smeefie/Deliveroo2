package com.deliveroo2.main.repository;

import com.deliveroo2.main.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
