package com.springBootLearning.spring_boot_0_1.Service;

import com.springBootLearning.spring_boot_0_1.Dto.PostDTO;

import java.util.List;

public interface PostService {
        public List<PostDTO> getAllPosts();
        public PostDTO createNewPost(PostDTO inputPost);
        public PostDTO getPostById(Long postId);
}
