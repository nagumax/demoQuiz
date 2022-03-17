package com.example.demo.controller;

import com.example.demo.dto.BucketDTO;
import com.example.demo.entity.Bucket;
import com.example.demo.entity.User;
import com.example.demo.service.BucketService;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;
import java.util.List;

@Controller
public class BucketController {

    private final BucketService bucketService;
    private final UserService userService;


    public BucketController(BucketService bucketService, UserService userService) {
        this.bucketService = bucketService;
        this.userService = userService;
    }

    @GetMapping("/bucket")
    public String bucketInfo(Model model, Principal principal){
        if (principal == null) {
            model.addAttribute("bucket", new BucketDTO());
        } else {
              BucketDTO bucketDTO = bucketService.getBucketByUser(principal.getName());
              model.addAttribute("bucket", bucketDTO);
        }
        return "bucket";
    }

    @GetMapping("/bucketList")
    public String bucketInfoList(Model model, List<User> userList){
        if (userList == null){
            throw new RuntimeException("Order list is empty");
        } else{
            List<BucketDTO> bucketDTOList = bucketService.getBucketByAllUser(userService.getAll());
        }
            return "bucketList";
    }

    @DeleteMapping("/bucket/{productId}")
    public String deleteProductAtBucket(Bucket bucket, @PathVariable Long productId){

        bucketService.removeProductAtBucket(bucket, productId);
        return "redirect:/bucket";
    }


}
