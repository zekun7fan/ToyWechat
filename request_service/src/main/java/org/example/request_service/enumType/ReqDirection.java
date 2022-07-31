package org.example.request_service.enumType;



public enum ReqDirection {

    SENT(0),
    HANDLE(1),
    ;


    private Integer val;

    private ReqDirection(Integer val){
        this.val = val;
    }


    public Integer getVal(){
        return this.val;
    }
}
