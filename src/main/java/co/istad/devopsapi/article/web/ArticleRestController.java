package co.istad.devopsapi.article.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/articles")
public class ArticleRestController {
    @GetMapping
    List<ArticleDto> findAllArticles() {
        List<ArticleDto> articleDtoList = new ArrayList<>() {{
            add(new ArticleDto(1, "ABC"));
            add(new ArticleDto(2, "Anchor"));
        }};
        return articleDtoList;
    };
}
