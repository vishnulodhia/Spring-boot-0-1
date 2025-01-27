package com.springBootLearning.spring_boot_0_1.Controller;


import com.springBootLearning.spring_boot_0_1.Dto.PostDTO;
import com.springBootLearning.spring_boot_0_1.Model.User;
import com.springBootLearning.spring_boot_0_1.Service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    @Secured({"ROLE_USER","ROLE_ADMIN"})
    public List<PostDTO> getAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping("/{postId}")
    @PreAuthorize("hasAnyRole('USER,ADMIN) AND hasAuthority('POST_VIEW')")

    //not user Role it default it a prefix
    public PostDTO getPostsById(@PathVariable Long postId){
    return postService.getPostById(postId);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public PostDTO createPosts(@RequestBody PostDTO postDTO){
        return postService.createNewPost(postDTO);
    }


}
