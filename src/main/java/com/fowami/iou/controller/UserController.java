/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fowami.iou.controller;

import com.fowami.iou.model.Iou;
import com.fowami.iou.model.User;
import com.fowami.iou.repository.IouRepository;
import com.fowami.iou.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Developer
 */
@RestController
@RequestMapping("/api")
public class UserController {

  @Autowired 
  UserRepository userRepository;
  
  @Autowired
  IouRepository iouRepository;

  
  @PostMapping("/add")
  public ResponseEntity<User> createUser(@RequestBody User user) {
   if(user.getUser()==null||user.getId()==null){
     return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
   }
     try {
      User users = userRepository.save(new User(user.getId(),user.getUser()));
      return new ResponseEntity<>(users, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
    }
  }
  
  
  @PostMapping("/iou")
  public ResponseEntity<Iou> createIOU(@RequestBody Iou iou){
      if(iou.getId()==null||iou.getLeader()==null){
       return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
      }
      try {
      Iou loan =  iouRepository.save(new Iou(iou.getId(),iou.getLeader(),iou.getBorrower(),iou.getAmount()));
      return new ResponseEntity<>(loan,HttpStatus.CREATED);
      } catch (Exception e) {
       return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
      }
  }
 
   @GetMapping("/users")
  public ResponseEntity<List<User>> getAllUsers(){
      try {
          List<User> list = userRepository.getAllUsers();
         if (list.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }      
      return new ResponseEntity<>(list, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
 
}
