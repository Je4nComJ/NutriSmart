-- Inserindo dados em tb_nutricionista
INSERT INTO tb_nutricionista (id, nome, crn, telefone, email, especialidade, data_contratacao) VALUES (1, 'Dr. João Silva', 'CRN12345', '11999998888', 'joao.silva@gmail.com', 'Nutrição Esportiva', '2020-01-15');
INSERT INTO tb_nutricionista (id, nome, crn, telefone, email, especialidade, data_contratacao) VALUES (2, 'Dra. Ana Pereira', 'CRN23456', '11988887777', 'ana.pereira@gmail.com', 'Nutrição Clínica', '2019-05-20');
INSERT INTO tb_nutricionista (id, nome, crn, telefone, email, especialidade, data_contratacao) VALUES (3, 'Dr. Carlos Mendes', 'CRN34567', '11977776666', 'carlos.mendes@gmail.com', 'Nutrição Infantil', '2021-08-10');
INSERT INTO tb_nutricionista (id, nome, crn, telefone, email, especialidade, data_contratacao) VALUES (4, 'Dra. Fernanda Costa', 'CRN45678', '11966665555', 'fernanda.costa@gmail.com', 'Nutrição Esportiva', '2022-03-05');
INSERT INTO tb_nutricionista (id, nome, crn, telefone, email, especialidade, data_contratacao) VALUES (5, 'Dr. Pedro Santos', 'CRN56789', '11955554444', 'pedro.santos@gmail.com', 'Nutrição Vegana', '2018-09-12');

-- Inserindo dados em tb_cliente
INSERT INTO tb_cliente (id, cpf, nome, data_nascimento, sexo, telefone, email, endereco, data_registro) VALUES (1, '111.111.111-11', 'Maria Oliveira', '1990-02-15', 'F', '11911112222', 'maria.oliveira@gmail.com', 'Rua A, 123', '2023-01-01');
INSERT INTO tb_cliente (id, cpf, nome, data_nascimento, sexo, telefone, email, endereco, data_registro) VALUES (2, '222.222.222-22', 'José Souza', '1985-06-20', 'M', '11922223333', 'jose.souza@gmail.com', 'Rua B, 456', '2023-02-10');
INSERT INTO tb_cliente (id, cpf, nome, data_nascimento, sexo, telefone, email, endereco, data_registro) VALUES (3, '333.333.333-33', 'Ana Lima', '1995-10-30', 'F', '11933334444', 'ana.lima@gmail.com', 'Rua C, 789', '2023-03-15');
INSERT INTO tb_cliente (id, cpf, nome, data_nascimento, sexo, telefone, email, endereco, data_registro) VALUES (4, '444.444.444-44', 'Carlos Almeida', '1988-08-25', 'M', '11944445555', 'carlos.almeida@gmail.com', 'Rua D, 321', '2023-04-20');
INSERT INTO tb_cliente (id, cpf, nome, data_nascimento, sexo, telefone, email, endereco, data_registro) VALUES (5, '555.555.555-55', 'Fernanda Ribeiro', '1992-12-10', 'F', '11955556666', 'fernanda.ribeiro@gmail.com', 'Rua E, 654', '2023-05-05');

-- Inserindo dados em tb_cliente_nutricionista
INSERT INTO tb_cliente_nutricionista (cliente_id, nutricionista_id) VALUES (1, 1);
INSERT INTO tb_cliente_nutricionista (cliente_id, nutricionista_id) VALUES (2, 2);
INSERT INTO tb_cliente_nutricionista (cliente_id, nutricionista_id) VALUES (3, 3);
INSERT INTO tb_cliente_nutricionista (cliente_id, nutricionista_id) VALUES (4, 4);
INSERT INTO tb_cliente_nutricionista (cliente_id, nutricionista_id) VALUES (5, 5);
INSERT INTO tb_cliente_nutricionista (cliente_id, nutricionista_id) VALUES (1, 2); -- Maria Oliveira também consulta com a Dra. Ana
INSERT INTO tb_cliente_nutricionista (cliente_id, nutricionista_id) VALUES (2, 3); -- José Souza também consulta com o Dr. Carlos

-- Inserindo dados em tb_consulta
INSERT INTO tb_consulta (id, id_cliente, id_nutricionista, data_consulta, observações) VALUES (1, 1, 1, '2023-06-10', 'Plano alimentar para ganho de massa.');
INSERT INTO tb_consulta (id, id_cliente, id_nutricionista, data_consulta, observações) VALUES (2, 2, 2, '2023-06-15', 'Controle de colesterol.');
INSERT INTO tb_consulta (id, id_cliente, id_nutricionista, data_consulta, observações) VALUES (3, 3, 3, '2023-06-20', 'Dieta para crianças com alergias.');
INSERT INTO tb_consulta (id, id_cliente, id_nutricionista, data_consulta, observações) VALUES (4, 4, 4, '2023-06-25', 'Plano alimentar para maratonistas.');
INSERT INTO tb_consulta (id, id_cliente, id_nutricionista, data_consulta, observações) VALUES (5, 5, 5, '2023-06-30', 'Dieta vegana para iniciantes.');