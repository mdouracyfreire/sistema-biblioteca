package br.com.biblioteca.model;

public abstract class ItemBiblioteca {
    private final String codigo;
    private final String titulo;
    private boolean disponivel;

    public ItemBiblioteca(String codigo, String titulo) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.disponivel = true;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void emprestar() {
        if (!disponivel) {
            throw new IllegalStateException("Item indisponível para empréstimo.");
        }

        disponivel = false;
    }

    public void devolver() {
        if (disponivel) {
            throw new IllegalStateException("O item já está disponível.");
        }

        disponivel = true;
    }

    public abstract int getPrazoEmprestimo();

    public abstract double calcularMulta(int diasAtraso);
}