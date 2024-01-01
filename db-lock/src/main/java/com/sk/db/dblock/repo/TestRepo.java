package com.sk.db.dblock.repo;

import com.sk.db.dblock.entity.TestCenter;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepo extends JpaRepository<TestCenter, Integer> {

   // public List<TestCenter> findLast5(Sort sort);

    @Query(value = "select test_id from test_center order by test_id desc limit 1", nativeQuery = true)
    public int getLastIdNumber();

}
