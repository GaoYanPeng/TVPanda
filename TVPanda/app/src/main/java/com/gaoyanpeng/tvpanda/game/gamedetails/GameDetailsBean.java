package com.gaoyanpeng.tvpanda.game.gamedetails;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by 高研鹏 on 2016/12/20.
 */

public class GameDetailsBean {

    private int errno;
    private String errmsg;
    private DataBean data;
    private String authseq;

    public static GameDetailsBean objectFromData(String str) {

        return new Gson().fromJson(str, GameDetailsBean.class);
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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getAuthseq() {
        return authseq;
    }

    public void setAuthseq(String authseq) {
        this.authseq = authseq;
    }

    public static class DataBean {
        private String total;
        private TypeBean type;
        private List<ItemsBean> items;

        public static DataBean objectFromData(String str) {

            return new Gson().fromJson(str, DataBean.class);
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public TypeBean getType() {
            return type;
        }

        public void setType(TypeBean type) {
            this.type = type;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class TypeBean {
            private String ename;
            private String cname;

            public static TypeBean objectFromData(String str) {

                return new Gson().fromJson(str, TypeBean.class);
            }

            public String getEname() {
                return ename;
            }

            public void setEname(String ename) {
                this.ename = ename;
            }

            public String getCname() {
                return cname;
            }

            public void setCname(String cname) {
                this.cname = cname;
            }
        }

        public static class ItemsBean {
            private String id;
            private String ver;
            private String createtime;
            private String updatetime;
            private String name;
            private String hostid;
            private String person_num;
            private String announcement;
            private TypeBean classification;
            private PicturesBean pictures;
            private String status;
            private String start_time;
            private String end_time;
            private String duration;
            private String schedule;
            private String remind_switch;
            private String remind_content;
            private String level;
            private String stream_status;
            private String classify_switch;
            private String reliable;
            private String banned_reason;
            private String unlock_time;
            private String speak_interval;
            private String person_num_thres;
            private String reduce_ratio;
            private String person_switch;
            private String watermark_switch;
            private String watermark_loc;
            private String account_status;
            private String person_src;
            private String display_type;
            private String tag;
            private String tag_switch;
            private String tag_color;
            private String rcmd_ratio;
            private String show_pos;
            private String rtype_usable;
            private String room_type;
            private String rtype_value;
            private String style_type;
            private String room_key;
            private String fans;
            private UserinfoBean userinfo;

            public static ItemsBean objectFromData(String str) {

                return new Gson().fromJson(str, ItemsBean.class);
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getVer() {
                return ver;
            }

            public void setVer(String ver) {
                this.ver = ver;
            }

            public String getCreatetime() {
                return createtime;
            }

            public void setCreatetime(String createtime) {
                this.createtime = createtime;
            }

            public String getUpdatetime() {
                return updatetime;
            }

            public void setUpdatetime(String updatetime) {
                this.updatetime = updatetime;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getHostid() {
                return hostid;
            }

            public void setHostid(String hostid) {
                this.hostid = hostid;
            }

            public String getPerson_num() {
                return person_num;
            }

            public void setPerson_num(String person_num) {
                this.person_num = person_num;
            }

            public String getAnnouncement() {
                return announcement;
            }

            public void setAnnouncement(String announcement) {
                this.announcement = announcement;
            }

            public TypeBean getClassification() {
                return classification;
            }

            public void setClassification(TypeBean classification) {
                this.classification = classification;
            }

            public PicturesBean getPictures() {
                return pictures;
            }

            public void setPictures(PicturesBean pictures) {
                this.pictures = pictures;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getStart_time() {
                return start_time;
            }

            public void setStart_time(String start_time) {
                this.start_time = start_time;
            }

            public String getEnd_time() {
                return end_time;
            }

            public void setEnd_time(String end_time) {
                this.end_time = end_time;
            }

            public String getDuration() {
                return duration;
            }

            public void setDuration(String duration) {
                this.duration = duration;
            }

            public String getSchedule() {
                return schedule;
            }

            public void setSchedule(String schedule) {
                this.schedule = schedule;
            }

            public String getRemind_switch() {
                return remind_switch;
            }

            public void setRemind_switch(String remind_switch) {
                this.remind_switch = remind_switch;
            }

            public String getRemind_content() {
                return remind_content;
            }

            public void setRemind_content(String remind_content) {
                this.remind_content = remind_content;
            }

            public String getLevel() {
                return level;
            }

            public void setLevel(String level) {
                this.level = level;
            }

            public String getStream_status() {
                return stream_status;
            }

            public void setStream_status(String stream_status) {
                this.stream_status = stream_status;
            }

            public String getClassify_switch() {
                return classify_switch;
            }

            public void setClassify_switch(String classify_switch) {
                this.classify_switch = classify_switch;
            }

            public String getReliable() {
                return reliable;
            }

            public void setReliable(String reliable) {
                this.reliable = reliable;
            }

            public String getBanned_reason() {
                return banned_reason;
            }

            public void setBanned_reason(String banned_reason) {
                this.banned_reason = banned_reason;
            }

            public String getUnlock_time() {
                return unlock_time;
            }

            public void setUnlock_time(String unlock_time) {
                this.unlock_time = unlock_time;
            }

            public String getSpeak_interval() {
                return speak_interval;
            }

            public void setSpeak_interval(String speak_interval) {
                this.speak_interval = speak_interval;
            }

            public String getPerson_num_thres() {
                return person_num_thres;
            }

            public void setPerson_num_thres(String person_num_thres) {
                this.person_num_thres = person_num_thres;
            }

            public String getReduce_ratio() {
                return reduce_ratio;
            }

            public void setReduce_ratio(String reduce_ratio) {
                this.reduce_ratio = reduce_ratio;
            }

            public String getPerson_switch() {
                return person_switch;
            }

            public void setPerson_switch(String person_switch) {
                this.person_switch = person_switch;
            }

            public String getWatermark_switch() {
                return watermark_switch;
            }

            public void setWatermark_switch(String watermark_switch) {
                this.watermark_switch = watermark_switch;
            }

            public String getWatermark_loc() {
                return watermark_loc;
            }

            public void setWatermark_loc(String watermark_loc) {
                this.watermark_loc = watermark_loc;
            }

            public String getAccount_status() {
                return account_status;
            }

            public void setAccount_status(String account_status) {
                this.account_status = account_status;
            }

            public String getPerson_src() {
                return person_src;
            }

            public void setPerson_src(String person_src) {
                this.person_src = person_src;
            }

            public String getDisplay_type() {
                return display_type;
            }

            public void setDisplay_type(String display_type) {
                this.display_type = display_type;
            }

            public String getTag() {
                return tag;
            }

            public void setTag(String tag) {
                this.tag = tag;
            }

            public String getTag_switch() {
                return tag_switch;
            }

            public void setTag_switch(String tag_switch) {
                this.tag_switch = tag_switch;
            }

            public String getTag_color() {
                return tag_color;
            }

            public void setTag_color(String tag_color) {
                this.tag_color = tag_color;
            }

            public String getRcmd_ratio() {
                return rcmd_ratio;
            }

            public void setRcmd_ratio(String rcmd_ratio) {
                this.rcmd_ratio = rcmd_ratio;
            }

            public String getShow_pos() {
                return show_pos;
            }

            public void setShow_pos(String show_pos) {
                this.show_pos = show_pos;
            }

            public String getRtype_usable() {
                return rtype_usable;
            }

            public void setRtype_usable(String rtype_usable) {
                this.rtype_usable = rtype_usable;
            }

            public String getRoom_type() {
                return room_type;
            }

            public void setRoom_type(String room_type) {
                this.room_type = room_type;
            }

            public String getRtype_value() {
                return rtype_value;
            }

            public void setRtype_value(String rtype_value) {
                this.rtype_value = rtype_value;
            }

            public String getStyle_type() {
                return style_type;
            }

            public void setStyle_type(String style_type) {
                this.style_type = style_type;
            }

            public String getRoom_key() {
                return room_key;
            }

            public void setRoom_key(String room_key) {
                this.room_key = room_key;
            }

            public String getFans() {
                return fans;
            }

            public void setFans(String fans) {
                this.fans = fans;
            }

            public UserinfoBean getUserinfo() {
                return userinfo;
            }

            public void setUserinfo(UserinfoBean userinfo) {
                this.userinfo = userinfo;
            }

            public static class PicturesBean {
                private String img;

                public static PicturesBean objectFromData(String str) {

                    return new Gson().fromJson(str, PicturesBean.class);
                }

                public String getImg() {
                    return img;
                }

                public void setImg(String img) {
                    this.img = img;
                }
            }

            public static class UserinfoBean {
                private String nickName;
                private int rid;
                private String avatar;
                private String userName;

                public static UserinfoBean objectFromData(String str) {

                    return new Gson().fromJson(str, UserinfoBean.class);
                }

                public String getNickName() {
                    return nickName;
                }

                public void setNickName(String nickName) {
                    this.nickName = nickName;
                }

                public int getRid() {
                    return rid;
                }

                public void setRid(int rid) {
                    this.rid = rid;
                }

                public String getAvatar() {
                    return avatar;
                }

                public void setAvatar(String avatar) {
                    this.avatar = avatar;
                }

                public String getUserName() {
                    return userName;
                }

                public void setUserName(String userName) {
                    this.userName = userName;
                }
            }
        }
    }
}
