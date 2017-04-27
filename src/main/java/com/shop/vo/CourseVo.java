package com.shop.vo;

/**
 * Created by youngtree on 2017/4/20.
 */
public class CourseVo {
    private Long c_id;
    private String c_title;
    private String c_post;
    private String c_excerpt;

    public CourseVo(Long c_id, String c_title, String c_post, String c_excerpt) {
        this.c_id = c_id;
        this.c_title = c_title;
        this.c_post = c_post;
        this.c_excerpt = c_excerpt;
    }

    public Long getC_id() {
        return c_id;
    }

    public void setC_id(Long c_id) {
        this.c_id = c_id;
    }

    public String getC_title() {
        return c_title;
    }

    public void setC_title(String c_title) {
        this.c_title = c_title;
    }

    public String getC_post() {
        return c_post;
    }

    public void setC_post(String c_post) {
        this.c_post = c_post;
    }

    public String getC_excerpt() {
        return c_excerpt;
    }

    public void setC_excerpt(String c_excerpt) {
        this.c_excerpt = c_excerpt;
    }
}
