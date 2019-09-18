package com.imooc.bigdata.hos.model;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

/**
*
*  @author simon
*/
public class AppLog implements Serializable {

    private static final long serialVersionUID = 1568029121653L;


    /**
    * 主键
    * 
    * isNullAble:0
    */
    private Integer id;

    /**
    * 
    * isNullAble:1
    */
    private Date dt;

    /**
    * 
    * isNullAble:1
    */
    private String uid;

    /**
    * 
    * isNullAble:1
    */
    private String ip;

    /**
    * 
    * isNullAble:1
    */
    private String method;

    /**
    * 
    * isNullAble:1
    */
    private String url;

    /**
    * 
    * isNullAble:1
    */
    private String v;

    /**
    * 
    * isNullAble:1
    */
    private String ua;

    /**
    * 
    * isNullAble:1
    */
    private Integer aes;

    /**
    * 
    * isNullAble:1
    */
    private String res;

    /**
    * 
    * isNullAble:1
    */
    private String serverip;

    /**
    * 
    * isNullAble:1
    */
    private Integer reqtime;

    /**
    * 
    * isNullAble:1
    */
    private String status;


    public void setId(Integer id){this.id = id;}

    public Integer getId(){return this.id;}

    public void setDt(Date dt){this.dt = dt;}

    public Date getDt(){return this.dt;}

    public void setUid(String uid){this.uid = uid;}

    public String getUid(){return this.uid;}

    public void setIp(String ip){this.ip = ip;}

    public String getIp(){return this.ip;}

    public void setMethod(String method){this.method = method;}

    public String getMethod(){return this.method;}

    public void setUrl(String url){this.url = url;}

    public String getUrl(){return this.url;}

    public void setV(String v){this.v = v;}

    public String getV(){return this.v;}

    public void setUa(String ua){this.ua = ua;}

    public String getUa(){return this.ua;}

    public void setAes(Integer aes){this.aes = aes;}

    public Integer getAes(){return this.aes;}

    public void setRes(String res){this.res = res;}

    public String getRes(){return this.res;}

    public void setServerip(String serverip){this.serverip = serverip;}

    public String getServerip(){return this.serverip;}

    public void setReqtime(Integer reqtime){this.reqtime = reqtime;}

    public Integer getReqtime(){return this.reqtime;}

    public void setStatus(String status){this.status = status;}

    public String getStatus(){return this.status;}
    @Override
    public String toString() {
        return "AppLog{" +
                "id='" + id + '\'' +
                "dt='" + dt + '\'' +
                "uid='" + uid + '\'' +
                "ip='" + ip + '\'' +
                "method='" + method + '\'' +
                "url='" + url + '\'' +
                "v='" + v + '\'' +
                "ua='" + ua + '\'' +
                "aes='" + aes + '\'' +
                "res='" + res + '\'' +
                "serverip='" + serverip + '\'' +
                "reqtime='" + reqtime + '\'' +
                "status='" + status + '\'' +
            '}';
    }

    public AppLog(Integer id, Date dt, String uid, String ip, String method, String url, String v, String ua, Integer aes, String res, String serverip, Integer reqtime, String status) {
        this.id = id;
        this.dt = dt;
        this.uid = uid;
        this.ip = ip;
        this.method = method;
        this.url = url;
        this.v = v;
        this.ua = ua;
        this.aes = aes;
        this.res = res;
        this.serverip = serverip;
        this.reqtime = reqtime;
        this.status = status;
    }

    public AppLog() {
    }
}
