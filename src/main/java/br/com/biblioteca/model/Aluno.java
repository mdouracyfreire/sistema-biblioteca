package br.com.biblioteca.model;

public class Aluno extends Usuario {
    private static final int LIMITE_ITENS = 3;

    public Aluno(String nome) {
        super(nome);
    }

    @Override
    public int getLimiteItens() {
        return LIMITE_ITENS;
    }
}