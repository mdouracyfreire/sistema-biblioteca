package br.com.biblioteca.service;

import br.com.biblioteca.model.ItemBiblioteca;
import br.com.biblioteca.model.Usuario;

public class Biblioteca {
    private final ItemBiblioteca[] acervo = new ItemBiblioteca[20];
    private final Usuario[] usuarios = new Usuario[10];
    private final Usuario[] responsaveis = new Usuario[20];
    private int totalItens = 0;
    private int totalUsuarios = 0;

    public void cadastrarItem(ItemBiblioteca item) {
        if (item == null) {
            throw new IllegalArgumentException("Item inválido.");
        }

        if (totalItens >= acervo.length) {
            System.out.println("Acervo cheio!");
            return;
        }

        if (buscarIndiceItem(item.getCodigo()) != -1) {
            System.out.println("Código de item já cadastrado!");
            return;
        }

        acervo[totalItens] = item;
        totalItens++;
        System.out.println("Item cadastrado: " + item.getTitulo());
    }

    public void cadastrarUsuario(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("Usuário inválido.");
        }

        if (totalUsuarios >= usuarios.length) {
            System.out.println("Limite de usuários atingido!");
            return;
        }

        for (int i = 0; i < totalUsuarios; i++) {
            if (usuarios[i] == usuario) {
                System.out.println("Usuário já cadastrado!");
                return;
            }
        }

        usuarios[totalUsuarios] = usuario;
        totalUsuarios++;
        System.out.println("Usuário cadastrado: " + usuario.getNome());
    }

    private int buscarIndiceItem(String codigo) {
        for (int i = 0; i < totalItens; i++) {
            if (acervo[i].getCodigo().equals(codigo)) {
                return i;
            }
        }

        return -1;
    }

    private boolean usuarioCadastrado(Usuario usuario) {
        for (int i = 0; i < totalUsuarios; i++) {
            if (usuarios[i] == usuario) {
                return true;
            }
        }

        return false;
    }

    public boolean emprestar(String codigo,Usuario usuario) {
        int indice = buscarIndiceItem(codigo);

        if (indice == -1 || !usuarioCadastrado(usuario)) {
            System.out.println("Item ou usuário não cadastrado.");
            return false;
        }

        ItemBiblioteca item = acervo[indice];

        if (!item.isDisponivel()) {
            System.out.println("Item indisponível: " + item.getTitulo());
            return false;
        }

        if (!usuario.podeEmprestar()) {
            System.out.println("Limite de empréstimos atingido por " + usuario.getNome());
            return false;
        }

        item.emprestar();
        usuario.registrarEmprestimo();
        responsaveis[indice] = usuario;

        System.out.println("Empréstimo realizado: " + item.getTitulo() + " para " + usuario.getNome());
        System.out.println("Prazo: " + item.getPrazoEmprestimo() + " dias");
        return true;
    }

    public boolean devolver(String codigo, int diasAtraso) {
        int indice = buscarIndiceItem(codigo);

        if (indice == -1) {
            System.out.println("Item não encontrado.");
            return false;
        }

        ItemBiblioteca item = acervo[indice];
        Usuario usuario = responsaveis[indice];

        if (item.isDisponivel() || usuario == null) {
            System.out.println("O item não está emprestado.");
            return false;
        }

        double multa = item.calcularMulta(diasAtraso);
        item.devolver();
        usuario.registrarDevolucao();
        responsaveis[indice] = null;

        System.out.println("Devolução realizada: " + item.getTitulo());
        System.out.printf("Multa: R$ %.2f%n", multa);
        return true;
    }

    public void listarAcervo() {
        System.out.println("\n==== ACERVO DA BIBLIOTECA ====");

        for (int i = 0; i < totalItens; i++) {
            ItemBiblioteca item = acervo[i];

            System.out.println("--------------------------");
            System.out.println("Código: " + item.getCodigo());
            System.out.println("Título: " + item.getTitulo());
            System.out.println("Prazo: " + item.getPrazoEmprestimo() + " dias");
            System.out.println("Disponível: " + (item.isDisponivel() ? "Sim" : "Não"));
        }
    }
}