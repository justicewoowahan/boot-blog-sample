package com.woowahan.blog.entity;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createdDate = new Date();


    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    protected Date lastModifiedDate = new Date();

    protected boolean deleted = false;
    protected Member createdBy;
    protected Member lastModifiedBy;

    public void delete() {
        deleted = true;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Member getCreatedBy() {
        return createdBy;
    }

    public Member getLastModifiedBy() {
        return lastModifiedBy;
    }

    public BaseEntity amendModifier(Member member) {
        this.lastModifiedBy = member;
        this.lastModifiedDate = new Date();
        return this;
    }



}