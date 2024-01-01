package com.sk.db.dblock;

import com.sk.db.dblock.entity.TestCenter;
import com.sk.db.dblock.repo.TestRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableScheduling
@Slf4j
public class DbLockApplication {

    @Autowired
    TestRepo testRepo;

    public static void main(String[] args) {
        SpringApplication.run(DbLockApplication.class, args);
        System.out.println("App Started!");
    }

    @Scheduled(fixedDelay = 1000 * 60 * 3)
    @Async
    public void run() {
        log.info("Start saving test details");
        int testId = testRepo.getLastIdNumber();
        String name = "test_";
        String desc = "random test id ";
        List<TestCenter> testCenters = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            testId = testId + 1;
            testCenters.add(TestCenter.builder()
                    .testId(testId)
                    .testName(name + testId)
                    .testDesc(desc + testId)
                    .build());

        }
        testRepo.saveAll(testCenters);
        log.info("----------Test Centers Saved ---------\n");
    }

}
