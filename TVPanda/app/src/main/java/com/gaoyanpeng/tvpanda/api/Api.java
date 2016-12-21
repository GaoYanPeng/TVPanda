package com.gaoyanpeng.tvpanda.api;

/**
 * Created by 高研鹏 on 2016/12/17.
 */

public class Api {
    /**
     * 游戏
     */
    public static  final String CAME = " http://api.m.panda.tv/index.php?method=category.list&type=game&__version=2.1.3.1585&__plat=android";
    /**拼接是用 Bean ename
     * 游戏点击二级界面前部分
     */
    public static final String CAME_FRONT = "http://api.m.panda.tv/ajax_get_live_list_by_cate?cate=";
    /**
     * 游戏点击二级界面后部分
     */
    public static final String CAME_BACK = "&pageno=1&pagenum=20&sproom=1&__version=2.1.3.1585&__plat=android";


    /**
     * 小葱秀
     */
    public static final String SMALL = "http://cong.panda.tv/?psrc=pc_web-baidu-search_cong";
}
