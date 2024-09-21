package com.pironeer.week2_1.global.service;

import com.pironeer.week2_1.global.dto.response.result.ListResult;
import com.pironeer.week2_1.global.dto.response.result.SingleResult;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResponseService {

    public static <T>SingleResult<T> getSingleResult(T data) {
        SingleResult<T> result = new SingleResult<>();
        result.setData(data);
        return result;
    }

    public static <T>ListResult<T> getListResult(List<T> data) {
        ListResult<T> result = new ListResult<>();
        result.setData(data);
        return result;
    }
}
