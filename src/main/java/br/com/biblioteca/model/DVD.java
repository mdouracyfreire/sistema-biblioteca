package br.com.biblioteca.model;

public class DVD extends ItemBiblioteca{
    private static final int PRAZO_EMPRESTIMO = 5;
    private static final double MULTA_DIARIA = 2.00;

    public DVD(String codigo, String titulo) {
        super(codigo, titulo);
    }

    @Override
    public int getPrazoEmprestimo() {
        return PRAZO_EMPRESTIMO;
    }

    @Override
    public double calcularMulta(int diasAtraso) {
        if (diasAtraso <= 0) {
            return 0;
        }

        return diasAtraso * MULTA_DIARIA;
    }
}
