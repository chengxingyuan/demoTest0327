package com.cxy.service.impl;

import com.cxy.mapper.ArticleMapper;
import com.cxy.model.Article;
import com.cxy.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chengxy
 * @date 2018/4/27 17:18
 */
@Service
public class ArticleServiceImpl implements IArticleService{
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public void saveArticle(Article article) {
        articleMapper.saveArticle(article);
    }

    @Override
    public List<Article> queryArticleByCollege(String collegeName) {
        return articleMapper.queryArticleByCollege(collegeName);
    }

    @Override
    public Article queryArticleDetailsById(Long id) {
        return articleMapper.queryArticleDetailsById(id);
    }
}
