package com.example.lenovog480.iseooalpha.model;

import java.util.List;

/**
 * Created by Lenovo G480 on 10/23/2017.
 */

public class ApiResponseModel {
    String status;
    String message;
    List<EventModel> result;
    String value;

    public String getStatus() {
        return status;
    }
    public String getMessage() {
        return message;
    }
    public List<EventModel> getResult() {
        return result;
    }
    public String getValue(){return value;}


}
