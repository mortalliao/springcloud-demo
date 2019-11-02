package win.mortalliao.jwt.config.jwt;

import win.mortalliao.jwt.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mortalliao
 */
public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser(
                user.getUserId(),
                user.getUserCode(),
                user.getPasswor(),
                user.getEmail(),
                //mapToGrantedAuthorities(user.getRoles()),
                mapToGrantedAuthorities(new ArrayList<>()),
                //user.getLastPasswordResetDate()
                user.getUpdatedDt()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> authorities) {
        ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return grantedAuthorities;
        //return authorities.stream()
        //        .map(SimpleGrantedAuthority::new)
        //        .collect(Collectors.toList());
    }
}
