package com.codegym.demo.dto.response;

import lombok.Data;

@Data
public class ResponseMessage {
    private String message;

<<<<<<< HEAD
    public ResponseMessage() {
    }

    public ResponseMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
=======
    public ResponseMessage(String s) {
>>>>>>> b8049a60d4163bfa500798d98b26f9b24d1048f5
    }
}
