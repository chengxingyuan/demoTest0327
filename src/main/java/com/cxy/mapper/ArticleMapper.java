package com.cxy.mapper;

import com.cxy.model.Article;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author chengxy
 * @date 2018/4/27 17:27
 */
@Component
public interface ArticleMapper {

    /**
     * 保存文章
     * @param article 文章
     * */
    void saveArticle(Article article);

    /**
     * 根据大学查询其下文章
     * @param collegeName 大学名
     * @return 文章集合
     * */
    List<Article> queryArticleByCollege(String collegeName);

    /**
     * 根据文章id查询文章详情
     * */
    Article queryArticleDetailsById(Long id);
}
