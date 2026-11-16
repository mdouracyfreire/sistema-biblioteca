package br.com.biblioteca.model;

public class Professor extends Usuario {
    private static final int LIMITE_ITENS = 5;

    public Professor(String nome) {
        super(nome);
    }

    @Override
    public int getLimiteItens() {
        return LIMITE_ITENS;
    }
}