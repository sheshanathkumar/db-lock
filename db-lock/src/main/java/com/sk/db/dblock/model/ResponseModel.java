package com.sk.db.dblock.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseModel implements Serializable {

    private int code;

    private String status;

    private Object result;

}
