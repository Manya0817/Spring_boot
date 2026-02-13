package com.module4.productionReadyFeatures.productionReadyFeatures.services;

import com.module4.productionReadyFeatures.productionReadyFeatures.dto.PostDTO;
import com.module4.productionReadyFeatures.productionReadyFeatures.entities.PostEntity;
import com.module4.productionReadyFeatures.productionReadyFeatures.exceptions.ResourceNotFoundException;
import com.module4.productionReadyFeatures.productionReadyFeatures.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<PostDTO> getAllPosts() {
        return postRepository
                .findAll()
                .stream()
                .map(postEntity -> modelMapper.map(postEntity,PostDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDTO createNewPost(PostDTO inputPost) {
        PostEntity postEntity=modelMapper.map(inputPost,PostEntity.class);
        return modelMapper.map(postRepository.save(postEntity),PostDTO.class);
    }

    @Override
    public PostDTO getPostById(Long postId) {
        PostEntity postEntity=postRepository
                .findById(postId)
                .orElseThrow(()->new ResourceNotFoundException("Page not found with id "+postId));
        return modelMapper.map(postEntity,PostDTO.class);
    }
}
