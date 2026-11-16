INSERT INTO item (codigo, titulo, tipo, autor, edicao)
VALUES
    ('L001', 'Java: Como Programar', 'livro', 'Paul Deitel', '10ª'),
    ('L002', 'Clean Code', 'livro', 'Robert C. Martin', '1ª'),
    ('R001', 'Revista Veja', 'revista', NULL, '25ª'),
    ('R002', 'Ciência Hoje', 'revista',NULL, '40ª');


INSERT INTO usuario (nome, tipo, limite_itens)
VALUES
    ('Maria', 'aluno', 3),
    ('Carlos', 'professor', 5);


INSERT INTO emprestimo (
    item_id,
    usuario_id,
    data_retirada,
    data_devolucao_prevista,
    data_devolucao,
    valor_multa
)
VALUES
    (
        (SELECT id FROM item WHERE codigo = 'L001'),
        (SELECT id FROM usuario
         WHERE nome = 'Maria' AND tipo = 'aluno'),
        '2026-11-10',
        '2026-11-24',
        NULL,
        0.00
    ),
    (
        (SELECT id FROM item WHERE codigo = 'R001'),
        (SELECT id FROM usuario
         WHERE nome = 'Carlos' AND tipo = 'professor'),
        '2026-11-01',
        '2026-11-08',
        '2026-11-11',
        3.00
    );


UPDATE item
SET disponivel = FALSE
WHERE codigo = 'L001';