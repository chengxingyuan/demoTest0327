package com.cxy.service;

import com.cxy.model.Article;

import java.util.List;

/**
 * @author chengxy
 * @date 2018/4/27 17:18
 */
public interface IArticleService {

    /**
     * 保存文章
     * */
    void saveArticle(Article article);

    List<Article> queryArticleByCollege(String collegeName);

    Article queryArticleDetailsById(Long id);
}
