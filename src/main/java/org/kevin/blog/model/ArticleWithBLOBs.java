package org.kevin.blog.model;

public class ArticleWithBLOBs extends Article {
    private String foreword;

    private String content;

    public String getForeword() {
        return foreword;
    }

    public void setForeword(String foreword) {
        this.foreword = foreword == null ? null : foreword.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}