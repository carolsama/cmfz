package com.baizhi.cmfz.service;

import com.baizhi.cmfz.dao.ArticleDao;
import com.baizhi.cmfz.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description 文章serviceimpl
 * @Author Administrator
 * @Time 2018/7/8 22:08
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService{

   @Autowired
   private ArticleDao articleDao;

    @Override
    public int addArticle(Article article) {

        return articleDao.insertArticle(article);
    }

    @Override
    public List<Article> queryAllArticleByPage(Integer pageIndex, Integer singleRows) {
        return articleDao.selectArticleByPage((pageIndex-1)*singleRows,singleRows);
    }

}
