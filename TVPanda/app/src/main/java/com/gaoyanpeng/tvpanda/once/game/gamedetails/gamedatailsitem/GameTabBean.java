package com.gaoyanpeng.tvpanda.once.game.gamedetails.gamedatailsitem;

import com.gaoyanpeng.tvpanda.R;

/**
 * Created by 裴亮 on 16/12/28.
 */

public class GameTabBean {
    private int[]pics = {R.drawable.chat_icon,R.drawable.level_icon,R.drawable.anchor_icon};
    private String[]titles = {"聊天","排行榜","主播"};

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
}
