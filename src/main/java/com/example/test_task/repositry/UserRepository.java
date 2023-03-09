package com.example.test_task.repositry;

import com.example.test_task.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Query(value = "select id, name, email, password from friends f join users u on f.friend_id=u.id where f.user_id = ?1", nativeQuery = true)
    List<User> getAllFriendsByUserId(Long user_id);
}
