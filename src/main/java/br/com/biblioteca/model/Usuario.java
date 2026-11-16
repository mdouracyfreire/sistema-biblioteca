package br.com.biblioteca.model;

public abstract class Usuario {
    private final String nome;
    private int quantidadeEmprestada;

    public Usuario(String nome) {
        this.nome = nome;
        this.quantidadeEmprestada = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidadeEmprestada() {
        return quantidadeEmprestada;
    }

    public abstract int getLimiteItens();

    public boolean podeEmprestar() {
        return quantidadeEmprestada < getLimiteItens();
    }

    public void registrarEmprestimo() {
        if (!podeEmprestar()) {
            throw new IllegalStateException("Limite de empréstimo atingido.");
        }

        quantidadeEmprestada++;
    }

    public void registrarDevolucao() {
        if (quantidadeEmprestada <= 0) {
            throw new IllegalStateException("O usuário não possui empréstimos registrados.");
        }

        quantidadeEmprestada--;
    }
}