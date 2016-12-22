package com.gaoyanpeng.tvpanda.api;

/**
 * Created by 高研鹏 on 2016/12/17.
 */

public class Api {
    /**
     * 游戏
     */
    public static  final String CAME = " http://api.m.panda.tv/index.php?method=category.list&type=game&__version=2.1.3.1585&__plat=android";
    /**
     * 小葱秀
     */
    public static final String SMALL = "http://cong.panda.tv/?psrc=pc_web-baidu-search_cong";

    // 首页:
    // 精彩推荐
    public static final String RECOMMEND_URL = "http://api.m.panda.tv/ajax_get_live_list_by_multicate?pagenum=4&hotroom=1&sproom=1&__version=2.1.3.1585&__plat=android";
    // 精彩推荐:轮播图
    public static final String RECOMMEND_BANNER_URL = "http://api.m.panda.tv/ajax_rmd_ads_get?__version=2.1.3.1585&__plat=android";

    // 全部直播
    public static final String ALL_LIVE_URL ="http://api.m.panda.tv/ajax_live_lists?pageno=1&pagenum=20&status=2&order=person_num&sproom=1&__version=2.1.3.1585&__plat=android&banner=1";
    // 全部直播 上拉加载上部分
    public static final String ALL_LIVE_HEAD_URL = "http://api.m.panda.tv/ajax_live_lists?pageno=";
    // 全部直播 上拉加载下部分
    public static final String ALL_LIVE_FOOT_URL = "&pagenum=20&status=2&order=person_num&sproom=1&__version=2.1.3.1585&__plat=android&banner=1";

    // 复用
    // 拼接前半部分
    public static final String HOME_REUSE_HEAD_URL = "http://api.m.panda.tv/ajax_get_live_list_by_cate?cate=";
    // 拼接后半部分
    public static final String HOME_REUSE_FOOT_URL = "&pageno=1&pagenum=20&sproom=1&__version=2.1.3.1585&__plat=android&banner=1";
    // 复用上拉加载页数
    public static final String HOME_REUSE_PAGE_URL = "&pageno=";
    // 复用上拉加载后半部分
    public static final String HOME_REUSE_PAGE_LOAD_URL = "&pagenum=20&sproom=1&__version=2.1.3.1585&__plat=android&banner=1";

}
