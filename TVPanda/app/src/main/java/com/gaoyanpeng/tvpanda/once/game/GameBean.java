package com.gaoyanpeng.tvpanda.once.game;

import com.google.gson.Gson;

import java.util.List;

/**游戏的 Bean
 * Created by 高研鹏 on 2016/12/17.
 */

public class GameBean {

    private int errno;
    private String errmsg;
    private String authseq;
    private List<DataBean> data;


    public static GameBean objectFromData(String str) {

        return new Gson().fromJson(str, GameBean.class);
    }

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getAuthseq() {
        return authseq;
    }

    public void setAuthseq(String authseq) {
        this.authseq = authseq;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String cname;
        private String ename;
        private String img;
        private String ext;
        private String status;

        public static DataBean objectFromData(String str) {

            return new Gson().fromJson(str, DataBean.class);
        }

        public String getCname() {
            return cname;
        }

        public void setCname(String cname) {
            this.cname = cname;
        }

        public String getEname() {
            return ename;
        }

        public void setEname(String ename) {
            this.ename = ename;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getExt() {
            return ext;
        }

        public void setExt(String ext) {
            this.ext = ext;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
