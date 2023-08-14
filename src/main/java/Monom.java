import java.util.*;

public class Monom implements Comparable<Monom>{
    private int putere;
    private Double coeficient;

    public Monom(int p, Double c){
        this.putere = p;
        this.coeficient = c;
    }

    public int getPutere() {
        return putere;
    }

    public void setPutere(int putere) {
        this.putere = putere;
    }

    public Double getCoeficient() {
        return coeficient;
    }

    public void setCoeficient(Double coeficient) {
        this.coeficient = coeficient;
    }

    public int compareTo(Monom m){
        return this.getPutere()-m.getPutere();
    }


}

