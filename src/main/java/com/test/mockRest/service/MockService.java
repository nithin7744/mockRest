package com.test.mockRest.service;

import com.test.mockRest.model.ResponseData;
import com.test.mockRest.model.RestResponseStatus;
import com.test.mockRest.model.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Map;

import static java.lang.String.format;

@Service
public class MockService {

//    {"result":{"errNo":200,"errMsg":"Login Success!"},"data":{"userDtls":{"userCode":"rajeev","groupNo":3,"userName":" Rajeev Roy"}}}
    static Map<String, Map<String, Object>> userDetails = Map.of(
            "test-12345", Map.of("userCode","TestUSer","groupNo",3,"userName","Test User1"),
            "ABC-12345", Map.of("userCode","ABCUSer","groupNo",3,"userName","ABC User1"),
            "test2-12345", Map.of("userCode","Test2USer","groupNo",3,"userName","Test User2")
    );

    public ResponseData validateData(String loginId, String password) {
        if(userDetails.containsKey(format("%s-%s", loginId, password)))
            return buildResponseData(userDetails.get(format("%s-%s", loginId, password)));
        else
            return buildErrorResponse("Login Failed", "200");
    }

    private ResponseData buildErrorResponse(String errorMessage, String errCode) {
        return ResponseData.builder()
                .result(RestResponseStatus.builder().errMsg(errorMessage).errNo(errCode).build())
                .build();
    }

    private ResponseData buildResponseData(Map<String, Object> stringObjectMap) {
        return ResponseData.builder()
                .result(RestResponseStatus.builder().errMsg("Login Success").errNo("200").build())
                .data(UserDetails.builder().userDtls(stringObjectMap).build())
                .build();
    }


}
