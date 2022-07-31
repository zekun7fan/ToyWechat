package org.example.post_content_service.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.commonUtils.entity.PostContent;

import java.util.HashMap;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscoveryResult {

    private HashMap<String, Integer> friendToPostSeq;

    private List<PostContent> list;
}











