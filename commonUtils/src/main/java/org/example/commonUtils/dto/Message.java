package org.example.commonUtils.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    private String uid;

    private String topic;

    private String msg;

    private Long offset;

    private LocalDateTime create_time;

}
