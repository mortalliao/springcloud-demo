package win.mortalliao.auth.common.util;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @author mortal
 */
public class RsaKeyUtil {
    private static RsaKeyUtil rsaKeyUtil = new RsaKeyUtil();

    /**
     * 获取公钥
     *
     * @param filename 文件名
     * @return PublicKey
     * @throws IOException              IO异常
     * @throws NoSuchAlgorithmException 无此算法
     * @throws InvalidKeySpecException  无效key
     */
    public static PublicKey getPublicKey(String filename) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        InputStream resourceAsStream = rsaKeyUtil.getClass().getClassLoader().getResourceAsStream(filename);
        DataInputStream dataInputStream = new DataInputStream(resourceAsStream);
        byte[] keyBytes = new byte[resourceAsStream.available()];
        dataInputStream.readFully(keyBytes);
        dataInputStream.close();
        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePublic(spec);
    }

    /**
     * 获取密钥
     *
     * @param filename 文件名
     * @return PrivateKey
     * @throws IOException              IO异常
     * @throws NoSuchAlgorithmException 无此算法
     * @throws InvalidKeySpecException  无效key
     */
    public static PrivateKey getPrivateKey(String filename) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        InputStream resourceAsStream = rsaKeyUtil.getClass().getClassLoader().getResourceAsStream(filename);
        DataInputStream dataInputStream = new DataInputStream(resourceAsStream);
        byte[] keyBytes = new byte[resourceAsStream.available()];
        dataInputStream.readFully(keyBytes);
        dataInputStream.close();
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(spec);
    }

    /**
     * 生成RSA公钥和密钥
     *
     * @param publicKeyFilename  公钥文件名
     * @param privateKeyFilename 私钥文件名
     * @param password           密码
     * @throws IOException              IO异常
     * @throws NoSuchAlgorithmException 无此算法
     */
    public static void generateKey(String publicKeyFilename, String privateKeyFilename, String password) throws IOException, NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        SecureRandom secureRandom = new SecureRandom(password.getBytes());
        keyPairGenerator.initialize(1024, secureRandom);
        KeyPair keyPair = keyPairGenerator.genKeyPair();
        // 生成公钥
        byte[] publicKeyBytes = keyPair.getPublic().getEncoded();
        FileOutputStream fos = new FileOutputStream(publicKeyFilename);
        fos.write(publicKeyBytes);
        fos.close();
        // 生成密钥
        byte[] privateKeyBytes = keyPair.getPrivate().getEncoded();
        fos = new FileOutputStream(privateKeyFilename);
        fos.write(privateKeyBytes);
        fos.close();
    }

}

