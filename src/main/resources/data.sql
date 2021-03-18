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
	(4, 1),
	(5, 1),
	(6, 2),
	(7, 2),
	(8, 2),
	(9, 2);

INSERT INTO `gabarito` (`id`) VALUES
	(1),
	(2),
	(3);

INSERT INTO `prova` (`id`,`nome`, `prova_gabarito_id`, `simulado_id`) VALUES
	(1,'Matematica', 1, 1),
	(2,'Informatica', 2, 1),
	( 3,'Matematica', 1, 2),
	( 4,'Informatica', 2, 2);

INSERT INTO `questao` (`id`, `descricao`, `nivel`, `numero`, `prova_id`) VALUES
	(1, 'Quanto é 2 + 2? A) 4 B) 5 C) 6 D) 7', 'FACIL', 1, 1),
	(2, 'Quanto é 5 + 2? A) 4 B) 5 C) 6 D) 7', 'FACIL', 2, 1);

INSERT INTO `resposta` (`id`, `resposta`, `gabarito_id`, `questao_id`) VALUES
	(1, 'A', 1, 1),
	(2, 'C', 1, 2);

INSERT INTO `resposta_aluno` (`id`, `pontuacao`, `resposta`, `aluno_id`, `prova_id`, `questao_id`) VALUES
	(1, 0, 'A', 1, 1, 2);

