CREATE TABLE item (
	id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	codigo VARCHAR(20) NOT NULL UNIQUE,
	titulo VARCHAR(150) NOT NULL,
	tipo VARCHAR(20) NOT NULL,
	autor VARCHAR(100),
	edicao VARCHAR(30),
	disponivel BOOLEAN NOT NULL DEFAULT TRUE,

	CONSTRAINT chk_item_tipo CHECK (tipo IN ('livro', 'revista'))
);

CREATE TABLE usuario (
	id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	nome VARCHAR(100) NOT NULL,
	tipo VARCHAR(20) NOT NULL,
	limite_itens INTEGER NOT NULL,

	CONSTRAINT chk_usuario_tipo CHECK (tipo IN ('aluno', 'professor')),
	CONSTRAINT chk_usuario_limite CHECK (
		(tipo = 'aluno' AND limite_itens = 3) OR
		(tipo = 'professor' AND limite_itens = 5)
	)
);

CREATE TABLE emprestimo (
	id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	item_id INTEGER NOT NULL,
	usuario_id INTEGER NOT NULL,
	data_retirada DATE NOT NULL,
	data_devolucao_prevista DATE NOT NULL,
	data_devolucao DATE,
	valor_multa NUMERIC(10, 2) NOT NULL DEFAULT 0,

	CONSTRAINT fk_emprestimo_item FOREIGN KEY (item_id) REFERENCES item(id),
	CONSTRAINT fk_emprestimo_usuario FOREIGN KEY (usuario_id) REFERENCES usuario(id),
	CONSTRAINT chk_valor_multa CHECK (valor_multa >= 0),
	CONSTRAINT chk_data_prevista CHECK (data_devolucao_prevista >= data_retirada),
	CONSTRAINT chk_data_devolucao CHECK (data_devolucao IS NULL OR data_devolucao >= data_retirada)
);