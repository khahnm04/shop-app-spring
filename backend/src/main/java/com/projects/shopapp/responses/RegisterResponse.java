package com.projects.shopapp.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.projects.shopapp.models.User;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterResponse {

    @JsonProperty("mesage")
    private String message;

    @JsonProperty("user")
    private User user;

}
