package win.mortalliao.auth.client.util;

import org.junit.Test;
import win.mortalliao.auth.common.util.RsaKeyUtil;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * @author mortal
 */
public class RsaKeyUtilTest {
    @Test
    public void test(){
        RsaKeyUtil rsaKeyUtil = new RsaKeyUtil();
        try {
            RsaKeyUtil.generateKey("public.key", "private.key", "123");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

}
