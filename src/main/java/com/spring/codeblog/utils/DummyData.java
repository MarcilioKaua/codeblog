package com.spring.codeblog.utils;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.repository.CodeBlogRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DummyData {

    @Autowired
    CodeBlogRepository codeBlogRepository;

    //@PostConstruct
    public void savePosts(){

        List<Post> postList = new ArrayList<>();

        Post post1 = new Post();
        post1.setAutor("Marcilio");
        post1.setData(LocalDate.now());
        post1.setTitulo("Spring Boot");
        post1.setTexto("Spring boot framework de Java");

        Post post2 = new Post();
        post2.setAutor("Cleiton");
        post2.setData(LocalDate.now());
        post2.setTitulo("Hibernate");
        post2.setTexto("Conectar ao banco de dados Postgre");

        postList.add(post1);
        postList.add(post2);

        for(Post post : postList){
            Post postSaved = codeBlogRepository.save(post);
            System.out.println(postSaved.getId());
        }
    }
}
