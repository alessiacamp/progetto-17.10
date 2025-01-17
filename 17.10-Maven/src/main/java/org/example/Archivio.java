package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

public class Archivio {
    List<Catalogo> catalogo = new ArrayList<Catalogo>();


    public void aggiungiCatalogo(Catalogo nuovoCatalogo) {
        if (catalogo.stream().anyMatch(catalogo1 -> catalogo1.getIsbn() == nuovoCatalogo.getIsbn())) {
            System.out.println("Elemento già esistente e non può essere inserito");
        } else {
            catalogo.add(nuovoCatalogo);
            System.out.println("Catalogo inserito");

        }
    }

    public void ricercaIsbn(int nuovoIsbn) throws Exception {
        Catalogo ricercaCatalogo = catalogo.stream().filter(catalogo1 -> catalogo1.getIsbn() == nuovoIsbn).findFirst().orElse(null);
        if (ricercaCatalogo != null) {
            System.out.println(ricercaCatalogo.toString());
        } else {
            throw new Exception("Nessun catalogo trovato");
        }
    }

    public void rimozioneElemento(int nuovoIsbn) {
        boolean risultato = catalogo.removeIf(catalogo1 -> catalogo1.getIsbn() == nuovoIsbn);
        if (risultato == true) {
            System.out.println("Il catalogo è stato rimosso");

        } else {
            System.out.println("Il catalogo non è stato rimosso");
        }
    }

    public void ricercaAnnoPubblicazione(int nuovoAnnoPubblicazione) throws Exception {
        List<Catalogo> ricercaCatalogo = catalogo.stream().filter(catalogo1 -> catalogo1.getAnnoPubblicazione() == nuovoAnnoPubblicazione).toList();
        if (ricercaCatalogo.isEmpty() != false) {
            System.out.println(ricercaCatalogo.toString());
        } else {
            throw new Exception("Nessun catalogo trovato");
        }
    }

    public void ricercaAutore(String nuovoAutore) throws Exception {
        List<Catalogo> ricercaCatalogo = catalogo.stream().filter(catalogo1 -> catalogo1 instanceof Libro).filter(catalogo1 -> ((Libro) catalogo1).getAutore().equals(nuovoAutore)).toList();
        if (ricercaCatalogo.isEmpty() != false) {
            System.out.println(ricercaCatalogo.toString());
        } else {
            throw new Exception("Nessun autore trovato");
        }


    }

    public void aggiornamento(int nuovoIsbn, Catalogo nuovoCatalogo) throws Exception {
        Catalogo ricercaCatalogo = catalogo.stream().filter(catalogo1 -> catalogo1.getIsbn() == nuovoIsbn).findFirst().orElse(null);
        if (ricercaCatalogo != null) {
            ricercaCatalogo.setTitolo(nuovoCatalogo.getTitolo());
            ricercaCatalogo.setIsbn(nuovoCatalogo.getIsbn());
            ricercaCatalogo.setAnnoPubblicazione(nuovoCatalogo.getAnnoPubblicazione());
            ricercaCatalogo.setNumeroPagine(ricercaCatalogo.getNumeroPagine());
        } else {

            throw new Exception("Nessun catalogo trovato");
        }
    }

    public void statisticheCatalogo() {
        int numeroLibri = catalogo.stream().filter(catalogo1 -> catalogo1 instanceof Libro).toList().size();
        System.out.println("Il numero totale dei libri è " + numeroLibri);
        int numeroRiviste = catalogo.stream().filter(catalogo1 -> catalogo1 instanceof Rivista).toList().size();
        System.out.println("Il numero totale dei riviste è " + numeroRiviste);
        Catalogo numeroPagine = catalogo.stream().sorted(Comparator.comparingInt(Catalogo::getNumeroPagine).reversed()).toList().getFirst();
        System.out.println(numeroPagine.toString());
        OptionalDouble media = catalogo.stream().mapToDouble(catalogo1 -> catalogo1.getNumeroPagine()).average();
        if (media.isPresent()) {
            System.out.println("La media delle pagine è " + media);

        } else {
            System.out.println("Non è possibile calcolare la media");
        }
    }


}


