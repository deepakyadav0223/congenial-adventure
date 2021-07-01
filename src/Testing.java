import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Testing {

	public static void main(String[] args) {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        Date date = new Date();
//        String todate = dateFormat.format(date);
//        System.out.println(todate);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 14);
        Date todate1 = cal.getTime();    
        String fromdate = dateFormat.format(todate1);
        System.out.println(fromdate);

	}

}
