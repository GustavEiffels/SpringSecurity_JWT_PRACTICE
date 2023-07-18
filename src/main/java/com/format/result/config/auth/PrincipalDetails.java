package com.format.result.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.format.result.model.UserAuth;


public class PrincipalDetails implements UserDetails
{

    private UserAuth user;
    public PrincipalDetails(UserAuth user)  { this.user = user; }
    public UserAuth getUserAuth()           { return this.user;      }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() 
    {    
        Collection<GrantedAuthority>        authorities             = new ArrayList<>();
        user.getRoleList().forEach(r->{ authorities.add(()->r); });
        return authorities;
    }

    @Override
    public String getPassword() { return user.getUserPassword(); }

    @Override
    public String getUsername() { return user.getUserEmail();    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
       return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
    
}
