package com.example.liuwangshu.moonmvp.presenter.impl;

import com.example.liuwangshu.moonmvp.model.bean.Article;
import com.example.liuwangshu.moonmvp.model.bean.ArticleInfo;
import com.example.liuwangshu.moonmvp.model.impl.ArticleModelImpl;
import com.example.liuwangshu.moonmvp.model.model.ArticleModel;
import com.example.liuwangshu.moonmvp.presenter.ArticlePresenter;
import com.example.liuwangshu.moonmvp.presenter.OnArticleListener;
import com.example.liuwangshu.moonmvp.view.view.ArticleView;

/**
 * Created by Administrator on 2016/8/24 0024.
 */
public class ArticlePresenterImpl implements ArticlePresenter,OnArticleListener {
    private ArticleView mArticleView;
    private ArticleModel mArticleModel;

    public ArticlePresenterImpl(ArticleView mArticleView){
        this.mArticleView=mArticleView;
        mArticleModel=new ArticleModelImpl();
    }
    @Override
    public void getArticle() {
        mArticleModel.getArtcle(this);
    }



    @Override
    public void onSuccess(ArticleInfo articleInfo) {
        mArticleView.setArticleInfo(articleInfo);
    }

    @Override
    public void onStart() {
        mArticleView.showLoading();
    }

    @Override
    public void onFailed() {
        mArticleView.showError();
    }

    @Override
    public void onFinish() {
        mArticleView.hideLoading();
    }
}
