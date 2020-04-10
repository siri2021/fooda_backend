package it.vkod.wp.content.server.controllers;

import com.afrozaar.wordpress.wpapi.v2.model.Post;
import it.vkod.wp.content.server.models.PostRequest;
import it.vkod.wp.content.server.services.PostSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("wp/posts")
public class PostCtrl {

    @Autowired
    private PostSrv srv;

    @GetMapping
    public List<Post> apiGetPosts() {
        return srv.getPosts("fooda");
    }

    @GetMapping("{id}")
    public Post apiGetPostById(@PathVariable("id") final long id) {
        return srv.getPostById(id);
    }

    @PostMapping
    public void apiPostPost(@RequestBody PostRequest post) {
        // TODO fix this ..
        srv.createPost(post.getContent(), post.getTitle(), post.getExcerpt());
    }
}
