package security.myself.jwt20230725.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import security.myself.jwt20230725.model.UserAuth;

@Slf4j
public class CustomLoginFilter extends UsernamePasswordAuthenticationFilter 
{



    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            UserAuth                            userAuth                        = new ObjectMapper().readValue(request.getInputStream(), UserAuth.class);
            UsernamePasswordAuthenticationToken token                           = new UsernamePasswordAuthenticationToken(userAuth.getLoginId(), userAuth.getLoginPassword());
            return super.getAuthenticationManager().authenticate(token);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }    

        
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
            Authentication authResult) throws IOException, ServletException {
        
            log.info("login success!! ");
    }

    
    
}
