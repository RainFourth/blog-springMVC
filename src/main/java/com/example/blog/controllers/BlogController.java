package com.example.blog.controllers;

import com.example.blog.models.Post;
import com.example.blog.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/blog")
    public String blog(Model model) {
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "blog-main";
    }

    @GetMapping("/blog/add")
    public String blogAdd(Model model) {
        return "blog-add";
    }

    @PostMapping("/blog/add")
    public String blogPostAdd(@RequestParam String title, @RequestParam String announcement, @RequestParam String content, Model model) {
        Post post = new Post(title, announcement, content);
        postRepository.save(post);
        return "redirect:/blog";
    }

    @GetMapping("/blog/{id}")
    public String blogDetails(@PathVariable(value = "id") long id, Model model) {
        Optional<Post> opt = postRepository.findById(id);
        if (!opt.isPresent()) return "post-not-found";
        model.addAttribute("post", opt.get());
        return "blog-details";
    }

    @GetMapping("/blog/{id}/edit")
    public String blogEdit(@PathVariable(value = "id") long id, Model model) {
        Optional<Post> opt = postRepository.findById(id);
        if (!opt.isPresent()) return "post-not-found";
        model.addAttribute("post", opt.get());
        return "blog-edit";
    }

    @PostMapping("/blog/{id}/edit")
    public String blogPostUpdate(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String announcement, @RequestParam String content, Model model) {
        Optional<Post> opt = postRepository.findById(id);
        Post post = opt.orElse(new Post(id, title, announcement, content));
        post.setTitle(title);
        post.setAnnouncement(announcement);
        post.setContent(content);
        postRepository.save(post);
        return "redirect:/blog/{id}";
    }

    @PostMapping("/blog/{id}/remove")
    public String blogRemove(@PathVariable(value = "id") long id, Model model) {
        postRepository.deleteById(id);
        return "redirect:/blog";
    }
}
