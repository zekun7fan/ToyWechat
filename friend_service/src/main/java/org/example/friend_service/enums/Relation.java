package org.example.friend_service.enums;



public enum Relation {

    MYSELF(0),
    FRIEND(1),
    STRANGER(2),

    ;


    private Integer val;

    private Relation(Integer val){
        this.val = val;
    }


    public Integer getVal(){
        return this.val;
    }
}
