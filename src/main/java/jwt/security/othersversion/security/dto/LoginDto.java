package jwt.security.othersversion.security.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto 
{
    private String loginId;
    private String password;    
}
