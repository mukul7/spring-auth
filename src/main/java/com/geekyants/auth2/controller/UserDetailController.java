package com.geekyants.auth2.controller;

import com.geekyants.auth2.entities.Detail;
import com.geekyants.auth2.entities.User;
import com.geekyants.auth2.repositories.DetailRepository;
import com.geekyants.auth2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;



//@RestController
//public class UserDetailController {
////    @Autowired
////    UserRepository userRepo;
//
////    @Autowired
////    DetailRepository detailRepo;
//
////    public Detail getDetail(@PathVariable Long id){
////        User user = userRepo.getOne(id);
////        return user.getDetail();
////    }
////
////    @PutMapping("/")
////    public String patch(@PathVariable Long user_id, @RequestParam Detail detail){
////        System.out.println(updatedDetail.toString() + user_id);
////          return "jhvjhv";
////        User user = userRepo.getOne(user_id);
////        updatedDetail.setId(user.getDetail().getId());
////        return detailRepo.save(updatedDetail);
////    }
//}
