package org.kevin.blog.common.util;

import java.util.UUID;

/**
 * @author Kevin.Z
 * @version 12/8/18
 */
public class CommonUtils {

    public static String getUUID32(){
        return UUID.randomUUID().toString().replace("-","").toLowerCase();
    }

    public static String replaceLineCharacter(String text) {
        return text.replaceAll("\\r\\n", "<br/>");
    }
}
