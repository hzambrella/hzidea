package com.hz.research.model;

public class UserPwdChangeLog {
    private Integer logid;

    private Integer userid;

    private String pwdold;

    private String pwdnew;

    private String addtime;

    private String addwho;

    public Integer getLogid() {
        return logid;
    }

    public void setLogid(Integer logid) {
        this.logid = logid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getPwdold() {
        return pwdold;
    }

    public void setPwdold(String pwdold) {
        this.pwdold = pwdold == null ? null : pwdold.trim();
    }

    public String getPwdnew() {
        return pwdnew;
    }

    public void setPwdnew(String pwdnew) {
        this.pwdnew = pwdnew == null ? null : pwdnew.trim();
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }

    public String getAddwho() {
        return addwho;
    }

    public void setAddwho(String addwho) {
        this.addwho = addwho == null ? null : addwho.trim();
    }
}