package com.format.result.model;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class UserAuth extends BaseEntity
{
    private String userEmail;
    private String userPassword;
}
