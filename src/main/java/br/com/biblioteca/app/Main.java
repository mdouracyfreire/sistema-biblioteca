package br.com.biblioteca.app;

import br.com.biblioteca.model.*;
import br.com.biblioteca.service.Biblioteca;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Aluno aluno = new Aluno("Dora");
        Professor professor = new Professor("Astrid");

        System.out.println("==== CADASTRO DE USUÁRIOS ====");
        biblioteca.cadastrarUsuario(aluno);
        biblioteca.cadastrarUsuario(professor);

        System.out.println("\n==== CADASTRO DE ITENS ====");
        biblioteca.cadastrarItem(new Livro("L001", "Java: Como Programar"));
        biblioteca.cadastrarItem(new Livro("L002", "Clean Code"));
        biblioteca.cadastrarItem(new Livro("L003", "Design Patterns"));
        biblioteca.cadastrarItem(new Revista("R001", "Revista Veja"));
        biblioteca.cadastrarItem(new Revista("R002", "Ciência Hoje"));
        biblioteca.listarAcervo();

        System.out.println("\n==== EMPRÉSTIMOS ====");
        biblioteca.emprestar("L001", aluno);
        biblioteca.emprestar("L002", aluno);
        biblioteca.emprestar("L003", aluno);

        System.out.println("\n==== TESTE DE LIMITE ====");
        biblioteca.emprestar("R001", aluno);

        System.out.println("\n==== EMPRÉSTIMO PARA PROFESSOR ====");
        biblioteca.emprestar("R001", professor);

        System.out.println("\n==== DEVOLUÇÃO COM ATRASO ====");
        biblioteca.devolver("L001", 4);

        System.out.println("\n==== NOVO EMPRÉSTIMO ====");
        biblioteca.emprestar("R002", aluno);
        biblioteca.listarAcervo();

        System.out.println("\n==== TESTE DE NOVA CATEGORIA ====");
        DVD dvd = new DVD("D001", "Revolução Tecnológica");
        biblioteca.cadastrarItem(dvd);
        biblioteca.emprestar("D001", professor);
        biblioteca.devolver("D001", 3);
        biblioteca.listarAcervo();
    }
}