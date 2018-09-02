package com.anoyi.grpc.client.controller;

import com.anoyi.grpc.facade.entity.UserEntity;
import com.anoyi.grpc.facade.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public UserEntity insertUser(@RequestBody UserEntity userEntity) {
		userService.insert(userEntity);
		return userEntity;
	}

	@RequestMapping(value = "/addAll", method = RequestMethod.POST)
	public List<UserEntity> insertUserAll(@RequestBody List<UserEntity> userEntityList) {
		userService.insertAll(userEntityList);
		return userService.findAll();
	}

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public UserEntity findUser(@RequestParam("id") Long id) {
		return userService.findById(id);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public UserEntity updateUser(@RequestBody UserEntity userEntity) {
		userService.update(userEntity);
		return userEntity;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<UserEntity> findAllUser() {
		return userService.findAll();
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public UserEntity removeUser(@RequestParam("id") Long id) {
		UserEntity userEntity = userService.findById(id);
		userService.deleteById(id);
		return userEntity;
	}

}
