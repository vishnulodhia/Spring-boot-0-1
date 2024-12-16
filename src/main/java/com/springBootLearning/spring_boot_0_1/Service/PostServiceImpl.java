package com.springBootLearning.spring_boot_0_1.Service;

import com.springBootLearning.spring_boot_0_1.Dto.PostDTO;
import com.springBootLearning.spring_boot_0_1.Model.PostEntity;
import com.springBootLearning.spring_boot_0_1.Repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<PostDTO> getAllPosts() {
        return postRepository.findAll().stream().map(postEntity -> modelMapper.map(postEntity,PostDTO.class)).collect(Collectors.toList());
    }

    @Override
    public PostDTO createNewPost(PostDTO inputPost) {
        PostEntity postEntity = modelMapper.map(inputPost,PostEntity.class);
        return modelMapper.map(postRepository.save(postEntity),PostDTO.class);
    }
}
