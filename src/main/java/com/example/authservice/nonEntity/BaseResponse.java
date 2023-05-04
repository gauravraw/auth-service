package com.example.authservice.nonEntity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BaseResponse<T> {

    private T data;

    @Builder.Default
    private boolean success = true;
}
