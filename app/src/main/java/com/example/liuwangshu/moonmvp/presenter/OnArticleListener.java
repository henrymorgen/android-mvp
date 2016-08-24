package com.example.liuwangshu.moonmvp.presenter;

import com.example.liuwangshu.moonmvp.model.bean.ArticleInfo;

/**
 * Created by Administrator on 2016/8/24 0024.
 */
public interface OnArticleListener {
    void onSuccess(ArticleInfo articleInfo);
    void onStart();
    void onFailed();
    void onFinish();
}
