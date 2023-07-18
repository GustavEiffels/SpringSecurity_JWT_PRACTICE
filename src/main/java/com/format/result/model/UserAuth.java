package com.format.result.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class UserAuth extends BaseEntity
{
    private String userEmail;
    private String userPassword;
    private String userRole;

    public List<String>             getRoleList()
    {
        if( this.userRole.length() > 0) { return Arrays.asList(this.userRole.split(",")); }
                                          return new ArrayList<>(); 
    }
}
