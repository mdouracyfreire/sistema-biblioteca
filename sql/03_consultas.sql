-- CONSULTA 1: Listar todo o acervo

SELECT
    codigo,
    titulo,
    tipo,
    disponivel
FROM item
ORDER BY codigo;


-- CONSULTA 2: Listar empréstimos em aberto

SELECT
    u.nome AS usuario,
    i.titulo AS item,
    e.data_retirada,
    e.data_devolucao_prevista
FROM emprestimo e
INNER JOIN usuario u ON e.usuario_id = u.id
INNER JOIN item i ON e.item_id = i.id
WHERE e.data_devolucao IS NULL
ORDER BY e.data_retirada;


-- CONSULTA 3: Total de multas por usuário

SELECT
    u.nome AS usuario,
    COALESCE(SUM(e.valor_multa), 0) AS total_multas
FROM usuario u
LEFT JOIN emprestimo e ON u.id = e.usuario_id
GROUP BY u.id, u.nome
ORDER BY u.nome;


-- CONSULTA 4: Itens nunca emprestados

SELECT
    i.codigo,
    i.titulo,
    i.tipo
FROM item i
LEFT JOIN emprestimo e ON i.id = e.item_id
WHERE e.id IS NULL
ORDER BY i.codigo;