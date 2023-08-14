import java.text.DecimalFormat;
import java.util.*;

public class Polinom {
    private List<Monom> polin=new ArrayList();

    public Polinom(List<Monom> poli){ this.polin = poli; }

    public List<Monom> getPolin() { return polin; }

    public void setPolin(List<Monom> polin) { this.polin = polin; }

    public void addMon(Monom m){
            this.polin.add(m);}

    public Polinom adunare(Polinom p) {
        Polinom result = new Polinom(new ArrayList());
        List<Monom> toRemove1 = new ArrayList();
        Polinom egal = new Polinom(new ArrayList());
        for (Monom m1 : p.getPolin())
            for(Monom m2 : polin)
                if(m1.getPutere() == m2.getPutere()){
                Double coef = m1.getCoeficient() + m2.getCoeficient();
                Monom m = new Monom(m1.getPutere(), coef);
                egal.addMon(m);}

        for(Monom m1 : polin)
            result.getPolin().add(m1);
        for(Monom m2 : p.getPolin())
            result.getPolin().add(m2);

        for(Monom m1 : egal.getPolin())
            for(Monom m2: result.getPolin())
                if(m1.getPutere() == m2.getPutere())
                    toRemove1.add(m2);
        result.getPolin().removeAll(toRemove1);
        result.getPolin().addAll(egal.getPolin());
        Collections.sort(result.getPolin());
        return result;
    }

    public Polinom scadere(Polinom p) {
        Polinom result = new Polinom(new ArrayList());
        List<Monom> toRemove1 = new ArrayList(), toRemove2 = new ArrayList();
        Polinom egal = new Polinom(new ArrayList());
        for (Monom m1 : p.getPolin())
            for(Monom m2 : polin)
                if(m1.getPutere() == m2.getPutere()){
                    DecimalFormat df = new DecimalFormat("#.##");
                    Double coef = Double.valueOf(df.format(m2.getCoeficient() - m1.getCoeficient()));
                    Monom m = new Monom(m1.getPutere(), coef);
                    egal.addMon(m);
                    if(coef == 0.0)
                        toRemove1.add(m);}
        for(Monom m1 : polin)
            result.getPolin().add(m1);
        for(Monom m2 : p.getPolin()){
            Monom m3 = new Monom(m2.getPutere(),-m2.getCoeficient());
            result.getPolin().add(m3); }
        for(Monom m1 : egal.getPolin())
            for(Monom m2: result.getPolin())
                if(m1.getPutere() == m2.getPutere())
                    toRemove2.add(m2);
        result.getPolin().removeAll(toRemove2);
        result.getPolin().addAll(egal.getPolin());
        result.getPolin().removeAll(toRemove1);
        Collections.sort(result.getPolin());
        return result;
    }

    public List<Polinom> impartire(Polinom p){
        Polinom resultCat = new Polinom(new ArrayList());
        List<Polinom>  result = new ArrayList<Polinom>();
        Polinom p1 = new Polinom(new ArrayList());
        Polinom inmul = new Polinom(new ArrayList());
        Polinom rest = new Polinom(new ArrayList());
        rest = this;
        while(rest.getPolin().get(0).compareTo(p.getPolin().get(0))>=0){
            Monom mon = new Monom(rest.getPolin().get(0).getPutere()-p.getPolin().get(0).getPutere(), rest.getPolin().get(0).getCoeficient());
            resultCat.addMon(mon);
            p1.addMon(mon);
            inmul = p.inmultire(p1);
            p1.getPolin().remove(mon);
            rest=rest.scadere(inmul);
            Collections.sort(rest.getPolin(), Collections.reverseOrder());
        }
        Collections.sort(resultCat.getPolin());
        result.add(resultCat);
        Collections.sort(rest.getPolin());
        result.add(rest);
        return result;
    }

    public Polinom inmultire(Polinom p){
        int i=0,cnt[] = new int[100];
        DecimalFormat df = new DecimalFormat("#.##");
        Polinom result = new Polinom(new ArrayList());
        List<Monom> toRemove = new ArrayList();
        for(Monom m1:polin)
            for(Monom m2:p.getPolin()){
                Monom m3 = new Monom(m1.getPutere()+m2.getPutere(), Double.valueOf(df.format(m1.getCoeficient()*m2.getCoeficient())));
                result.addMon(m3);
            }
        for(Monom m1: result.getPolin()){
            for(Monom m2: result.getPolin()) {
                if (m1.getPutere() == m2.getPutere())
                    cnt[i]++;
                if (cnt[i] >= 2) {
                    m1.setCoeficient(Double.valueOf(df.format(m1.getCoeficient() + m2.getCoeficient())));
                    cnt[i]--;
                    toRemove.add(m2);
                }
            }
            i++;}
        result.getPolin().removeAll(toRemove);
        Collections.sort(result.getPolin());
        return result;
    }

    public Polinom derivare(){
        Polinom result = this;
        List<Monom> toRemove = new ArrayList();
        for(Monom m: result.getPolin()){
            DecimalFormat df = new DecimalFormat("#.##");
            m.setCoeficient(Double.valueOf(df.format(m.getCoeficient()*m.getPutere())));
            m.setPutere(m.getPutere()-1);
        }
        for(Monom m: result.getPolin()){
            if(m.getCoeficient() == 0.0){
                toRemove.add(m);
            }
        }
        result.getPolin().removeAll(toRemove);
        Collections.sort(result.getPolin());
        return result;
    }

    public Polinom integrare(){
        Polinom result = this;
        for(Monom m: result.getPolin()){
            DecimalFormat df = new DecimalFormat("#.##");
            m.setCoeficient(Double.valueOf(df.format(m.getCoeficient()/(m.getPutere()+1))));
            m.setPutere(m.getPutere()+1);
        }
        Collections.sort(result.getPolin());
        return result;
    }

    public String afisare(Polinom p){
        String s ="";
        for(Monom m : p.getPolin()){
            if(m.getCoeficient()>0){
            s=s+ "+"+m.getCoeficient()+"*x^"+m.getPutere()+"";}
            else
                s=s+ m.getCoeficient()+"*x^"+m.getPutere()+"";
            System.out.println(m.getCoeficient()+"*x^"+m.getPutere()+"");
        }
        System.out.println();
        return s;
    }
}
