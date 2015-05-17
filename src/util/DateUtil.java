package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author lhries
 */
public class DateUtil {
    public static boolean verificaData(String data)
    {
       return(data.matches("\\d{2}/\\d{2}/\\d{4}"));
    }

    public static boolean verificaDataHora(String data)
    {
       return(data.matches("\\d{2}/\\d{2}/\\d{4} \\d{2}:\\d{2}"));
    }
    
    public static Date stringToDate(String data) throws ParseException
    {
        return(new SimpleDateFormat("dd/MM/yyyy").parse(data));
    }

    public static Date stringToDateHour(String data) throws ParseException
    {
        return(new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(data));
    }
    
    public static String dateToString(Date data){
        return(new SimpleDateFormat("dd/MM/yyyy").format(data));
    }

    public static String dateHourToString(Date data){
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String dataString = formatador.format(data);
        return(dataString);
    }
    
    public static Date addDays(Date atual, int days)
    {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(atual);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        return(calendar.getTime());
    }
    
    public static long differenceInDays(Date start, Date end)
    {
        long dif = end.getTime() - start.getTime();
        return(Math.abs(dif/(24*60*60*1000)));
    }
    

    
    public static void main(String args[]) throws ParseException{
        String dataString = Console.scanString("Digite a data:");
        if(verificaData(dataString))
        {
            Date data = stringToDate(dataString);
            Date dataMaisCinco = addDays(data, 5);
            System.out.println(dateToString(dataMaisCinco));
            System.out.println(DateUtil.differenceInDays(dataMaisCinco,data));
        }
        else
            System.out.println("Data inválida");
    }
}
