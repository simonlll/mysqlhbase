package com.imooc.bigdata.hos.model;

import java.util.Date;

/**
 * Created by simon on 2019/9/10.
 */
public class Hbasetransfer {
    private Integer id;

    private Integer applogid;

    private Date updatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Hbasetransfer(Integer id, Integer applogid, Date updatetime) {
        this.id = id;
        this.applogid = applogid;
        this.updatetime = updatetime;
    }

    public Hbasetransfer() {
    }

    public Integer getApplogid() {
        return applogid;
    }

    public void setApplogid(Integer applogid) {
        this.applogid = applogid;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    @Override
    public String toString() {
        return "Hbasetransfer{" +
                "id=" + id +
                ", applogid=" + applogid +
                ", updatetime=" + updatetime +
                '}';
    }
}
