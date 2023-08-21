package cn.gxnu.util;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JsonURL_formater {
    /**
     * 抒两个字符串时间段内的每一天进行串联处理，并进行格式化
     * @param b 开始时间，如 20200320
     * @param e 结束时间，如 20200419
     * @param tn 手机号，如 13001293555
     * @return 处理后的url参数字符串，如
     * http://36.110.54.251:8098/loadhbase?keys=20200318-13001293555,20200319-13001293555,20200320-13001293555中的
     * ?keys=20200318-13001293555,20200319-13001293555,20200320-13001293555
     */
    public static String format(String b,String e,String tn){
        StringBuffer sb = new StringBuffer("");
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        Date bb = null;
        Date ee = null;
        try {
            bb = df.parse(b);
            ee = df.parse(e);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(bb);

        sb.append((parse(c.getTime())));
        sb.append("-");
        sb.append(tn);
        while(ee.after(c.getTime())){
            c.add(Calendar.DAY_OF_MONTH,1);
            sb.append(",");
            sb.append(parse(c.getTime()));
            sb.append("-");
            sb.append(tn);
        }
        return sb.toString();
    }

    private static String parse(Date date){
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        return  df.format(date);
    }

    public static void main(String[] args) throws ParseException {
        String ret = JsonURL_formater.format("20200318", "20200418","13001293555");
        System.out.println(ret);
    }
}
