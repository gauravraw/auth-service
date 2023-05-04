package com.example.authservice.nonEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreationRequestNonEntity {
    private String userName;
    private String password;

}
