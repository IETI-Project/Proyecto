package main.controller.auth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import main.exceptions.InvalidCredentialsException;
import main.model.User;
import main.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import static main.utils.Constants.CLAIMS_ROLES_KEY;
import static main.utils.Constants.TOKEN_DURATION_MINUTES;

@RestController
@RequestMapping( "v1/auth" )
public class AuthController
{

    @Value( "${app.secret}" )
    String secret;

    private final UserServices userService;

    public AuthController( @Autowired UserServices userService )
    {
        this.userService = userService;
    }

    @PostMapping
    public TokenDto login( @RequestBody LoginDto loginDto )
    {
        Optional<User> user = userService.findByEmail( loginDto.getEmail() );
        if ( BCrypt.checkpw( loginDto.password, user.get().getEncryptedPassword() ) )
        {
            return generateTokenDto( user );
        }
        else
        {
            throw new InvalidCredentialsException();
        }

    }

    private String generateToken(Optional<User> user, Date expirationDate )
    {
        return Jwts.builder()
                .setSubject( String.valueOf( user.get().getId()))
                .claim( CLAIMS_ROLES_KEY, user.get().getRoles() )
                .setIssuedAt(new Date() )
                .setExpiration( expirationDate )
                .signWith( SignatureAlgorithm.HS256, secret )
                .compact();
    }

    private TokenDto generateTokenDto(Optional<User> user )
    {
        Calendar expirationDate = Calendar.getInstance();
        expirationDate.add( Calendar.MINUTE, TOKEN_DURATION_MINUTES );
        String token = generateToken( user, expirationDate.getTime() );
        return new TokenDto( token, expirationDate.getTime() );
    }
}