package com.example.class1.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RegisterService {


    private static Map<Integer,String> timeNames;
    static {
        timeNames = new HashMap<>();
        timeNames.put(1,"上午");
        timeNames.put(2,"下午");
        timeNames.put(3,"晚上");
    }

    public List<String> getTimeNamesById(List<Integer> times){
        // [1,3] -> {"上午" ,"晚上"}

        return  times.stream()
                     .map(t -> timeNames.get(t)) //映射轉換
                     .collect(Collectors.toList());



    }

}
