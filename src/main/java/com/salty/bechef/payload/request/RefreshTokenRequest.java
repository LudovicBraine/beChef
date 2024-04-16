package com.salty.bechef.payload.request;

import lombok.Data;

@Data
public class RefreshTokenRequest {
    private String refreshToken;
}