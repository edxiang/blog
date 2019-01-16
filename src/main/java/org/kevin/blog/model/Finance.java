package org.kevin.blog.model;

import java.util.Date;

public class Finance {
    private String id;

    private Double cost;

    private String forWhat;

    private String type;

    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getForWhat() {
        return forWhat;
    }

    public void setForWhat(String forWhat) {
        this.forWhat = forWhat == null ? null : forWhat.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}