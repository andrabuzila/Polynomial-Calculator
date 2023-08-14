import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassController {
    private ClassView classview;
    private Polinom polin;

    ClassController(ClassView view, Polinom p){

        classview = view;
        polin = p;
        classview.addSumListener(new AfisareDate1());
        classview.addDifListener(new AfisareDate2());
        classview.addImpListener(new AfisareDate3());
        classview.addOriListener(new AfisareDate4());
        classview.addDerivListener(new AfisareDate5());
        classview.addIntegrListener(new AfisareDate6());
        classview.addClearListener(new ClearListener());


    }



    class AfisareDate1 implements ActionListener{

        public Double[] citireCoeficienti(String user1Input ) throws Exception {
            Double[] sir = new Double[100];
            int j1=0,b1=0,a1=0;
            Double[] coeficienti1 = new Double[100];
            Pattern p1 = Pattern.compile("-?\\d+(\\.\\d+)?");
            Matcher m1 = p1.matcher(user1Input);
            if((user1Input.matches("-?\\d+(\\.\\d+)?")|| (user1Input.matches("-?\\d+(\\.\\d+)?\\*x\\^.*") && user1Input.matches("[^a-w]+") && user1Input.contains("x") && user1Input.matches("[^A-Z]+") && !user1Input.contains("y") && !user1Input.contains("z"))))
            {
                while(m1.find()){
                    sir[j1]=Double.parseDouble(m1.group());
                    j1++; }
                int[] numbers1 =new int[j1];
                while(b1<j1){
                    numbers1[b1]=b1;
                    b1++; }
                for(int i: numbers1){
                    if(i%2==0){
                        coeficienti1[a1]=sir[i];
                        a1++; }}
            return coeficienti1;}
            else
                throw new Exception("DidntRespectTheRequirementsException");
        }

        public Integer[] citirePuteri(String user1Input ) throws Exception {
            Double[] sir1 = new Double[100];
            int j1=0,b1=0,a1=0,put1=0,cnt1=0;
            Integer[] puteri1 = new Integer[100];
            Pattern p1 = Pattern.compile("-?\\d+(\\.\\d+)?");
            Matcher m1 = p1.matcher(user1Input);
            if((user1Input.matches("-?\\d+(\\.\\d+)?")|| (user1Input.matches("-?\\d+(\\.\\d+)?\\*x\\^.*") && user1Input.matches("[^a-w]+") && user1Input.contains("x") && user1Input.matches("[^A-Z]+") && !user1Input.contains("y") && !user1Input.contains("z"))))
            {   while(m1.find()){
                    sir1[j1]=Double.parseDouble(m1.group());
                    j1++; }
                int[] numbers1 =new int[j1];
                while(b1<j1){
                    numbers1[b1]=b1;
                    b1++; }
                for(int i: numbers1){
                    if(i%2==1){
                        puteri1[a1]=sir1[i].intValue();
                        a1++; }}
                int[] puteri = new int[a1];
                while(put1<a1-1){
                     puteri[put1]=put1;
                    put1++; }
                for(int i1: puteri){
                    if(puteri1[i1+1]!=null)
                        if(puteri1[i1]<puteri1[i1+1])
                            cnt1++;
                    else return puteri1;}
                if(cnt1==0) return puteri1;
                else throw new Exception("DidntRespectTheRequirementsException"); }
            else throw new Exception("DidntRespectTheRequirementsException"); }

        public Polinom addToPolinom(Double[] coeficienti, Integer[] puteri){
            int i=0;
            Polinom p = new Polinom(new ArrayList());

                while(puteri[i]!=null){
                    Monom mon = new Monom(puteri[i],coeficienti[i]);
                    p.addMon(mon);
                    i++;
                }if(coeficienti[i]!=null){
                Monom mon = new Monom(0,coeficienti[i]);
                p.addMon(mon);}
            return p;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String user1Input;
            String user2Input;
            try {
                Double[] coeficienti1 = new Double[100];
                Integer[] puteri1 = new Integer[100];
                Polinom polin1 = new Polinom(new ArrayList());
                Polinom polin2 = new Polinom(new ArrayList());
                Double[] coeficienti2 = new Double[100];
                Integer[] puteri2 = new Integer[100];
                user1Input = classview.getUser1Input();
                user2Input = classview.getUser2Input();
                coeficienti1 = citireCoeficienti(user1Input);
                puteri1 = citirePuteri(user1Input);
                polin1 = addToPolinom(coeficienti1,puteri1);
                coeficienti2 = citireCoeficienti(user2Input);
                puteri2 = citirePuteri(user2Input);
                polin2 = addToPolinom(coeficienti2,puteri2);
                Polinom result = new Polinom(new ArrayList());
                result=polin1.adunare(polin2);
                classview.setResult1(result.afisare(result));
            } catch (Exception numberFormatException) {
                numberFormatException.printStackTrace(); }
        }
    }

    class AfisareDate2 implements ActionListener{

        public Double[] citireCoeficienti(String user1Input ) throws Exception {
            Double[] sir1 = new Double[100];
            int j1=0,b1=0,a1=0;
            Double[] coeficienti1 = new Double[100];
            Pattern p1 = Pattern.compile("-?\\d+(\\.\\d+)?");
            Matcher m1 = p1.matcher(user1Input);
            if((user1Input.matches("-?\\d+(\\.\\d+)?")|| (user1Input.matches("-?\\d+(\\.\\d+)?\\*x\\^.*") && user1Input.matches("[^a-w]+") && user1Input.contains("x") && user1Input.matches("[^A-Z]+") && !user1Input.contains("y") && !user1Input.contains("z"))))
            {
                while(m1.find()){
                    sir1[j1]=Double.parseDouble(m1.group());
                    j1++; }
                int[] numbers1 =new int[j1];
                while(b1<j1){
                    numbers1[b1]=b1;
                    b1++; }
                for(int i: numbers1){
                    if(i%2==0){
                        coeficienti1[a1]=sir1[i];
                        a1++; }}
                return coeficienti1;}
            else
                throw new Exception("DidntRespectTheRequirementsException");
        }

        public Integer[] citirePuteri(String user1Input ) throws Exception {
            Double[] sir1 = new Double[100];
            int j1=0,b1=0,a1=0,put1=0,cnt1=0;
            Integer[] puteri1 = new Integer[100];
            Pattern p1 = Pattern.compile("-?\\d+(\\.\\d+)?");
            Matcher m1 = p1.matcher(user1Input);
            if((user1Input.matches("-?\\d+(\\.\\d+)?")|| (user1Input.matches("-?\\d+(\\.\\d+)?\\*x\\^.*") && user1Input.matches("[^a-w]+") && user1Input.contains("x") && user1Input.matches("[^A-Z]+") && !user1Input.contains("y") && !user1Input.contains("z"))))
            {   while(m1.find()){
                sir1[j1]=Double.parseDouble(m1.group());
                j1++; }
                int[] numbers1 =new int[j1];
                while(b1<j1){
                    numbers1[b1]=b1;
                    b1++; }
                for(int i: numbers1){
                    if(i%2==1){
                        puteri1[a1]=sir1[i].intValue();
                        a1++; }}
                int[] puteri = new int[a1];
                while(put1<a1-1){
                    puteri[put1]=put1;
                    put1++; }
                for(int i1: puteri){
                    if(puteri1[i1+1]!=null)
                        if(puteri1[i1]<puteri1[i1+1])
                            cnt1++;
                        else return puteri1;}
                if(cnt1==0) return puteri1;
                else throw new Exception("DidntRespectTheRequirementsException"); }
            else throw new Exception("DidntRespectTheRequirementsException"); }

        public Polinom addToPolinom(Double[] coeficienti, Integer[] puteri){
            int i=0;
            Polinom p = new Polinom(new ArrayList());

            while(puteri[i]!=null){
                Monom mon = new Monom(puteri[i],coeficienti[i]);
                p.addMon(mon);
                i++;
            }if(coeficienti[i]!=null){
                Monom mon = new Monom(0,coeficienti[i]);
                p.addMon(mon);}
            return p;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String user1Input;
            String user2Input;
            try {
                Double[] coeficienti1 = new Double[100];
                Integer[] puteri1 = new Integer[100];
                Polinom polin1 = new Polinom(new ArrayList());
                Polinom polin2 = new Polinom(new ArrayList());
                Double[] coeficienti2 = new Double[100];
                Integer[] puteri2 = new Integer[100];
                user1Input = classview.getUser1Input();
                user2Input = classview.getUser2Input();
                coeficienti1 = citireCoeficienti(user1Input);
                puteri1 = citirePuteri(user1Input);
                polin1 = addToPolinom(coeficienti1,puteri1);
                coeficienti2 = citireCoeficienti(user2Input);
                puteri2 = citirePuteri(user2Input);
                polin2 = addToPolinom(coeficienti2,puteri2);
                Polinom result = new Polinom(new ArrayList());
                result=polin1.scadere(polin2);
                classview.setResult1(result.afisare(result));
            } catch (Exception numberFormatException) {
                numberFormatException.printStackTrace();
            }
        }
    }

    //1.0*x^4-2.0*x^3+2.0*x^2-2.0*x^1+3.0
    //1.0*x^1-1.0
    class AfisareDate3 implements ActionListener{

        public Double[] citireCoeficienti(String user1Input ) throws Exception {
            Double[] sir1 = new Double[100];
            int j1=0,b1=0,a1=0;
            Double[] coeficienti1 = new Double[100];
            Pattern p1 = Pattern.compile("-?\\d+(\\.\\d+)?");
            Matcher m1 = p1.matcher(user1Input);
            if((user1Input.matches("-?\\d+(\\.\\d+)?")|| (user1Input.matches("-?\\d+(\\.\\d+)?\\*x\\^.*") && user1Input.matches("[^a-w]+") && user1Input.contains("x") && user1Input.matches("[^A-Z]+") && !user1Input.contains("y") && !user1Input.contains("z"))))
            {
                while(m1.find()){
                    sir1[j1]=Double.parseDouble(m1.group());
                    j1++; }
                int[] numbers1 =new int[j1];
                while(b1<j1){
                    numbers1[b1]=b1;
                    b1++; }
                for(int i: numbers1){
                    if(i%2==0){
                        coeficienti1[a1]=sir1[i];
                        a1++; }}
                return coeficienti1;}
            else
                throw new Exception("DidntRespectTheRequirementsException");
        }

        public Integer[] citirePuteri(String user1Input ) throws Exception {
            Double[] sir1 = new Double[100];
            int j1=0,b1=0,a1=0,put1=0,cnt1=0;
            Integer[] puteri1 = new Integer[100];
            Pattern p1 = Pattern.compile("-?\\d+(\\.\\d+)?");
            Matcher m1 = p1.matcher(user1Input);
            if((user1Input.matches("-?\\d+(\\.\\d+)?")|| (user1Input.matches("-?\\d+(\\.\\d+)?\\*x\\^.*") && user1Input.matches("[^a-w]+") && user1Input.contains("x") && user1Input.matches("[^A-Z]+") && !user1Input.contains("y") && !user1Input.contains("z"))))
            {   while(m1.find()){
                sir1[j1]=Double.parseDouble(m1.group());
                j1++; }
                int[] numbers1 =new int[j1];
                while(b1<j1){
                    numbers1[b1]=b1;
                    b1++; }
                for(int i: numbers1){
                    if(i%2==1){
                        puteri1[a1]=sir1[i].intValue();
                        a1++; }}
                int[] puteri = new int[a1];
                while(put1<a1-1){
                    puteri[put1]=put1;
                    put1++; }
                for(int i1: puteri){
                    if(puteri1[i1+1]!=null)
                        if(puteri1[i1]<puteri1[i1+1])
                            cnt1++;
                        else return puteri1;}
                if(cnt1==0) return puteri1;
                else throw new Exception("DidntRespectTheRequirementsException"); }
            else throw new Exception("DidntRespectTheRequirementsException"); }

        public Polinom addToPolinom(Double[] coeficienti, Integer[] puteri){
            int i=0;
            Polinom p = new Polinom(new ArrayList());

            while(puteri[i]!=null){
                Monom mon = new Monom(puteri[i],coeficienti[i]);
                p.addMon(mon);
                i++;
            }if(coeficienti[i]!=null){
                Monom mon = new Monom(0,coeficienti[i]);
                p.addMon(mon);}
            return p;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String user1Input;
            String user2Input;
            try {
                Double[] coeficienti1 = new Double[100];
                Integer[] puteri1 = new Integer[100];
                Polinom polin1 = new Polinom(new ArrayList());
                Polinom polin2 = new Polinom(new ArrayList());
                Double[] coeficienti2 = new Double[100];
                Integer[] puteri2 = new Integer[100];
                user1Input = classview.getUser1Input();
                user2Input = classview.getUser2Input();
                coeficienti1 = citireCoeficienti(user1Input);
                puteri1 = citirePuteri(user1Input);
                polin1 = addToPolinom(coeficienti1,puteri1);
                coeficienti2 = citireCoeficienti(user2Input);
                puteri2 = citirePuteri(user2Input);
                polin2 = addToPolinom(coeficienti2,puteri2);
                List<Polinom> result = new ArrayList<Polinom>();
                result=polin1.impartire(polin2);
                classview.setResult1(result.get(0).afisare(result.get(0)));
                classview.setResult2(result.get(1).afisare(result.get(1)));
            } catch (Exception numberFormatException) {
                numberFormatException.printStackTrace();
            }
        }
    }


    // 3.0*x^4+1.0*x^3+2.0*x^2
    // 4.0*x^3-1.0*x^2+1.0*x^1

    class AfisareDate4 implements ActionListener{

        public Double[] citireCoeficienti(String user1Input ) throws Exception {
            Double[] sir1 = new Double[100];
            int j1=0,b1=0,a1=0;
            Double[] coeficienti1 = new Double[100];
            Pattern p1 = Pattern.compile("-?\\d+(\\.\\d+)?");
            Matcher m1 = p1.matcher(user1Input);
            if((user1Input.matches("-?\\d+(\\.\\d+)?")|| (user1Input.matches("-?\\d+(\\.\\d+)?\\*x\\^.*") && user1Input.matches("[^a-w]+") && user1Input.contains("x") && user1Input.matches("[^A-Z]+") && !user1Input.contains("y") && !user1Input.contains("z"))))
            {
                while(m1.find()){
                    sir1[j1]=Double.parseDouble(m1.group());
                    j1++; }
                int[] numbers1 =new int[j1];
                while(b1<j1){
                    numbers1[b1]=b1;
                    b1++; }
                for(int i: numbers1){
                    if(i%2==0){
                        coeficienti1[a1]=sir1[i];
                        a1++; }}
                return coeficienti1;}
            else
                throw new Exception("DidntRespectTheRequirementsException");
        }

        public Integer[] citirePuteri(String user1Input ) throws Exception {
            Double[] sir1 = new Double[100];
            int j1=0,b1=0,a1=0,put1=0,cnt1=0;
            Integer[] puteri1 = new Integer[100];
            Pattern p1 = Pattern.compile("-?\\d+(\\.\\d+)?");
            Matcher m1 = p1.matcher(user1Input);
            if((user1Input.matches("-?\\d+(\\.\\d+)?")|| (user1Input.matches("-?\\d+(\\.\\d+)?\\*x\\^.*") && user1Input.matches("[^a-w]+") && user1Input.contains("x") && user1Input.matches("[^A-Z]+") && !user1Input.contains("y") && !user1Input.contains("z"))))
            {   while(m1.find()){
                sir1[j1]=Double.parseDouble(m1.group());
                j1++; }
                int[] numbers1 =new int[j1];
                while(b1<j1){
                    numbers1[b1]=b1;
                    b1++; }
                for(int i: numbers1){
                    if(i%2==1){
                        puteri1[a1]=sir1[i].intValue();
                        a1++; }}
                int[] puteri = new int[a1];
                while(put1<a1-1){
                    puteri[put1]=put1;
                    put1++; }
                for(int i1: puteri){
                    if(puteri1[i1+1]!=null)
                        if(puteri1[i1]<puteri1[i1+1])
                            cnt1++;
                        else return puteri1;}
                if(cnt1==0) return puteri1;
                else throw new Exception("DidntRespectTheRequirementsException"); }
            else throw new Exception("DidntRespectTheRequirementsException"); }

        public Polinom addToPolinom(Double[] coeficienti, Integer[] puteri){
            int i=0;
            Polinom p = new Polinom(new ArrayList());

            while(puteri[i]!=null){
                Monom mon = new Monom(puteri[i],coeficienti[i]);
                p.addMon(mon);
                i++;
            }if(coeficienti[i]!=null){
                Monom mon = new Monom(0,coeficienti[i]);
                p.addMon(mon);}
            return p;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String user1Input;
            String user2Input;
            try {
                Double[] coeficienti1 = new Double[100];
                Integer[] puteri1 = new Integer[100];
                Polinom polin1 = new Polinom(new ArrayList());
                Polinom polin2 = new Polinom(new ArrayList());
                Double[] coeficienti2 = new Double[100];
                Integer[] puteri2 = new Integer[100];
                user1Input = classview.getUser1Input();
                user2Input = classview.getUser2Input();
                coeficienti1 = citireCoeficienti(user1Input);
                puteri1 = citirePuteri(user1Input);
                polin1 = addToPolinom(coeficienti1,puteri1);
                coeficienti2 = citireCoeficienti(user2Input);
                puteri2 = citirePuteri(user2Input);
                polin2 = addToPolinom(coeficienti2,puteri2);
                Polinom result = new Polinom(new ArrayList());
                result=polin1.inmultire(polin2);
                classview.setResult1(result.afisare(result));
            } catch (Exception numberFormatException) {
                numberFormatException.printStackTrace();
            }
        }
    }


    class AfisareDate5 implements ActionListener{

        public Double[] citireCoeficienti(String user1Input ) throws Exception {
            Double[] sir1 = new Double[100];
            int j1=0,b1=0,a1=0;
            Double[] coeficienti1 = new Double[100];
            Pattern p1 = Pattern.compile("-?\\d+(\\.\\d+)?");
            Matcher m1 = p1.matcher(user1Input);
            if((user1Input.matches("-?\\d+(\\.\\d+)?")|| (user1Input.matches("-?\\d+(\\.\\d+)?\\*x\\^.*") && user1Input.matches("[^a-w]+") && user1Input.contains("x") && user1Input.matches("[^A-Z]+") && !user1Input.contains("y") && !user1Input.contains("z"))))
            {
                while(m1.find()){
                    sir1[j1]=Double.parseDouble(m1.group());
                    j1++; }
                int numbers1[] =new int[j1];
                while(b1<j1){
                    numbers1[b1]=b1;
                    b1++; }
                for(int i: numbers1){
                    if(i%2==0){
                        coeficienti1[a1]=sir1[i];
                        a1++; }}
                return coeficienti1;}
            else
                throw new Exception("DidntRespectTheRequirementsException");
        }

        public Integer[] citirePuteri(String user1Input ) throws Exception {
            Double[] sir1 = new Double[100];
            int j1=0,b1=0,a1=0,put1=0,cnt1=0;
            Integer[] puteri1 = new Integer[100];
            Pattern p1 = Pattern.compile("-?\\d+(\\.\\d+)?");
            Matcher m1 = p1.matcher(user1Input);
            if((user1Input.matches("-?\\d+(\\.\\d+)?")|| (user1Input.matches("-?\\d+(\\.\\d+)?\\*x\\^.*") && user1Input.matches("[^a-w]+") && user1Input.contains("x") && user1Input.matches("[^A-Z]+") && !user1Input.contains("y") && !user1Input.contains("z"))))
            {   while(m1.find()){
                sir1[j1]=Double.parseDouble(m1.group());
                j1++; }
                int[] numbers1 =new int[j1];
                while(b1<j1){
                    numbers1[b1]=b1;
                    b1++; }
                for(int i: numbers1){
                    if(i%2==1){
                        puteri1[a1]=sir1[i].intValue();
                        a1++; }}
                int[] puteri = new int[a1];
                while(put1<a1-1){
                    puteri[put1]=put1;
                    put1++; }
                for(int i1: puteri){
                    if(puteri1[i1+1]!=null)
                        if(puteri1[i1]<puteri1[i1+1])
                            cnt1++;
                        else return puteri1;}
                if(cnt1==0) return puteri1;
                else throw new Exception("DidntRespectTheRequirementsException"); }
            else throw new Exception("DidntRespectTheRequirementsException"); }

        public Polinom addToPolinom(Double[] coeficienti, Integer[] puteri){
            int i=0;
            Polinom p = new Polinom(new ArrayList());

            while(puteri[i]!=null){
                Monom mon = new Monom(puteri[i],coeficienti[i]);
                p.addMon(mon);
                i++;
            }if(coeficienti[i]!=null){
                Monom mon = new Monom(0,coeficienti[i]);
                p.addMon(mon);}
            return p;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            String user1Input;
            try {
                Double[] coeficienti1 = new Double[100];
                Integer[] puteri1 = new Integer[100];
                Polinom polin1 = new Polinom(new ArrayList());
                user1Input = classview.getUser1Input();
                coeficienti1 = citireCoeficienti(user1Input);
                puteri1 = citirePuteri(user1Input);
                polin1 = addToPolinom(coeficienti1,puteri1);
                Polinom result = new Polinom(new ArrayList());
                result=polin1.derivare();
                classview.setResult1(result.afisare(result));
            } catch (Exception numberFormatException) {
                numberFormatException.printStackTrace();
            }
        }
    }

    //21.0*x^6+25.0*x^4+4.2*x^1

    class AfisareDate6 implements ActionListener{

        public Double[] citireCoeficienti(String user1Input ) throws Exception {
            Double[] sir1 = new Double[100];
            int j1=0,b1=0,a1=0;
            Double[] coeficienti1 = new Double[100];
            Pattern p1 = Pattern.compile("-?\\d+(\\.\\d+)?");
            Matcher m1 = p1.matcher(user1Input);
            if((user1Input.matches("-?\\d+(\\.\\d+)?")|| (user1Input.matches("-?\\d+(\\.\\d+)?\\*x\\^.*") && user1Input.matches("[^a-w]+") && user1Input.contains("x") && user1Input.matches("[^A-Z]+") && !user1Input.contains("y") && !user1Input.contains("z"))))
            {
                while(m1.find()){
                    sir1[j1]=Double.parseDouble(m1.group());
                    j1++; }
                int[] numbers1 =new int[j1];
                while(b1<j1){
                    numbers1[b1]=b1;
                    b1++; }
                for(int i: numbers1){
                    if(i%2==0){
                        coeficienti1[a1]=sir1[i];
                        a1++; }}
                return coeficienti1;}
            else
                throw new Exception("DidntRespectTheRequirementsException");
        }

        public Integer[] citirePuteri(String user1Input ) throws Exception {
            Double[] sir1 = new Double[100];
            int j1=0,b1=0,a1=0,put1=0,cnt1=0;
            Integer[] puteri1 = new Integer[100];
            Pattern p1 = Pattern.compile("-?\\d+(\\.\\d+)?");
            Matcher m1 = p1.matcher(user1Input);
            if((user1Input.matches("-?\\d+(\\.\\d+)?")|| (user1Input.matches("-?\\d+(\\.\\d+)?\\*x\\^.*") && user1Input.matches("[^a-w]+") && user1Input.contains("x") && user1Input.matches("[^A-Z]+") && !user1Input.contains("y") && !user1Input.contains("z"))))
            {   while(m1.find()){
                sir1[j1]=Double.parseDouble(m1.group());
                j1++; }
                int[] numbers1 =new int[j1];
                while(b1<j1){
                    numbers1[b1]=b1;
                    b1++; }
                for(int i: numbers1){
                    if(i%2==1){
                        puteri1[a1]=sir1[i].intValue();
                        a1++; }}
                int[] puteri = new int[a1];
                while(put1<a1-1){
                    puteri[put1]=put1;
                    put1++; }
                for(int i1: puteri){
                    if(puteri1[i1+1]!=null)
                        if(puteri1[i1]<puteri1[i1+1])
                            cnt1++;
                        else return puteri1;}
                if(cnt1==0) return puteri1;
                else throw new Exception("DidntRespectTheRequirementsException"); }
            else throw new Exception("DidntRespectTheRequirementsException"); }

        public Polinom addToPolinom(Double[] coeficienti, Integer[] puteri){
            int i=0;
            Polinom p = new Polinom(new ArrayList());

            while(puteri[i]!=null){
                Monom mon = new Monom(puteri[i],coeficienti[i]);
                p.addMon(mon);
                i++;
            }if(coeficienti[i]!=null){
                Monom mon = new Monom(0,coeficienti[i]);
                p.addMon(mon);}
            return p;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            String user1Input;
            try {
                Double[] coeficienti1 = new Double[100];
                Integer[] puteri1 = new Integer[100];
                Polinom polin1 = new Polinom(new ArrayList());
                user1Input = classview.getUser1Input();
                coeficienti1 = citireCoeficienti(user1Input);
                puteri1 = citirePuteri(user1Input);
                polin1 = addToPolinom(coeficienti1,puteri1);
                Polinom result = new Polinom(new ArrayList());
                result=polin1.integrare();
                classview.setResult1(result.afisare(result));
            } catch (Exception numberFormatException) {
                numberFormatException.printStackTrace();
            }

        }
    }
 class ClearListener implements ActionListener{

     @Override
     public void actionPerformed(ActionEvent arg0) {
         classview.reset();
     }

 }

}
