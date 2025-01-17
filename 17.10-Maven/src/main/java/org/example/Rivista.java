package org.example;

public class Rivista extends Catalogo {
private Periodicita periodicita;

    public Rivista(String titolo, int isbn, int annoPubblicazione, int numeroPagine, Periodicita periodicita) {
        super(titolo, isbn, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;

    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "periodicita=" + periodicita +
                '}';
    }
}
