package com.example.http.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Albums {

    @JsonProperty("userId")
    private Integer userId;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("title")
    private String title;
}
