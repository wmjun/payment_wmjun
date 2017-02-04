package com.wmjun.payment.domain.common;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by wmjun on 2017. 1. 31..
 */
@MappedSuperclass
public class BaseEntity {

    @NotNull
    private Date createdAt;

    @NotNull
    private Date modifiedAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = new Date();
        this.modifiedAt = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        this.modifiedAt = new Date();
    }


}
