package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description 文章dao
 * @Author Administrator
 * @Time 2018/7/8 21:54
 */
public interface ArticleDao {

    public int insertArticle(Article article);

    public List<Article> selectArticleByPage(@Param("begin")Integer begin,@Param("end")Integer end);


}
