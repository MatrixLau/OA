package cn.ma.wb.oa.util;

import cn.ma.wb.oa.pojo.ConstElements;
import org.apache.commons.lang3.RandomStringUtils;

public class SaltUtils {

    public static String getSalt(){
        return RandomStringUtils.random(ConstElements.SALT_ENCRYPT_COUNT, ConstElements.CHARSET_ALPHA);
    }

    public static String saltEncrypt(String password, String salt){
        String[] saltArr = salt.split("");
        for(int i = 0; i < saltArr.length; i++){
            password = password + saltArr[i];
            password = MsgDigestUtils.encodeSHA256(password);
        }
        return password;
    }

}
