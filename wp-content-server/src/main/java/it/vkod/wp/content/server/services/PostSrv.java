package it.vkod.wp.content.server.services;

import com.afrozaar.wordpress.wpapi.v2.Wordpress;
import com.afrozaar.wordpress.wpapi.v2.config.ClientConfig;
import com.afrozaar.wordpress.wpapi.v2.config.ClientFactory;
import com.afrozaar.wordpress.wpapi.v2.exception.PostCreateException;
import com.afrozaar.wordpress.wpapi.v2.exception.PostNotFoundException;
import com.afrozaar.wordpress.wpapi.v2.model.Post;
import com.afrozaar.wordpress.wpapi.v2.model.PostStatus;
import com.afrozaar.wordpress.wpapi.v2.request.Request;
import com.afrozaar.wordpress.wpapi.v2.request.SearchRequest;
import com.afrozaar.wordpress.wpapi.v2.response.PagedResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.afrozaar.wordpress.wpapi.v2.model.builder.ContentBuilder.aContent;
import static com.afrozaar.wordpress.wpapi.v2.model.builder.ExcerptBuilder.anExcerpt;
import static com.afrozaar.wordpress.wpapi.v2.model.builder.PostBuilder.aPost;
import static com.afrozaar.wordpress.wpapi.v2.model.builder.TitleBuilder.aTitle;

@Service
public class PostSrv {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostSrv.class);

    final String baseUrl = "http://localhost/pizzify";
    final String username = "woo";
    final String password = "woo";

    final Wordpress client = ClientFactory.fromConfig(ClientConfig.of(baseUrl, username, password, false, true));

    public List<Post> getPosts(final String keyword) {
        final PagedResponse<Post> response = client.search(SearchRequest.Builder.aSearchRequest(Post.class)
                .withUri(Request.POSTS)
                .withParam("filter[meta_key]", keyword)
                .withParam("filter[meta_compare]", "NOT EXISTS") //RestTemplate takes care of escaping values ('space' -> '%20')
                .build());

        return response.getList();
    }

    public Post getPostById(final long id) {
        Post post = null;
        try {
            post = client.getPost(id);
        } catch (PostNotFoundException e) {
            LOGGER.error(e.getMessage());
        }

        return post;
    }

    public void createPost(final String content, final String title, final String excerpt) {
        final Post newPost = aPost()
                .withContent(aContent().withRendered(content).build())
                .withTitle(aTitle().withRendered(title).build())
                .withExcerpt(anExcerpt().withRendered(excerpt).build()).build();

        try {
            client.createPost(newPost, PostStatus.publish);
        } catch (PostCreateException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
