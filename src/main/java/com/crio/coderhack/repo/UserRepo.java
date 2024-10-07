package com.crio.coderhack.repo;


import com.crio.coderhack.model.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends MongoRepository<UserEntity , String> {
}
