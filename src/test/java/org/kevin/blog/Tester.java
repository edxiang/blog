package org.kevin.blog;

import org.junit.Test;
import org.kevin.blog.common.util.CommonUtils;

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
        System.out.println(CommonUtils.getUUID32());
    }
}
