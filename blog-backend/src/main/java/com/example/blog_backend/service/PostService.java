package com.example.blog_backend.service;

import com.example.blog_backend.domain.Post;
import com.example.blog_backend.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository repository;

    public List<Post> findAll() {
        return repository.findAll();
    }

    public Optional<Post> findById(Long id) {
        return repository.findById(id);
    }

    public Post create(Post post) {
        return repository.save(post);
    }

    public Optional<Post> update(Long id, Post updated) {
        return repository.findById(id)
                .map(post -> {
                    post.setTitle(updated.getTitle());
                    post.setContent(updated.getContent());
                    return repository.save(post);
                });
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}