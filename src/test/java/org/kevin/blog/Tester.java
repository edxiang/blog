package org.kevin.blog;

import org.junit.Test;
import org.kevin.blog.common.util.CommonUtils;
import org.springframework.util.DigestUtils;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Kevin.Z
 * @version 12/3/18
 */
public class Tester {
    @Test
    public void tester(){
        System.out.println("this is the first to run in SpringBoot 2.layer.layer");
    }

    @Test
    public void testUUID(){
        List<String> list = new ArrayList<>();
        System.out.println(list.size());
    }

    @Test // works
    public void testMD5(){
        String x = DigestUtils.md5DigestAsHex("value".getBytes());
        System.out.println(x);
    }

    @Test
    public void testDate(){
        String dateStr = "2019-01-31";
        Date d = CommonUtils.getDateEnd(dateStr);
        System.out.println(d);
    }
}
