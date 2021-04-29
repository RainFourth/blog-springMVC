package com.example.blog.repo;

import com.example.blog.models.Post;
import org.springframework.data.repository.CrudRepository;

//JPA’s JpaRepository, the domain type as Employee and the id type as Long
public interface PostRepository extends CrudRepository<Post, Long> {
}
