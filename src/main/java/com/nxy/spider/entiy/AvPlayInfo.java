package com.nxy.spider.entiy;

import java.io.Serializable;

/**
 * bilibili 视频AV播放统计信息
 * Created by snailnan on 2016/9/27.
 */
public class AvPlayInfo implements Serializable{

    private static final long serialVersionUID = -7063292549251417562L;
    private Long avid;
    private Integer view;
    private Integer danmaku;
    private Integer reply;
    private Integer favorite;
    private Integer coin;
    private Integer share;
    private Integer now_rank;
    private Integer his_rank;
    private Long updatetime;

    public Long getAvid() {
        return avid;
    }

    public void setAvid(Long avid) {
        this.avid = avid;
    }

    public Integer getView() {
        return view;
    }

    public void setView(Integer view) {
        this.view = view;
    }

    public Integer getDanmaku() {
        return danmaku;
    }

    public void setDanmaku(Integer danmaku) {
        this.danmaku = danmaku;
    }

    public Integer getReply() {
        return reply;
    }

    public void setReply(Integer reply) {
        this.reply = reply;
    }

    public Integer getFavorite() {
        return favorite;
    }

    public void setFavorite(Integer favorite) {
        this.favorite = favorite;
    }

    public Integer getCoin() {
        return coin;
    }

    public void setCoin(Integer coin) {
        this.coin = coin;
    }

    public Integer getShare() {
        return share;
    }

    public void setShare(Integer share) {
        this.share = share;
    }

    public Integer getNow_rank() {
        return now_rank;
    }

    public void setNow_rank(Integer now_rank) {
        this.now_rank = now_rank;
    }

    public Integer getHis_rank() {
        return his_rank;
    }

    public void setHis_rank(Integer his_rank) {
        this.his_rank = his_rank;
    }

    public Long getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Long updatetime) {
        this.updatetime = updatetime;
    }

    @Override
    public String toString() {
        return "AvPlayInfo{" +
                "avid=" + avid +
                ", view=" + view +
                ", danmaku=" + danmaku +
                ", reply=" + reply +
                ", favorite=" + favorite +
                ", coin=" + coin +
                ", share=" + share +
                ", now_rank=" + now_rank +
                ", his_rank=" + his_rank +
                ", updatetime=" + updatetime +
                '}';
    }
}
