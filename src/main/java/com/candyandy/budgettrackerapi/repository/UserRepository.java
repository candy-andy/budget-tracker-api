package com.candyandy.budgettrackerapi.repository;

import com.candyandy.budgettrackerapi.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
