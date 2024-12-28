package com.bloggingbackend.blog_api.services;

import com.bloggingbackend.blog_api.exception.BlogException;
import com.bloggingbackend.blog_api.payloads.UserDto;

import java.util.List;

public interface UserService {
    public UserDto createUser(UserDto userdto);
    public UserDto getUser(Integer id) throws BlogException;
    public UserDto updateUser(UserDto userdto, Integer id) throws BlogException;
    public void deleteUser(int Id);
    public List<UserDto> getAllUsers();
}
