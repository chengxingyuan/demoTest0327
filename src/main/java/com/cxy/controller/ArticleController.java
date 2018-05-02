package com.cxy.controller;

import com.cxy.base.BaseController;
import com.cxy.common.ResponseCodes;
import com.cxy.model.Article;
import com.cxy.response.ArticleResponse;
import com.cxy.response.BaseResponse;
import com.cxy.service.IArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author chengxy
 * @date 2018/4/27 17:01
 */
@RestController
@RequestMapping("article")
public class ArticleController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(ArticleController.class);

    private ArticleResponse response = new ArticleResponse();

    @Autowired
    private IArticleService articleService;

    /**
     * 用户发表文章，保存文章
     */
    @PostMapping("/publishArticle")
    public BaseResponse publishArticle(@RequestBody Article article) {
        if (null == article) {
            return getNotNullResponse();
        }
        Date date = new Date();
        article.setCreateTime(date);
        article.setLastUpdateTime(date);
        articleService.saveArticle(article);

        return getSuccessResponse();
    }

    /**
     * 根据高校查其下的文章
     */
    @GetMapping("queryArticleByCollege")
    public BaseResponse queryArticleByCollege(String collegeName) {
        ArticleResponse response = new ArticleResponse();
        if (null == collegeName) {
            return getNotNullResponse();
        }
        logger.info("所要查询的大学是{}",collegeName);
        List<Article> articles = articleService.queryArticleByCollege(collegeName);
        if (articles == null || articles.size() < 1){
            return resultIsNullResponse();
        }
        response.setArticleList(articles);
        response.setCode(ResponseCodes.SUCCESS.getCode());
        response.setMessage(ResponseCodes.SUCCESS.getMessage());
        return  response;
    }

    /**
     * 根据文章id查询文章详情
     * */
    @GetMapping("queryArticleDetails")
    public BaseResponse queryArticleDetails(Long id){
        if (id == null){
            return getNotNullResponse();
        }
        Article article = articleService.queryArticleDetailsById(id);
        if (article == null){
            return resultIsNullResponse();
        }
        response.setArticle(article);
        response.setCode(ResponseCodes.SUCCESS.getCode());
        response.setMessage(ResponseCodes.SUCCESS.getMessage());
        return response;
    }

    /**
     * 根据文章id删除文章
     * */
    @GetMapping("deleteArticle")
    public BaseResponse deleteArticle(){
        //获取当前登录用户
        return response;
    }

}
