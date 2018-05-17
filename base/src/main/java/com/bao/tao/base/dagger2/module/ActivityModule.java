package com.bao.tao.base.dagger2.module;

import com.bao.tao.base.R;
import com.bao.tao.base.adapter.NewsAdapter;
import com.bao.tao.base.dagger2.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ZhangWenHao
 * on 2018/3/28 0028.
 */
@Module
public class ActivityModule {
    @ActivityScope
    @Provides
    NewsAdapter provideNewsAda() {
        return new NewsAdapter(R.layout.item_article);
    }
}
