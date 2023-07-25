package security.myself.jwt20230725.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAuth extends BaseEntity implements UserDetails
{

    private String name;

    @Column(unique = true)
    private String loginId;

    private String loginPassword;

    private String userRole;

    public List<String>         userRoleList()
    {
        if( this.userRole.length() > 0 ) return Arrays.asList(this.userRole.split(","));
                                         return new ArrayList<>(); 
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() 
    {
        Collection<GrantedAuthority>            authList                    =   new ArrayList<>();
        userRoleList().forEach( r -> { authList.add(()->r); });
        return authList;

    }

    @Override
    public String getPassword() {
        return getLoginPassword();
    }

    @Override
    public String getUsername() {
        return getLoginId();
    }

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
