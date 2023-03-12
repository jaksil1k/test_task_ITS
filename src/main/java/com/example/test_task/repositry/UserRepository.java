package com.example.test_task.repositry;

import com.example.test_task.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Query(value = "select id, name, email, password from friends f join users u on f.friend_id=u.id where f.user_id = ?1", nativeQuery = true)
    List<User> getAllFriendsByUserId(Long user_id);

    Optional<User> findByEmail(String email);


    @Query(value = "select u.email, u.name, u.password from users u " +
            "join friends f on f.friend_email = u.email " +
            "join users_locations us on f.friend_email = us.user_email " +
            "where us.location_id = 11 and f.user_email = 'nartai53@gmail.com'", nativeQuery = true)
    List<User> getAllFriendsByLocationId(Long location_id, String user_email);
}
