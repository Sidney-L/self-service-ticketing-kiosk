  import java.text.DecimalFormat;  
  import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.SimpleDateFormat;
import java.util.Date;

public class test{
	public static void main (String args[]) {
 2          DateFormat df = new SimpleDateFormat("HH:mm");
 3          try {
 4              Date dt1 = df.parse("10:00");
 5              Date dt2 = df.parse("12:00");
 6              if (dt1.getTime() > dt2.getTime()) {
 7                  System.out.println("dt1 在dt2前");
 8                  return 1;
 9              } else if (dt1.getTime() < dt2.getTime()) {
10                  System.out.println("dt1在dt2后");
11                  return -1;
12              } else {
13                  return 0;
14              }
15          } catch (Exception exception) {
16              exception.printStackTrace();
17          }
18          return 0;
19      }
	}
}