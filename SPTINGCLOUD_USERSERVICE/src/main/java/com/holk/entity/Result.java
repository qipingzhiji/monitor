package com.holk.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Result  {
    private int code ;
    private  String  msg;
    private List date;
}
