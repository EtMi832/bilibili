package com.nxy.spider.entiy;

import java.io.Serializable;

/**
 * bilibili 视频AV播放统计信息
 * Created by snailnan on 2016/9/27.
 */
public class AvPlayInfo implements Serializable{

    private static final long serialVersionUID = -7063292549251417562L;
    private int view;
    private int danmaku;
    private int reply;
    private int favorite;
    private int coin;
    private int share;
    private int now_rank;
    private int his_rank;

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public int getDanmaku() {
        return danmaku;
    }

    public void setDanmaku(int danmaku) {
        this.danmaku = danmaku;
    }

    public int getReply() {
        return reply;
    }

    public void setReply(int reply) {
        this.reply = reply;
    }

    public int getFavorite() {
        return favorite;
    }

    public void setFavorite(int favorite) {
        this.favorite = favorite;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public int getShare() {
        return share;
    }

    public void setShare(int share) {
        this.share = share;
    }

    public int getNow_rank() {
        return now_rank;
    }

    public void setNow_rank(int now_rank) {
        this.now_rank = now_rank;
    }

    public int getHis_rank() {
        return his_rank;
    }

    public void setHis_rank(int his_rank) {
        this.his_rank = his_rank;
    }

    @Override
    public String toString() {
        return "AvPlayInfo{" +
                "view=" + view +
                ", danmaku=" + danmaku +
                ", reply=" + reply +
                ", favorite=" + favorite +
                ", coin=" + coin +
                ", share=" + share +
                ", now_rank=" + now_rank +
                ", his_rank=" + his_rank +
                '}';
    }
}
