package org.example;


public class Libro extends Catalogo {
    private String autore;
    private String genere;

    public Libro(String titolo, int isbn, int annoPubblicazione, int numeroPagine, String autore, String genere) {
        super(titolo, isbn, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;


    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;


    }

    @Override
    public String toString() {
        return "Libro{" +
                "autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                '}';
    }
}

