package com.spring_crud.models.payload.response;






import java.time.LocalDateTime;



public class BaseResponse<T> {

    private Boolean success;

    private String message;

    private T data;

    private LocalDateTime timeStamps = LocalDateTime.now();

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public LocalDateTime getTimeStamps() {
        return timeStamps;
    }

    public void setTimeStamps(LocalDateTime timeStamps) {
        this.timeStamps = timeStamps;
    }

    public BaseResponse(String message) {
        this.message = message;
    }

    public BaseResponse() {
    }
}
