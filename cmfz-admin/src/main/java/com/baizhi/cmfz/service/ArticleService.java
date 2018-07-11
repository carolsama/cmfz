package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Article;

import java.util.List;

/**
 * @Description 文章Service
 * @Author Administrator
 * @Time 2018/7/8 22:06
 */
public interface ArticleService {

    public int addArticle(Article article);

    public List<Article> queryAllArticleByPage(Integer pageIndex, Integer singleRows);

}
