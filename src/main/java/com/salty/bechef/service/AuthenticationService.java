package com.salty.bechef.service;

import com.salty.bechef.payload.request.AuthenticationRequest;
import com.salty.bechef.payload.request.RegisterRequest;
import com.salty.bechef.payload.response.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);
    AuthenticationResponse authenticate(AuthenticationRequest request);
}
