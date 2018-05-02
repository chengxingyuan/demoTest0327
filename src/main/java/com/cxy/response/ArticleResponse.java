package com.cxy.response;

import com.cxy.model.Article;

import java.util.List;

/**
 * @author chengxy
 * @date 2018/4/28 15:25
 */
public class ArticleResponse extends BaseResponse{

    private Article article;

    private List<Article> articleList;

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }
}
