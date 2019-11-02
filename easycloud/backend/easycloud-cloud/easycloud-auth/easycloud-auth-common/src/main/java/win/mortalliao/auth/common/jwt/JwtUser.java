package win.mortalliao.auth.common.jwt;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author mortal
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
public class JwtUser implements Serializable, JwtInfo {

    private String username;
    private String userId;
    private String name;

    @Override
    public String getUniqueName() {
        return username;
    }

    @Override
    public String getId() {
        return userId;
    }

    @Override
    public String getName() {
        return name;
    }
}
