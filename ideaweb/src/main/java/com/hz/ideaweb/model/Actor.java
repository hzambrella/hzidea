package com.hz.ideaweb.model;

import java.util.Date;

public class Actor {
    private Short actorId;

    private String irstNameV;

    private String lastNameV;

    private Date lastUpdate;

    private String descrip;

    public Short getActorId() {
        return actorId;
    }

    public void setActorId(Short actorId) {
        this.actorId = actorId;
    }

    public String getIrstNameV() {
        return irstNameV;
    }

    public void setIrstNameV(String irstNameV) {
        this.irstNameV = irstNameV == null ? null : irstNameV.trim();
    }

    public String getLastNameV() {
        return lastNameV;
    }

    public void setLastNameV(String lastNameV) {
        this.lastNameV = lastNameV == null ? null : lastNameV.trim();
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip == null ? null : descrip.trim();
    }
}