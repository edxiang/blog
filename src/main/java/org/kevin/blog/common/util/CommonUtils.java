package org.kevin.blog.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
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
        return text.replaceAll("[\\r\\n]", "<br/>");
    }

    public static Date getDate(String dateStr){
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.parse(dateStr);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
