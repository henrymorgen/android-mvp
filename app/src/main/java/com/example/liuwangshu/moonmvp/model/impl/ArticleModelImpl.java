package com.example.liuwangshu.moonmvp.model.impl;

import com.example.liuwangshu.moonmvp.model.bean.ArticleInfo;
import com.example.liuwangshu.moonmvp.model.model.ArticleModel;
import com.example.liuwangshu.moonmvp.presenter.OnArticleListener;

import cn.finalteam.okhttpfinal.BaseHttpRequestCallback;
import cn.finalteam.okhttpfinal.HttpRequest;

/**
 * Created by Administrator on 2016/8/24 0024.
 */
public class ArticleModelImpl implements ArticleModel {
    @Override
    public void getArtcle(final OnArticleListener onArticleListener) {
        HttpRequest.post("http://api.1-blog.com/biz/bizserver/article/list.do",new BaseHttpRequestCallback<ArticleInfo>(){
            @Override
            protected void onSuccess(ArticleInfo articleInfo) {
                super.onStart();
                onArticleListener.onSuccess(articleInfo);
            }

            @Override
            public void onStart() {
                super.onStart();
                onArticleListener.onStart();
            }

            @Override
            public void onFailure(int errorCode, String msg) {
                super.onFailure(errorCode, msg);
                onArticleListener.onFailed();
            }

            @Override
            public void onFinish() {
                super.onFinish();
                onArticleListener.onFinish();
            }

        });

    }
}
