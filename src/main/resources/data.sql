INSERT INTO `aluno` (`id`, `cpf`, `nome`) VALUES
	(1, '81717947000', 'Robson Souza'),
	(2, '69680803031', 'Talita Silva'),
	(3, '14949606050', 'Felipe Luiz'),
	(4, '36742845023', 'Katia Alves'),
	(5, '57349758006', 'Henrique Melo'),
	(6, '91646244044', 'Marcelo Moreira'),
	(7, '24673641000', 'Fabiola Melo'),
	(8, '48413941091', 'Tiago Silva'),
	(9, '00680331093', 'Lucas Silva'),
	(10, '10818366010', 'Marcos Silva'),
	(11, '54207404007', 'Lionel Melo'),
	(12, '56361335020', 'Cristiano Souza'),
	(13, '23480281079', 'Rogerio Luis');


INSERT INTO `simulado` (`id`, `nome`) VALUES
	(1, 'FATEC'),
	(2, 'ETEC');


INSERT INTO `aluno_simulado` (`aluno_id`, `simulado_id`) VALUES
	(1, 1),
	(2, 1),
	(3, 1),
	(6, 2),
	(7, 2),
	(8, 2);

INSERT INTO `gabarito` (`id`) VALUES
	(1),
	(2),
	(3);

INSERT INTO `prova` (`id`, `nome`, `prova_gabarito_id`, `simulado_id`) VALUES
	(1, 'MATEMATICA', 1, 1),
	(2, 'INGLES', 2, 1),
	(5, 'MATEMATICA', 3, 2);

INSERT INTO `questao` (`id`, `descricao`, `nivel`, `numero`, `prova_id`) VALUES
	(1, 'Quanto é 2 + 2? A) 4 B) 5 C) 6 D) 7', 'FACIL', 1, 1),
	(2, 'Quanto é 5 + 2? A) 4 B) 5 C) 6 D) 7', 'FACIL', 2, 1),
	(3, 'Quanto é 5 + 5? A) 10 B) 5 C) 6 D) 7', 'FACIL', 3, 1),
	(4, 'Quanto é 4 * 2? A) 8 B) 5 C) 6 D) 7', 'MEDIA', 4, 1),
	(5, 'Quanto é 3 * 3? A) 8 B) 9 C) 6 D) 7', 'MEDIA', 5, 1),
	(6, 'Quanto é 5 * 5? A) 5 B) 10 C) 15 D) 25', 'MEDIA', 6, 1),
	(7, 'Quanto é 10 * 5? A) 500 B) 5 C) 15 D) 50', 'MEDIA', 7, 1),
	(8, 'Quanto é 10 / 5? A) 2 B) 5 C) 15 D) 1', 'DIFICIL', 8, 1),
	(9, 'Quanto é 9 / 3? A) 2 B) 3 C) 15 D) 1', 'DIFICIL', 9, 1),
	(10, 'Quanto é 100 / 2? A) 25 B) 30 C) 15 D) 50', 'DIFICIL', 10, 1),
	(11, 'O que significa "I"? A) Eu B) Voce C) Eles D) Ela', 'FACIL', 1, 2),
	(12, 'O que significa "SHE"? A) Eu B) Voce C) Eles D) Ela', 'FACIL', 2, 2),
	(13, 'O que significa "HE"? A) Eu B) Ele C) Eles D) Ela', 'FACIL', 3, 2),
	(14, 'O que significa "THEY"? A) Eu B) Voce C) Eles D) Ela', 'MEDIA', 4, 2),
	(15, 'O que significa "THIS"? A) Isto B) Estes C) Eles D) Ela', 'MEDIA', 5, 2),
	(16, 'O que significa "WE"? A) Nos B) Eles C) Elas D) Ela', 'MEDIA', 6, 2),
	(17, 'O que significa "BUS"? A) Bola B) Onibus C) Carro D) Ela', 'MEDIA', 7, 2),
	(18, 'O que significa "WHAT"? A) O que B) quem C) como D) aonde', 'DIFICIL', 8, 2),
	(19, 'O que significa "WHO"? A) O que B) quem C) como D) aonde', 'DIFICIL', 9, 2),
	(20, 'O que significa "WHERE"? A) O que B) quem C) como D) onde', 'DIFICIL', 10, 2),
	(21, 'Quanto é 2 + 2? A) 4 B) 5 C) 6 D) 7', 'FACIL', 1, 5),
	(22, 'Quanto é 5 + 2? A) 4 B) 5 C) 6 D) 7', 'FACIL', 2, 5),
	(23, 'Quanto é 5 + 5? A) 10 B) 5 C) 6 D) 7', 'FACIL', 3, 5),
	(24, 'Quanto é 4 * 2? A) 8 B) 5 C) 6 D) 7', 'MEDIA', 4, 5),
	(25, 'Quanto é 3 * 3? A) 8 B) 9 C) 6 D) 7', 'MEDIA', 5, 5),
	(26, 'Quanto é 5 * 5? A) 5 B) 10 C) 15 D) 25', 'MEDIA', 6, 5),
	(27, 'Quanto é 10 * 5? A) 500 B) 5 C) 15 D) 50', 'MEDIA', 7, 5),
	(28, 'Quanto é 10 / 5? A) 2 B) 5 C) 15 D) 1', 'DIFICIL', 8, 5),
	(29, 'Quanto é 9 / 3? A) 2 B) 3 C) 15 D) 1', 'DIFICIL', 9, 5),
	(30, 'Quanto é 100 / 2? A) 25 B) 30 C) 15 D) 50', 'DIFICIL', 10, 5);

