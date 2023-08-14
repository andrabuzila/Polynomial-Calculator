import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TestAdunare {
    @Test
    public void Adunare(){
        Polinom p1 = new Polinom(new ArrayList());
        Polinom p2 = new Polinom(new ArrayList());
        Polinom p3 = new Polinom(new ArrayList());
        Polinom p4 = new Polinom(new ArrayList());
        Monom m1 = new Monom(7, 3.4);
        Monom m2 = new Monom(5,5.0);
        Monom m3 = new Monom(3, 1.4);
        Monom m5 = new Monom(0,9.0);
        Monom m11 = new Monom(7, 3.4);
        Monom m12 = new Monom(4,3.3);
        Monom m13 = new Monom(3, 2.0);
        p1.addMon(m1);
        p1.addMon(m2);
        p1.addMon(m3);
        p1.addMon(m5);
        p2.addMon(m11);
        p2.addMon(m12);
        p2.addMon(m13);
        Monom m111 = new Monom(7, 6.8);
        Monom m112 = new Monom(5,5.0);
        Monom m113 = new Monom(4, 3.3);
        Monom m114 = new Monom(3, 3.4);
        Monom m115 = new Monom(0, 9.0);
        p3.addMon(m115);
        p3.addMon(m114);
        p3.addMon(m113);
        p3.addMon(m112);
        p3.addMon(m111);
        p4 = p1.adunare(p2);
        for(Monom m: p3.getPolin()){
            for(Monom n: p4.getPolin()){
                if(m.getPutere() == n.getPutere()){
                    System.out.println(m.getCoeficient()+ " "+ n.getCoeficient());
                    assertTrue(m.getCoeficient() == n.getCoeficient());
                }
            }
        }




    }

}
