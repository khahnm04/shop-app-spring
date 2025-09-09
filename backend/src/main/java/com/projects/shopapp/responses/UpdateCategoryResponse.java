package com.projects.shopapp.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCategoryResponse {

    @JsonProperty("mesage")
    private String message;

}
