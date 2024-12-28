package com.bloggingbackend.blog_api.services;

import com.bloggingbackend.blog_api.entities.User;
import com.bloggingbackend.blog_api.exception.BlogException;
import com.bloggingbackend.blog_api.payloads.UserDto;
import com.bloggingbackend.blog_api.repositories.UserRepo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userdto){
        User user= this.dtoToUser(userdto);
        User savedUser= userRepo.save(user);
        return this.UserToDto(savedUser);
    }
    @Override
    public UserDto updateUser(UserDto userdto , Integer id) throws BlogException{
        Optional<User> optional= this.userRepo.findById(id);
        User user= optional.orElseThrow(()->new BlogException("User not found"));
        user.setAbout(userdto.getAbout());
        User savedUser= this.userRepo.save(user);
        return this.UserToDto(savedUser);
    }
    @Override
    public List<UserDto> getAllUsers(){
        List<User> users = this.userRepo.findAll();
        List<UserDto> userdtos= users.stream().map(user->this.UserToDto(user)).collect(Collectors.toList());
		return userdtos;

    }
	@Override
	public UserDto getUser(Integer id) throws BlogException{
		// TODO Auto-generated method stub
		Optional<User> optional= this.userRepo.findById(id);
		User user = optional.orElseThrow(()-> new BlogException("User not found"));
		return this.UserToDto(user);
//		return null;
	}
	@Override
	public void deleteUser(int Id) {
		// TODO Auto-generated method stub
		this.userRepo.deleteById(Id);
		return;
		
	}
	
    public User dtoToUser(UserDto userdto){
//        User user= new User();
//        user.setUsername(userdto.getUsername());
//        user.setPassword(userdto.getPassword());
//        user.setEmail(userdto.getEmail());
//        user.setAbout(userdto.getAbout());

        User user= this.modelMapper.map(userdto, User.class);
        return user;
    }
    public UserDto UserToDto(User user){
        UserDto userdto= this.modelMapper.map(user, UserDto.class);
//        userdto.setId(user.getId());
//        userdto.setUsername(user.getUsername());
//        userdto.setPassword(user.getPassword());
//        userdto.setEmail(user.getEmail());
//        userdto.setAbout(user.getAbout());
        return userdto;
    }
}
