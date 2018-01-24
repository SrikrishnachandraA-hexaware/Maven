import com.sruthi.Subtraction;
import org.junit.Test;
public class TestSub{
        @Test
        public void TestSub(){    
         int a=10,b=9;
         Subtraction sub = new Subtraction();
         int res = sub.subtraction(a,b);
         System.out.println("------------------------------");
        System.out.println(res);
     }
}