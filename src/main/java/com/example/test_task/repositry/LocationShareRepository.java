package com.example.test_task.repositry;

import com.example.test_task.entity.LocationShare;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationShareRepository extends CrudRepository<LocationShare, Long> {
}
