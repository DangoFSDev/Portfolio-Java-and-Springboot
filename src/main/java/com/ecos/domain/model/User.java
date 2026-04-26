package com.ecos.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class User {

    private Long id;
    private Long userId;
    private String userName;
    private String nickName;
    private String password;
    private String role;

}
