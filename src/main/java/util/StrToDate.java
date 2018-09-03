package util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StrToDate {
    /**
     * 字符串转换成日期
     * @param str
     * @return date
     */
    public static Date StringToDate(String str) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
