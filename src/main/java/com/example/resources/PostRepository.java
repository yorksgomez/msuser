package com.example.resources;

import javax.enterprise.context.ApplicationScoped;

import com.example.model.Post;
import io.quarkus.hibernate.orm.panache.PanacheRepository;  

@ApplicationScoped
public class PostRepository implements PanacheRepository<Post> {
}
