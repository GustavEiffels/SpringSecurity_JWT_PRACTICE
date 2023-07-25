package jwt.security.othersversion.security.filter;

import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
import jwt.security.othersversion.security.dto.LoginDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@AllArgsConstructor
@Slf4j
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter
{
    public CustomAuthenticationFilter(AuthenticationManager authenticationManager) 
    { super.setAuthenticationManager(authenticationManager); }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException 
    {
        final UsernamePasswordAuthenticationToken authToken;
        final LoginDto                            dto;

        try 
        {
            dto = new ObjectMapper().readValue( request.getInputStream(), LoginDto.class );
            
            log.info(" login Dto Value : {}",dto);
            
            authToken = new UsernamePasswordAuthenticationToken( dto.getLoginId(), dto.getPassword() );
        } 
            catch (Exception e) 
        {
            log.error("Error Emereget = {}", e.getMessage() );
            throw new RuntimeException("GET TOKE FAIL");
        }
        setDetails(request, authToken);

        
        return this.getAuthenticationManager().authenticate(authToken);
    }

    
}
