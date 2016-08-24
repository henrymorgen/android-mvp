package com.example.liuwangshu.moonmvp.view.activity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.liuwangshu.moonmvp.R;
import com.example.liuwangshu.moonmvp.model.bean.ArticleInfo;
import com.example.liuwangshu.moonmvp.presenter.ArticlePresenter;
import com.example.liuwangshu.moonmvp.presenter.impl.ArticlePresenterImpl;
import com.example.liuwangshu.moonmvp.view.view.ArticleView;

import java.util.List;

public class MainActivity extends BaseActivity implements ArticleView{
    private Button bt_getarticle;
    private TextView tv_article_title;
    private TextView tv_article_othertitle;
    private ArticlePresenter mArticlePresenter;
     private Dialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {

        mArticlePresenter=new ArticlePresenterImpl(this);
        mDialog=new ProgressDialog(this);
        mDialog.setTitle("获取数据中");
        bt_getarticle = findView(R.id.bt_getarticle);
        tv_article_title = findView(R.id.tv_article_title);
        tv_article_othertitle = findView(R.id.tv_article_othertitle);
        bt_getarticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mArticlePresenter.getArticle();
            }
        });
    }


    @Override
    public void setArticleInfo(ArticleInfo articleInfo) {
        if(null!=articleInfo) {
            List<ArticleInfo.detail> list = articleInfo.getDetail();
            if(null!=list&&list.size()>0)
            tv_article_title.setText(list.get(0).getTitle());
            tv_article_othertitle.setText(list.get(1).getTitle());
        }

    }

    @Override
    public void showLoading() {
        mDialog.show();
    }

    @Override
    public void hideLoading() {
        if(mDialog.isShowing()) {
            mDialog.dismiss();
        }
    }

    @Override
    public void showError() {
        Toast.makeText(getApplicationContext(),"网络出错",Toast.LENGTH_SHORT).show();
    }

}
