package org.kevin.blog.model;

import java.util.Date;

public class SecretMoment {
    private String id;

    private Date createTime;

    private String moment;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getMoment() {
        return moment;
    }

    public void setMoment(String moment) {
        this.moment = moment == null ? null : moment.trim();
    }
}