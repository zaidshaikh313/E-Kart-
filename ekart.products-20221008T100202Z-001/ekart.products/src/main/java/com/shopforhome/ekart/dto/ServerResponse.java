package com.shopforhome.ekart.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@Getter
@Setter
public class ServerResponse {

    private HttpStatus status;
    private String desc;
    private Object object;

    public ServerResponse(HttpStatus status,String desc) {
        this.status=status;
        this.desc = desc;
    }
}
