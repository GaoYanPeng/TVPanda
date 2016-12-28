package com.gaoyanpeng.tvpanda.once.game.gamedetails.gamedatailsitem;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by 高研鹏 on 2016/12/28.
 */

public class GameItemBean {

    private int errno;
    private String errmsg;
    private DataBean data;
    private String authseq;

    public static GameItemBean objectFromData(String str) {

        return new Gson().fromJson(str, GameItemBean.class);
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
        private InfoBean info;

        public static DataBean objectFromData(String str) {

            return new Gson().fromJson(str, DataBean.class);
        }

        public InfoBean getInfo() {
            return info;
        }

        public void setInfo(InfoBean info) {
            this.info = info;
        }

        public static class InfoBean {
            private HostinfoBean hostinfo;
            private RoominfoBean roominfo;
            private HostinfoBean userinfo;
            private VideoinfoBean videoinfo;

            public static InfoBean objectFromData(String str) {

                return new Gson().fromJson(str, InfoBean.class);
            }

            public HostinfoBean getHostinfo() {
                return hostinfo;
            }

            public void setHostinfo(HostinfoBean hostinfo) {
                this.hostinfo = hostinfo;
            }

            public RoominfoBean getRoominfo() {
                return roominfo;
            }

            public void setRoominfo(RoominfoBean roominfo) {
                this.roominfo = roominfo;
            }

            public HostinfoBean getUserinfo() {
                return userinfo;
            }

            public void setUserinfo(HostinfoBean userinfo) {
                this.userinfo = userinfo;
            }

            public VideoinfoBean getVideoinfo() {
                return videoinfo;
            }

            public void setVideoinfo(VideoinfoBean videoinfo) {
                this.videoinfo = videoinfo;
            }

            public static class HostinfoBean {
                private int rid;
                private String name;
                private String avatar;
                private String bamboos;

                public static HostinfoBean objectFromData(String str) {

                    return new Gson().fromJson(str, HostinfoBean.class);
                }

                public int getRid() {
                    return rid;
                }

                public void setRid(int rid) {
                    this.rid = rid;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getAvatar() {
                    return avatar;
                }

                public void setAvatar(String avatar) {
                    this.avatar = avatar;
                }

                public String getBamboos() {
                    return bamboos;
                }

                public void setBamboos(String bamboos) {
                    this.bamboos = bamboos;
                }
            }

            public static class RoominfoBean {
                private String id;
                private String name;
                private String type;
                private String classification;
                private String cate;
                private String bulletin;
                private String details;
                private String person_num;
                private String fans;
                private PicturesBean pictures;
                private String display_type;
                private String start_time;
                private String end_time;
                private String room_type;
                private String style_type;
                private String remind_content;
                private String remind_time;
                private String remind_status;

                public static RoominfoBean objectFromData(String str) {

                    return new Gson().fromJson(str, RoominfoBean.class);
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getClassification() {
                    return classification;
                }

                public void setClassification(String classification) {
                    this.classification = classification;
                }

                public String getCate() {
                    return cate;
                }

                public void setCate(String cate) {
                    this.cate = cate;
                }

                public String getBulletin() {
                    return bulletin;
                }

                public void setBulletin(String bulletin) {
                    this.bulletin = bulletin;
                }

                public String getDetails() {
                    return details;
                }

                public void setDetails(String details) {
                    this.details = details;
                }

                public String getPerson_num() {
                    return person_num;
                }

                public void setPerson_num(String person_num) {
                    this.person_num = person_num;
                }

                public String getFans() {
                    return fans;
                }

                public void setFans(String fans) {
                    this.fans = fans;
                }

                public PicturesBean getPictures() {
                    return pictures;
                }

                public void setPictures(PicturesBean pictures) {
                    this.pictures = pictures;
                }

                public String getDisplay_type() {
                    return display_type;
                }

                public void setDisplay_type(String display_type) {
                    this.display_type = display_type;
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

                public String getRoom_type() {
                    return room_type;
                }

                public void setRoom_type(String room_type) {
                    this.room_type = room_type;
                }

                public String getStyle_type() {
                    return style_type;
                }

                public void setStyle_type(String style_type) {
                    this.style_type = style_type;
                }

                public String getRemind_content() {
                    return remind_content;
                }

                public void setRemind_content(String remind_content) {
                    this.remind_content = remind_content;
                }

                public String getRemind_time() {
                    return remind_time;
                }

                public void setRemind_time(String remind_time) {
                    this.remind_time = remind_time;
                }

                public String getRemind_status() {
                    return remind_status;
                }

                public void setRemind_status(String remind_status) {
                    this.remind_status = remind_status;
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
            }

            public static class VideoinfoBean {
                private String name;
                private String time;
                private StreamAddrBean stream_addr;
                private String room_key;
                private String plflag;
                private String status;
                private String sign;
                private String ts;
                private int hardware;
                private String scheme;
                private String watermark;
                private List<String> slaveflag;

                public static VideoinfoBean objectFromData(String str) {

                    return new Gson().fromJson(str, VideoinfoBean.class);
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getTime() {
                    return time;
                }

                public void setTime(String time) {
                    this.time = time;
                }

                public StreamAddrBean getStream_addr() {
                    return stream_addr;
                }

                public void setStream_addr(StreamAddrBean stream_addr) {
                    this.stream_addr = stream_addr;
                }

                public String getRoom_key() {
                    return room_key;
                }

                public void setRoom_key(String room_key) {
                    this.room_key = room_key;
                }

                public String getPlflag() {
                    return plflag;
                }

                public void setPlflag(String plflag) {
                    this.plflag = plflag;
                }

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

                public String getSign() {
                    return sign;
                }

                public void setSign(String sign) {
                    this.sign = sign;
                }

                public String getTs() {
                    return ts;
                }

                public void setTs(String ts) {
                    this.ts = ts;
                }

                public int getHardware() {
                    return hardware;
                }

                public void setHardware(int hardware) {
                    this.hardware = hardware;
                }

                public String getScheme() {
                    return scheme;
                }

                public void setScheme(String scheme) {
                    this.scheme = scheme;
                }

                public String getWatermark() {
                    return watermark;
                }

                public void setWatermark(String watermark) {
                    this.watermark = watermark;
                }

                public List<String> getSlaveflag() {
                    return slaveflag;
                }

                public void setSlaveflag(List<String> slaveflag) {
                    this.slaveflag = slaveflag;
                }

                public static class StreamAddrBean {
                    private String HD;
                    private String OD;
                    private String SD;

                    public static StreamAddrBean objectFromData(String str) {

                        return new Gson().fromJson(str, StreamAddrBean.class);
                    }

                    public String getHD() {
                        return HD;
                    }

                    public void setHD(String HD) {
                        this.HD = HD;
                    }

                    public String getOD() {
                        return OD;
                    }

                    public void setOD(String OD) {
                        this.OD = OD;
                    }

                    public String getSD() {
                        return SD;
                    }

                    public void setSD(String SD) {
                        this.SD = SD;
                    }
                }
            }
        }
    }
}
