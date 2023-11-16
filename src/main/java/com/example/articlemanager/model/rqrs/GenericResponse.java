package com.example.articlemanager.model.rqrs;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class GenericResponse {

    @JsonIgnore
    private HttpStatusCode httpStatusCode;
    private String message;
    private String code;
    private String status;
    private Object data;
    private String error;

    public void setSuccess(){
        this.httpStatusCode = HttpStatus.OK;
        this.message = "Request Success";
        this.code = "00";
        this.status = "Success";
        this.data = null;
        this.error = null;
    }


    public void setSuccess(Object data){
        this.httpStatusCode = HttpStatus.OK;
        this.message = "Request Success";
        this.code = "00";
        this.status = "Success";
        this.data = data;
        this.error = null;
    }

    public void setSuccessMsg(String msg){
        this.httpStatusCode = HttpStatus.OK;
        this.message = msg;
        this.code = "00";
        this.status = "Success";
        this.data = null;
        this.error = null;
    }

    public void setFailed(HttpStatusCode httpStatusCode, String errorString){
        this.httpStatusCode = httpStatusCode;
        this.message = "Request Failed";
        this.code = httpStatusCode.is5xxServerError() ? "02" : "01";
        this.status = httpStatusCode.is5xxServerError() ? "System Error" : "Business Error";
        this.data = null;
        this.error = errorString;
    }

}
