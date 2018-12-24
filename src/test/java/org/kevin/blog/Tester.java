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
        String s = "有时觉得挺不正常的，像我这种年纪，读过“那么多”的书，不应该拿着勉强养活自己的工资，窝在几平方米的小房间里，让一个如此美好的、带有阳光的周末就这么被浪费。\n" +
                "但这就是现实，并没有什么道理可讲。至于道理用在这里合适不合适，就不清除了。";
        System.out.println(CommonUtils.getUUID32());
    }
}
