package com.springBootLearning.spring_boot_0_1.Controller;


import com.springBootLearning.spring_boot_0_1.Dto.PostDTO;
import com.springBootLearning.spring_boot_0_1.Service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public List<PostDTO> getAllPosts(){
        return postService.getAllPosts();
    }

//    @GetMapping("/{postId}")
//    public PostDTO getPostsById(@PathVariable Long postId){
//    return postService.
//    }

    @PostMapping
    public PostDTO createPosts(@RequestBody PostDTO postDTO){
        return postService.createNewPost(postDTO);
    }


}