INSERT INTO `resposta` (`id`, `resposta`, `gabarito_id`, `questao_id`) VALUES
	(1, 'A', 1, 1),
	(2, 'C', 1, 2),
	(3, 'A', 1, 3),
	(4, 'A', 1, 4),
	(5, 'C', 1, 5),
	(6, 'D', 1, 6),
	(7, 'D', 1, 7),
	(8, 'A', 1, 8),
	(9, 'B', 1, 9),
	(10, 'D', 1, 10),
	(11, 'A', 2, 11),
	(12, 'D', 2, 12),
	(13, 'B', 2, 13),
	(14, 'C', 2, 14),
	(15, 'A', 2, 15),
	(16, 'A', 2, 16),
	(17, 'B', 2, 17),
	(18, 'A', 2, 18),
	(19, 'B', 2, 19),
	(20, 'D', 2, 20),
	(21, 'A', 3, 21),
	(22, 'C', 3, 22),
	(23, 'A', 3, 23),
	(24, 'A', 3, 24),
	(25, 'C', 3, 25),
	(26, 'D', 3, 26),
	(27, 'D', 3, 27),
	(28, 'A', 3, 28),
	(29, 'B', 3, 29),
	(30, 'D', 3, 30);

INSERT INTO `resposta_aluno` (`id`, `pontuacao`, `resposta`, `aluno_id`, `prova_id`, `questao_id`) VALUES
	(1, 15, 'C', 1, 1, 2),
	(2, 15, 'A', 1, 1, 1),
	(3, 15, 'C', 2, 1, 2),
	(4, 12, 'D', 1, 1, 7),
	(5, 8, 'A', 3, 1, 8),
	(6, 15, 'A', 3, 2, 11),
	(7, 15, 'D', 3, 2, 12),
	(8, 15, 'D', 1, 2, 12),
	(9, 15, 'A', 6, 5, 21),
	(10, 15, 'C', 6, 5, 22),
	(11, 15, 'C', 8, 5, 22);


INSERT INTO `nota_prova` (`id`, `nota`, `aluno_id`, `prova_id`) VALUES
	(2, 615, 1, 2),
	(3, 615, 2, 1),
	(4, 600, 2, 2),
	(5, 608, 3, 1),
	(6, 660, 3, 2),
	(7, 600, 4, 1),
	(8, 600, 4, 2),
	(9, 600, 5, 1),
	(10, 600, 5, 2),
	(16, 672, 1, 1),
	(17, 660, 6, 5),
	(18, 600, 7, 5),
	(19, 615, 8, 5);