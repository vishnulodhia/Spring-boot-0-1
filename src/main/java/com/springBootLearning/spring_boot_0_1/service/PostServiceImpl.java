package com.springBootLearning.spring_boot_0_1.service;

import com.springBootLearning.spring_boot_0_1.Dto.PostDTO;
import com.springBootLearning.spring_boot_0_1.Repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor

public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Override
    public List<PostDTO> getAllPosts() {
        return List.of();
    }

    @Override
    public PostDTO createNewPost(PostDTO inputPost) {
        return null;
    }
}
