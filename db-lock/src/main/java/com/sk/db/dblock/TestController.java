package com.sk.db.dblock;

import com.sk.db.dblock.entity.TestCenter;
import com.sk.db.dblock.model.ResponseModel;
import com.sk.db.dblock.repo.TestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    TestRepo testRepo;

    @GetMapping(value = "/fetch", produces = "application/json")
    public ResponseEntity<ResponseModel> fetchTest () {
        Sort sort = Sort.by(Sort.Direction.DESC, "testId");
        Pageable page = PageRequest.of(0, 5, sort);
        Page<TestCenter> testCenterPage = testRepo.findAll(page);
        List<TestCenter> testCenters = testCenterPage.toList();
        ResponseModel response = ResponseModel.builder()
                .code(200)
                .status("SUCCESS")
                .result(testCenters)
                .build();
        return new ResponseEntity<>( response, HttpStatus.OK );
    }


}
