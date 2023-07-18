package com.format.result.model;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;



@MappedSuperclass
public abstract class BaseEntity 
{
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID            pid; 
    
    private Timestamp createdTime;

    private Timestamp updateTime;

    public UUID getPid() { return this.pid;}


    public BaseEntity()
    {
        this.createdTime = new Timestamp(System.currentTimeMillis());
        this.updateTime = new Timestamp(System.currentTimeMillis());

    }
}
