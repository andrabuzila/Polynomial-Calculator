import java.util.ArrayList;
import java.util.List;

public class Main {
        public static void main(String[] args) {

            // 3.4*x^7+5.0*x^5+1.4*x^3+9.0
            // 3.4*x^7+3.3*x^4+2.0*x^3

            //1.0*x^4-2.0*x^3+2.0*x^2-2.0*x^1+3.0
            //1.0*x^4-1.0*x^3

            Polinom p = new Polinom(new ArrayList());
            ClassView view = new ClassView(p);
            ClassController controller = new ClassController(view, p);
            view.setVisible(true);
        }

}
