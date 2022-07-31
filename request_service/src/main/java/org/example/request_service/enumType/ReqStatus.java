package org.example.request_service.enumType;



public enum ReqStatus {

    PENDING(0),
    REJECTED(1),
    APPROVED(2),
    ;


    private Integer val;

    private ReqStatus(Integer val){
        this.val = val;
    }


    public Integer getVal(){
        return this.val;
    }
}
