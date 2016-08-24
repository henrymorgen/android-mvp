package com.example.liuwangshu.moonmvp.view.view;

import com.example.liuwangshu.moonmvp.model.bean.Article;
import com.example.liuwangshu.moonmvp.model.bean.ArticleInfo;

/**
 * Created by Administrator on 2016/8/24 0024.
 */
public interface ArticleView {
    void setArticleInfo(ArticleInfo articleInfo);
    void showLoading();
    void hideLoading();
    void showError();
}
