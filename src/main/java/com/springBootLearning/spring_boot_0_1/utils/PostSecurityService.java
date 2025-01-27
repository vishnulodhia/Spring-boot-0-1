package com.springBootLearning.spring_boot_0_1.utils;


import com.springBootLearning.spring_boot_0_1.Dto.PostDTO;
import com.springBootLearning.spring_boot_0_1.Model.User;
import com.springBootLearning.spring_boot_0_1.Service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostSecurityService {

    private final PostService postService;

//    public boolean isOwnerOfPost(Long postId){
//        User user  =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        PostDTO postDTO =  postService.getPostById(postId);
//        return
//    }


}
