package br.com.biblioteca.app;

import br.com.biblioteca.model.Aluno;
import br.com.biblioteca.model.Professor;
import br.com.biblioteca.model.Usuario;

public class Main {
    public static void main(String[] args) {
        Usuario aluno = new Aluno("Dora");
        Usuario professor = new Professor("Bruno");

        System.out.println("==== TESTE DE USUÁRIOS ====");

        System.out.println("\nALUNO");
        System.out.println("Nome: " + aluno.getNome());
        System.out.println("Limite: " + aluno.getLimiteItens());

        aluno.registrarEmprestimo();
        aluno.registrarEmprestimo();
        aluno.registrarEmprestimo();

        System.out.println("Itens emprestados: " + aluno.getQuantidadeEmprestada());
        System.out.println("Pode emprestar outro? " + aluno.podeEmprestar());

        System.out.println("\nPROFESSOR");
        System.out.println("Nome: " + professor.getNome());
        System.out.println("Limite: " + professor.getLimiteItens());

        professor.registrarEmprestimo();

        System.out.println("Itens emprestados: " + professor.getQuantidadeEmprestada());
        System.out.println("Pode emprestar outro? " + professor.podeEmprestar());

        System.out.println("\nTESTE DE DEVOLUÇÃO");
        aluno.registrarDevolucao();

        System.out.println("Itens do aluno após a devolução: " + aluno.getQuantidadeEmprestada());
        System.out.println("Pode emprestar novamente? " + aluno.podeEmprestar());
    }
}