package com.hedou.vo;

import com.hedou.entity.Comment;
import com.hedou.entity.User;

import java.sql.Timestamp;

/**
 * Created by deru on 2017/4/19.
 */
public class CommentVo {


    private Long comId;
    private Long UId;
    private Long PId;
    private String comContent;
    private Timestamp comCreateTime;
    private User user;

    // Constructors

    /**
     * default constructor
     */
    public CommentVo() {
    }

    /**
     * full constructor
     */
    public CommentVo(Long UId, Long PId, String comContent,
                     Timestamp comCreateTime, User user) {
        this.UId = UId;
        this.PId = PId;
        this.comContent = comContent;
        this.comCreateTime = comCreateTime;
        this.user = user;
    }

    // Property accessors
    public Long getComId() {
        return this.comId;
    }

    public void setComId(Long comId) {
        this.comId = comId;
    }

    public Long getUId() {
        return this.UId;
    }

    public void setUId(Long UId) {
        this.UId = UId;
    }

    public Long getPId() {
        return this.PId;
    }

    public void setPId(Long PId) {
        this.PId = PId;
    }

    public String getComContent() {
        return this.comContent;
    }

    public void setComContent(String comContent) {
        this.comContent = comContent;
    }

    public Timestamp getComCreateTime() {
        return this.comCreateTime;
    }

    public void setComCreateTime(Timestamp comCreateTime) {
        this.comCreateTime = comCreateTime;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static CommentVo ConvertFromComment(Comment comment){
        return new CommentVo(comment.getUId(),comment.getPId(),comment.getComContent(),comment.getComCreateTime(),new User());
    }
}
