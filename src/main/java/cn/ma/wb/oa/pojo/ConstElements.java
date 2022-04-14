package cn.ma.wb.oa.pojo;

import org.springframework.context.annotation.Configuration;
import java.util.HashMap;
import java.util.Map;

@Configuration
public interface ConstElements {

    String MEMBERSHIP_UNKNOWN = "UNKNOWN";
    String SEX_UNKNOWN = "UNKNOWN";

    int SALT_ENCRYPT_COUNT = 3;
    String CHARSET_ALPHA="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    Map<String, Integer> MEMBERSHIP = new HashMap<>(){{
        put("STUDENT", 0);
        put("TEACHER", 1);
        put("LEADER", 2);
        put("ADMIN", 3);
    }};
    Map<String, Integer> SEX = new HashMap<>(){{
        put("MALE", 0);
        put("FEMALE", 1);
    }};
}
