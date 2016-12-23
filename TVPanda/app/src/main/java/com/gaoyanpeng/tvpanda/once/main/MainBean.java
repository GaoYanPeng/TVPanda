package com.gaoyanpeng.tvpanda.once.main;

import android.support.v4.app.Fragment;

import com.gaoyanpeng.tvpanda.R;
import com.gaoyanpeng.tvpanda.once.game.GameFm;
import com.gaoyanpeng.tvpanda.once.homepager.HomePagerFm;
import com.gaoyanpeng.tvpanda.once.live.LiveFm;
import com.gaoyanpeng.tvpanda.once.mine.MineFm;
import com.gaoyanpeng.tvpanda.once.shallot.ShallotFm;

import java.util.ArrayList;
import java.util.List;

/**
 * Main 的实体类  用来绑定 Fragment title 图片的
 * Created by 高研鹏 on 2016/12/17.
 */

public class MainBean {
    private String title;
    private int image;
    private Fragment f;

    public MainBean(String title, int image, Fragment f) {
        this.title = title;
        this.image = image;
        this.f = f;
    }

    public String getTitle() {
        return title;
    }

    public MainBean setTitle(String title) {
        this.title = title;
        return this;
    }

    public int getImage() {
        return image;
    }

    public MainBean setImage(int image) {
        this.image = image;
        return this;
    }

    public Fragment getF() {
        return f;
    }

    public MainBean setF(Fragment f) {
        this.f = f;
        return this;
    }

    //定义一个静态方法在适配器里调用这个方法 总而把 Fragment title image 全部练习在一起
    //这样就能在实体类中全部绑定了
    public static List<MainBean> getMainBean() {
        List<MainBean> mainBeen = new ArrayList<>();
        mainBeen.add(new MainBean("首页", R.drawable.home_selector, new HomePagerFm()));
        mainBeen.add(new MainBean("游戏", R.drawable.game_selector, new GameFm()));
        mainBeen.add(new MainBean("娱乐", R.drawable.live_selector, new LiveFm()));
        mainBeen.add(new MainBean("小葱秀", R.drawable.shallot_selector, new ShallotFm()));
        mainBeen.add(new MainBean("我的", R.drawable.user_selector, new MineFm()));
        return mainBeen;
    }
}
