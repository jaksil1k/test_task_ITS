package com.example.test_task.repositry;

import com.example.test_task.entity.Location;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {

    @Query(value = "select l.id, l.name, l.address from shared_locations sl " +
            "join users u on sl.user_email = u.email\n" +
            "join locations l on sl.location_id = l.id\n" +
            "where u.email = ?1\n" +
            "union\n" +
            "select l.id, l.name, l.address from users_locations sl\n" +
            "join users u on sl.user_email = u.email\n" +
            "join locations l on sl.location_id = l.id\n" +
            "where u.email = ?1",
            nativeQuery = true)
    List<Location> getAllLocationsByUserEmail(String email);
}
