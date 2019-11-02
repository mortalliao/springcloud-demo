package win.mortalliao.auth.common.jwt;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author mortal
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
public class JwtClient implements Serializable, JwtInfo {

    private String id;
    private String clientId;
    private String name;

    @Override
    public String getUniqueName() {
        return clientId;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }
}
