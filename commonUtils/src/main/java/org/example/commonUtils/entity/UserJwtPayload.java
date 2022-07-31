package org.example.commonUtils.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;




@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserJwtPayload {
    String uid;
    LocalDateTime expire;
}
