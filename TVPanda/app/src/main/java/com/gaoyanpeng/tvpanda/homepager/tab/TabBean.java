package com.gaoyanpeng.tvpanda.homepager.tab;


import com.gaoyanpeng.tvpanda.R;

/**
 * Created by 裴亮 on 16/12/21.
 */

public class TabBean {
    // 图标
    private int[] pics = {R.drawable.recommend_icon, R.drawable.all_live_icon,R.drawable.lol_icon,
    R.drawable.panda_star_show_icon,R.drawable.hearthstone_icon,R.drawable.overwatch_icon,
    R.drawable.outdoor_live_icon};
    // 标题
    private String[] titles = {"精彩推荐","全部直播","英雄联盟","熊猫星秀","炉石传说","守望先锋","户外直播"};
    // 拼接所需字段
    private String[]enames = {"recommend","live","lol","yzdr","hearthstone"
            ,"overwatch","hwzb"};

    public int[] getPics() {
        return pics;
    }

    public void setPics(int[] pics) {
        this.pics = pics;
    }

    public String[] getTitles() {
        return titles;
    }

    public void setTitles(String[] titles) {
        this.titles = titles;
    }

    public String[] getEnames() {
        return enames;
    }

    public void setEnames(String[] enames) {
        this.enames = enames;
    }
}
