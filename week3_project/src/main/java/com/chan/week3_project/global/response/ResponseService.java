package com.chan.week3_project.global.response;
import com.chan.week3_project.global.dto.result.ListResult;
import com.chan.week3_project.global.dto.result.SingleResult;
import org.springframework.stereotype.Component;

import java.util.List;

// 두가지 경우(하나 혹은 리스트)를 ResponseService라는 클래스로
// 제네릭으로 규격화한 SingleResult<T>,ListResult<T> 로 규격화하여 반환
@Component
public class ResponseService {
    // 단일 값을 감싸는 메서드
    public static <T> SingleResult<T> getSingleResult(T data) {
        SingleResult<T> result = new SingleResult<>();
        result.setData(data);
        return result;
    }

    // 리스트 값을 감싸는 메서드
    public static <T> ListResult<T> getListResult(List<T> list) {
        ListResult<T> result = new ListResult<>();
        result.setList(list);
        return result;
    }
}
