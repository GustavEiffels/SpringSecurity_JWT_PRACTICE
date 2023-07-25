package security.myself.jwt20230725.controller;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class JoinDto 
{
    private String id;
    private String password;   
}
