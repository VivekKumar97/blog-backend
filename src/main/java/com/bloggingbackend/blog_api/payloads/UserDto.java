package com.bloggingbackend.blog_api.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

	private Integer id;
    private String username;
    private String password;
    private String email;
    private String about;

}
