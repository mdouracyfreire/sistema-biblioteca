package br.com.biblioteca.app;

import br.com.biblioteca.model.ItemBiblioteca;
import br.com.biblioteca.model.Livro;
import br.com.biblioteca.model.Revista;

public class Main {
    public static void main(String[] args) {
        ItemBiblioteca livro = new Livro("L001", "Java: Como Programar");
        ItemBiblioteca revista = new Revista("R001", "Revista Veja");

        System.out.println("==== SISTEMA DE BIBLIOTECA ====");

        System.out.println("\nLIVRO");
        System.out.println("Título: " + livro.getTitulo());
        System.out.println("Prazo: " + livro.getPrazoEmprestimo() + " dias");
        System.out.println("Multa por 4 dias: R$ " + livro.calcularMulta(4));

        System.out.println("\nREVISTA");
        System.out.println("Título: " + revista.getTitulo());
        System.out.println("Prazo: " + revista.getPrazoEmprestimo() + " dias");
        System.out.println("Multa por 4 dias: R$ " + revista.calcularMulta(4));

        System.out.println("\nTESTE DE EMPRÉSTIMO");
        livro.emprestar();
        System.out.println("Livro disponível? " + livro.isDisponivel());
        livro.devolver();
        System.out.println("Livro disponível após devolução? " + livro.isDisponivel());
    }
}