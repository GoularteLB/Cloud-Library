package com.cloud.senac.library.core.service.auth;

import org.springframework.http.ResponseEntity;

public interface IAuthService<L, R>{

    ResponseEntity register(R dto);
    ResponseEntity registerAdm(R dto);
    ResponseEntity login(L dto);

}
