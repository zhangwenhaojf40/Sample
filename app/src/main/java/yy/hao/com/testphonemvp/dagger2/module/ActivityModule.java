package yy.hao.com.testphonemvp.dagger2.module;

import dagger.Module;
import dagger.Provides;
import yy.hao.com.testphonemvp.R;
import yy.hao.com.testphonemvp.adapter.NewsAdapter;
import yy.hao.com.testphonemvp.dagger2.ActivityScope;

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
