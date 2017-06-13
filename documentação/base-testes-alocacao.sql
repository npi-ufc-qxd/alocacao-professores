-- CURSOS
INSERT INTO curso (id, codigo, nome, sigla) VALUES (1, 401, 'Sistemas de Informação', 'SI');
INSERT INTO curso (id, codigo, nome, sigla) VALUES (2, 402, 'Engenharia de Software', 'ES');
INSERT INTO curso (id, codigo, nome, sigla) VALUES (3, 403, 'Redes de Computadores', 'RC');
INSERT INTO curso (id, codigo, nome, sigla) VALUES (4, 404, 'Ciência da Computação', 'CC');
INSERT INTO curso (id, codigo, nome, sigla) VALUES (5, 406, 'Design Digital', 'DD');
INSERT INTO curso (id, codigo, nome, sigla) VALUES (6, 405, 'Engenharia de Computação', 'EC');

-- SISTEMAS DE INFORMAÇÃO
INSERT INTO turma(id, semestre, curso_id) VALUES (1, 1, 1);
INSERT INTO turma(id, semestre, curso_id) VALUES (2, 2, 1);
INSERT INTO turma(id, semestre, curso_id) VALUES (3, 3, 1);
INSERT INTO turma(id, semestre, curso_id) VALUES (4, 4, 1);
INSERT INTO turma(id, semestre, curso_id) VALUES (5, 5, 1);
INSERT INTO turma(id, semestre, curso_id) VALUES (6, 6, 1);
INSERT INTO turma(id, semestre, curso_id) VALUES (7, 7, 1);
INSERT INTO turma(id, semestre, curso_id) VALUES (8, 8, 1);

-- ENGENHARIA DE SOFTWARE
INSERT INTO turma(id, semestre, curso_id) VALUES (9, 1, 2);
INSERT INTO turma(id, semestre, curso_id) VALUES (10, 2, 2);
INSERT INTO turma(id, semestre, curso_id) VALUES (11, 3, 2);
INSERT INTO turma(id, semestre, curso_id) VALUES (12, 4, 2);
INSERT INTO turma(id, semestre, curso_id) VALUES (13, 5, 2);
INSERT INTO turma(id, semestre, curso_id) VALUES (14, 6, 2);
INSERT INTO turma(id, semestre, curso_id) VALUES (15, 7, 2);
INSERT INTO turma(id, semestre, curso_id) VALUES (16, 8, 2);

-- REDES DE COMPUTADORES
INSERT INTO turma(id, semestre, curso_id) VALUES (17, 1, 3);
INSERT INTO turma(id, semestre, curso_id) VALUES (18, 2, 3);
INSERT INTO turma(id, semestre, curso_id) VALUES (19, 3, 3);
INSERT INTO turma(id, semestre, curso_id) VALUES (20, 4, 3);
INSERT INTO turma(id, semestre, curso_id) VALUES (21, 5, 3);
INSERT INTO turma(id, semestre, curso_id) VALUES (22, 6, 3);

-- CIÊNCIA DA COMPUTAÇÃO
INSERT INTO turma(id, semestre, curso_id) VALUES (23, 1, 4);
INSERT INTO turma(id, semestre, curso_id) VALUES (24, 2, 4);
INSERT INTO turma(id, semestre, curso_id) VALUES (25, 3, 4);
INSERT INTO turma(id, semestre, curso_id) VALUES (26, 4, 4);
INSERT INTO turma(id, semestre, curso_id) VALUES (27, 5, 4);
INSERT INTO turma(id, semestre, curso_id) VALUES (28, 6, 4);
INSERT INTO turma(id, semestre, curso_id) VALUES (29, 7, 4);
INSERT INTO turma(id, semestre, curso_id) VALUES (30, 7, 4);

-- DESIGN DIGITAL
INSERT INTO turma(id, semestre, curso_id) VALUES (31, 1, 5);
INSERT INTO turma(id, semestre, curso_id) VALUES (32, 2, 5);
INSERT INTO turma(id, semestre, curso_id) VALUES (33, 3, 5);
INSERT INTO turma(id, semestre, curso_id) VALUES (34, 4, 5);
INSERT INTO turma(id, semestre, curso_id) VALUES (35, 5, 5);
INSERT INTO turma(id, semestre, curso_id) VALUES (36, 6, 5);
INSERT INTO turma(id, semestre, curso_id) VALUES (37, 7, 5);
INSERT INTO turma(id, semestre, curso_id) VALUES (38, 8, 5);

-- ENGENHARIA DA COMPUTAÇÃO
INSERT INTO turma(id, semestre, curso_id) VALUES (39, 1, 6);
INSERT INTO turma(id, semestre, curso_id) VALUES (40, 2, 6);
INSERT INTO turma(id, semestre, curso_id) VALUES (41, 3, 6);
INSERT INTO turma(id, semestre, curso_id) VALUES (42, 4, 6);
INSERT INTO turma(id, semestre, curso_id) VALUES (43, 5, 6);
INSERT INTO turma(id, semestre, curso_id) VALUES (44, 6, 6);
INSERT INTO turma(id, semestre, curso_id) VALUES (45, 7, 6);
INSERT INTO turma(id, semestre, curso_id) VALUES (46, 8, 6);
INSERT INTO turma(id, semestre, curso_id) VALUES (47, 9, 6);
INSERT INTO turma(id, semestre, curso_id) VALUES (48, 10, 6);

-- DISCIPLINAS
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (1, false, 0, 0, 'QXD0108', 0, 'INTRODUÇÃO À CIÊNCIA DA COMPUTAÇÃO');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (2, false, 0, 0, 'QXD0001', 0, 'FUNDAMENTOS DE PROGRAMAÇÃO');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (3, false, 0, 0, 'QXD0002', 0, 'INTRODUÇÃO A CIÊNCIA DA COMPUTAÇÃO E SISTEMAS DE INFORMAÇÃO');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (4, false, 0, 0, 'QXD0005', 0, 'ARQUITETURA DE COMPUTADORES');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (5, false, 0, 0, 'QXD0006', 0, 'CÁLCULO DIFERENCIAL E INTEGRAL I');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (6, false, 0, 0, 'QXD0007', 0, 'PROGRAMAÇÃO ORIENTADA A OBJETOS');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (7, false, 0, 0, 'QXD0008', 0, 'MATEMÁTICA DISCRETA');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (8, false, 0, 0, 'QXD0009', 0, 'TEORIA GERAL DE SISTEMAS');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (9, false, 0, 0, 'QXD0010', 0, 'ESTRUTURA DE DADOS');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (10, false, 0, 0, 'QXD0011', 0, 'FUNDAMENTOS DE BANCO DE DADOS');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (11, false, 0, 0, 'QXD0012', 0, 'PROBABILIDADE E ESTATÍSTICA');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (12, false, 0, 0, 'QXD0013', 0, 'SISTEMAS OPERACIONAIS');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (13, false, 0, 0, 'QXD0014', 0, 'ANÁLISE E PROJETO DE SISTEMAS');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (14, false, 0, 0, 'QXD0016', 0, 'LINGUAGENS DE PROGRAMAÇÃO');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (15, false, 0, 0, 'QXD0017', 0, 'LÓGICA PARA COMPUTAÇÃO');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (16, false, 0, 0, 'QXD0018', 0, 'CONSTRUÇÃO DE SISTEMAS DE GERÊNCIA DE BANCO DE DADOS');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (17, false, 0, 0, 'QXD0019', 0, 'ENGENHARIA DE SOFTWARE');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (18, false, 0, 0, 'QXD0020', 0, 'DESENVOLVIMENTO DE SOFTWARE PARA WEB');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (19, false, 0, 0, 'QXD0021', 0, 'REDES DE COMPUTADORES');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (20, false, 0, 0, 'QXD0022', 0, 'AUDITORIA DE SEGURANÇA DE SISTEMAS DE INFORMAÇÃO');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (21, false, 0, 0, 'QXD0023', 0, 'GERÊNCIA DE PROJETOS DE SOFTWARE');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (22, false, 0, 0, 'QXD0024', 0, 'AVALIAÇÃO DE SISTEMAS');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (23, false, 0, 0, 'QXD0025', 0, 'COMPILADORES');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (24, false, 0, 0, 'QXD0026', 0, 'CONTABILIDADE E CUSTOS');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (25, false, 0, 0, 'QXD0027', 0, 'E-BUSINESS');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (26, false, 0, 0, 'QXD0028', 0, 'ECONOMIA E FINANÇAS');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (27, false, 0, 0, 'QXD0029', 0, 'EMPREENDEDORISMO');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (28, false, 0, 0, 'QXD0031', 0, 'FILOSOFIA DA CIÊNCIA');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (29, false, 0, 0, 'QXD0032', 0, 'FUNÇÕES EMPRESARIAIS');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (30, false, 0, 0, 'QXD0033', 0, 'GERÊNCIA DE REDES');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (31, false, 0, 0, 'QXD0034', 0, 'GERÊNCIA DE PROJETOS');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (32, false, 0, 0, 'QXD0035', 0, 'INGLÊS INSTRUMENTAL I');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (33, false, 0, 0, 'QXD0036', 0, 'INGLÊS INSTRUMENTAL II');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (34, false, 0, 0, 'QXD0037', 0, 'INTELIGÊNCIA ARTIFICIAL');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (35, false, 0, 0, 'QXD0038', 0, 'INTERFACE HUMANO-COMPUTADOR');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (36, false, 0, 0, 'QXD0039', 0, 'INTRODUÇÃO A COMPUTAÇÃO GRAFICA');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (37, false, 0, 0, 'QXD0040', 0, 'LINGUAGENS FORMAIS E AUTOMATOS');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (38, false, 0, 0, 'QXD0041', 0, 'PROJETO E ANALISE DE ALGORITMOS');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (39, false, 0, 0, 'QXD0042', 0, 'QUALIDADE DE SOFTWARE');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (40, false, 0, 0, 'QXD0043', 0, 'SISTEMAS DISTRIBUIDOS');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (41, false, 0, 0, 'QXD0044', 0, 'SISTEMAS MULTIMIDIA');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (42, false, 0, 0, 'QXD0046', 0, 'TEORIA DA COMPUTAÇÃO');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (43, false, 0, 0, 'QXD0047', 0, 'TOPICOS AVANÇADOS EM BANCO DE DADOS');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (44, false, 0, 0, 'QXD0048', 0, 'TOPICOS AVANÇADOS EM REDES DE COMPUTADORES');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (45, false, 0, 0, 'QXD0055', 0, 'INTRODUÇÃO A COMPUTAÇÃO E ENGENHARIA DE SOFTWARE');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (46, false, 0, 0, 'QXD0056', 0, 'MATEMÁTICA BÁSICA');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (47, false, 0, 0, 'QXD0057', 0, 'INTRODUÇÃO A PROCESSO E REQUISITOS DE SOFTWARE');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (48, false, 0, 0, 'QXD0058', 0, 'PROJETO DETALHADO DE SOFTWARE');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (49, false, 0, 0, 'QXD0059', 0, 'REDES E SISTEMAS DISTRIBUÍDOS');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (50, false, 0, 0, 'QXD0060', 0, 'PROCESSOS DE SOFTWARE');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (51, false, 0, 0, 'QXD0061', 0, 'REQUISITOS DE SOFTWARE');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (52, false, 0, 0, 'QXD0062', 0, 'MANUTENÇÃO DE SOFTWARE');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (53, false, 0, 0, 'QXD0063', 0, 'VERIFICAÇÃO E VALIDAÇÃO');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (54, false, 0, 0, 'QXD0064', 0, 'ARQUITETURA DE SOFTWARE');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (55, false, 0, 0, 'QXD0065', 0, 'ESPECIFICAÇÃO FORMAL DE SOFTWARE');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (56, false, 0, 0, 'QXD0066', 0, 'GERÊNCIA DE CONFIGURAÇÃO');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (57, false, 0, 0, 'QXD0067', 0, 'LEITURA DE SOFTWARE');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (58, false, 0, 0, 'QXD0068', 0, 'REUSO DE SOFTWARE');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (59, false, 0, 0, 'QXD0074', 0, 'DESENVOLVIMENTO DE SOFTWARE CONCORRENTE');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (60, false, 0, 0, 'QXD0075', 0, 'REDES SOCIAIS');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (61, false, 0, 0, 'QXD0076', 0, 'SISTEMAS MULTIAGENTES');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (62, false, 0, 0, 'QXD0081', 0, 'INFORMATICA E ORGANIZAÇÃO DE COMPUTADORES');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (63, false, 0, 0, 'QXD0083', 0, 'MÉTODOS E TÉCNICAS DE PESQUISA');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (64, false, 0, 0, 'QXD0085', 0, 'ADMINISTRAÇÃO DE SISTEMAS OPERACIONAIS WINDOWS');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (65, false, 0, 0, 'QXD0086', 0, 'INTERNET E ARQUITETURA TCP/IP');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (66, false, 0, 0, 'QXD0087', 0, 'LABORATÓRIO EM INFRAESTRUTURA DE REDES DE COMPUTADORES');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (67, false, 0, 0, 'QXD0089', 0, 'REDES DE ALTA VELOCIDADE');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (68, false, 0, 0, 'QXD0090', 0, 'REDES DE COMUNICAÇÕES MÓVEIS');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (69, false, 0, 0, 'QXD0092', 0, 'SERVIÇOS DE REDES DE COMPUTADORES');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (70, false, 0, 0, 'QXD0093', 0, 'ANÁLISE DE DESEMPENHO DE REDES DE COMPUTADORES');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (71, false, 0, 0, 'QXD0094', 0, 'GESTÃO DE TECNOLOGIA DA INFORMAÇÃO E COMUNICAÇÃO');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (72, false, 0, 0, 'QXD0095', 0, 'PROJETO INTEGRADO EM REDES DE COMPUTADORES');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (73, false, 0, 0, 'QXD0099', 0, 'DESENVOLVIMENTO DE SOFTWARE PARA PERSISTÊNCIA');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (74, false, 0, 0, 'QXD0102', 0, 'DESENVOLVIMENTO DE SOFTWARE PARA DISPOSITIVOS MÓVEIS');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (75, false, 0, 0, 'QXD0107', 0, 'PROGRAMAÇÃO LINEAR');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (76, false, 0, 0, 'QXD0109', 0, 'PRÉ-CÁLCULO');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (77, false, 0, 0, 'QXD0113', 0, 'LINGUA BRASILEIRA DE SINAIS - LIBRAS');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (78, false, 0, 0, '1111111', 0, 'PRÁTICAS EM TECNOLOGIA DA INFORMAÇÃO I');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (79, false, 0, 0, '1111112', 0, 'PRÁTICAS EM TECNOLOGIA DA INFORMAÇÃO II');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (80, false, 0, 0, 'QXD0078', 0, 'INTRODUÇÃO AO DESENVOLVIMENTO DE JOGOS');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (81, false, 0, 0, 'PRG0002', 0, 'RELAÇOES ETNICO-RACIAIS E AFRICANIDADES');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (82, false, 0, 0, 'QXD0114', 0, 'PROGRAMAÇÃO FUNCIONAL');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (83, false, 0, 0, 'QXD0115', 0, 'ESTRUTURA DE DADOS AVANÇADA');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (84, false, 0, 0, 'QXD0110', 0, 'PROJETO DE PESQUISA CIENTÍFICA E TECNOLÓGICA');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (85, false, 0, 0, 'QXD0082', 0, 'MATEMÁTICA COMPUTACIONAL RC');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (86, false, 0, 0, 'QXD0069', 0, 'SEGURANÇA ES CC');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (87, false, 0, 0, 'QXD0091', 0, 'SEGURANÇA DA INFORMAÇÃO RC');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (88, false, 0, 0, 'QXD0045', 0, 'SOCIOLOGIA SI');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (89, false, 0, 0, 'QXD0077', 0, 'MÉTODOS E FERRAMENTAS DA ENGENHARIA DE SOFTWARE');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (90, false, 0, 0, 'QXD0015', 0, 'GESTÃO DA INFORMAÇÃO E DOS SISTEMAS DE INFORMAÇÃO E GESTÃO DA INF E CONHEC');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (91, false, 0, 0, 'QXD0106', 0, 'GOVERNANÇA ESTRATÉGICA DE TECNOLOGIA DA INFORMAÇÃO E GESTÃO DE TI');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (92, false, 0, 0, 'QXD0103', 0, 'ÉTICA DIREITO E LEGISLAÇÃO CC EC RC');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (93, false, 0, 0, 'QXD0054', 0, 'ÉTICA NORMAS E POSTURA PROFISSIONAL ES');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (94, false, 0, 0, 'QXD0168', 0, 'ALGORITMOS PROBABILÍSTICOS');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (95, false, 0, 0, 'QXD0185', 0, 'ANALISE E DESEMPENHO DE SISTEMAS');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (96, false, 0, 0, 'QXD0049', 0, 'TRABALHO COOPERATIVO BASEADO EM COMPUTADORES');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (97, false, 0, 0, 'QXD0073', 0, 'EXPERIMENTAÇÃO EM ENGENHARIA DE SOFTWARE');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (98, false, 0, 0, 'QXD0072', 0, 'INTEGRAÇÃO DE APLICAÇÕES');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (99, false, 0, 0, 'QXD0071', 0, 'ESTIMATIVA DE CUSTOS EM PROJETOS DE SOFTWARE');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (100, false, 0, 0, 'QXD0005', 0, 'TOPICOS ESPECIAIS I SI');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (101, false, 0, 0, 'QXD0051', 0, 'TOPICOS ESPECIAIS II SI');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (102, false, 0, 0, 'QXD0053', 0, 'TOPICOS ESPECIAIS IV SI ES');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (103, false, 0, 0, 'QXD0052', 0, 'TOPICOS ESPECIAIS III SI ES');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (104, false, 0, 0, 'PRG0004', 0, 'EDUCAÇÃO EM DIREITOS HUMANOS');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (105, false, 0, 0, 'QXD0154', 0, 'GESTÃO DE PROCESSOS DE NEGÓCIOS');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (106, false, 0, 0, 'PRG0005', 0, 'DIFERENÇA E ENFRENTAMENTO PROFISSIONAL NAS DESIGUALDADES SOCIAIS');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (107, false, 0, 0, 'QXD0170', 0, 'CRIPTOGRAFIA');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (108, false, 0, 0, 'QXD0116', 0, 'ÁLGEBRA LINEAR');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (109, false, 0, 0, 'QXD0119', 0, 'COMPUTAÇÃO GRÁFICA');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (110, false, 0, 0, 'QXD0121', 0, 'DESENHO I');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (111, false, 0, 0, 'QXD0122', 0, 'HISTÓRIA DA ARTE');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (112, false, 0, 0, 'QXD0123', 0, 'EDIÇÃO DIGITAL DE IMAGENS');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (113, false, 0, 0, 'QXD0124', 0, 'MULTIMÍDIA');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (114, false, 0, 0, 'QXD0125', 0, 'INTRODUÇÃO À PROGRAMAÇÃO PARA DESIGN');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (115, false, 0, 0, 'QXD0126', 0, 'PSICOLOGIA E PERCEPÇÃO');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (116, false, 0, 0, 'QXD0127', 0, 'COMUNICAÇÃO VISUAL I');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (117, false, 0, 0, 'QXD0128', 0, 'DESENHO II');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (118, false, 0, 0, 'QXD0129', 0, 'PROGRAMAÇÃO PARA DESIGN');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (119, false, 0, 0, 'QXD0130', 0, 'HISTÓRIA DO DESIGN');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (120, false, 0, 0, 'QXD0159', 0, 'MODELAGEM TRIDIMENSIONAL');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (121, false, 0, 0, 'QXD0162', 0, 'SOCIEDADE   CULTURA E TECNOLOGIAS');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (122, false, 0, 0, 'QXD0163', 0, 'COMUNICAÇÃO VISUAL II');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (123, false, 0, 0, 'QXD0164', 0, 'LINGUAGENS DE MARCAÇÃO E SCRIPTS');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (124, false, 0, 0, 'QXD0166', 0, 'DIREÇÃO DE ARTE');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (125, false, 0, 0, 'QXD0191', 0, 'TIPOGRAFIA');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (126, false, 0, 0, 'QXD0117', 0, 'CIRCUITOS DIGITAIS');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (127, false, 0, 0, 'QXD0118', 0, 'INTRODUÇÃO À ENGENHARIA DE COMPUTAÇÃO');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (128, false, 0, 0, 'QXD0142', 0, 'INTRODUÇÃO À ARQUITETURA DE COMPUTADORES');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (129, false, 0, 0, 'QXD0132', 0, 'ARQUITETURA E ORGANIZAÇÃO DE COMPUTADORES I');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (130, false, 0, 0, 'QXD0147', 0, 'SISTEMAS OPERACIONAIS I');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (131, false, 0, 0, 'QXD0149', 0, 'TÉCNICAS DE PROGRAMAÇÃO PARA SISTEMAS EMBARCADOS I');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (132, false, 0, 0, 'QXD0133', 0, 'ARQUITETURA E ORGANIZAÇÃO DE COMPUTADORES II');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (133, false, 0, 0, 'QXD0140', 0, 'EQUAÇÕES DIFERENCIAIS');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (134, false, 0, 0, 'QXD0148', 0, 'SISTEMAS OPERACIONAIS II');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (135, false, 0, 0, 'QXD0150', 0, 'TÉCNICAS DE PROGRAMAÇÃO PARA SISTEMAS EMBARCADOS II');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (136, false, 0, 0, 'QXD0131', 0, 'ANÁLISE DE CIRCUITOS');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (137, false, 0, 0, 'QXD0136', 0, 'ELETRICIDADE E MAGNETISMO');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (138, false, 0, 0, 'QXD0139', 0, 'ENGENHARIA DE SOFTWARE EC');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (139, false, 0, 0, 'QXD0146', 0, 'SISTEMAS DIGITAIS PARA COMPUTADORES');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (140, false, 0, 0, 'QXD0137', 0, 'ELETRÔNICA FUNDAMENTAL I');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (141, false, 0, 0, 'QXD0144', 0, 'SINAIS E SISTEMAS');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (142, false, 0, 0, 'QXD0138', 0, 'ELETRÔNICA FUNDAMENTAL II');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (143, false, 0, 0, 'QXD0151', 0, 'SISTEMAS DE AUTOMAÇÃO E CONTROLE');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (144, false, 0, 0, 'QXD0141', 0, 'INSTRUMENTAÇÃO');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (145, false, 0, 0, 'QXD0145', 0, 'SISTEMAS DE TEMPO REAL');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (146, false, 0, 0, 'QXD0135', 0, 'CÁLCULO DIFERENCIAL E INTEGRAL III');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (147, false, 0, 0, 'QXD0079', 0, 'COMPUTAÇÃO EM NUVEM');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (148, false, 0, 0, 'QXD0120', 0, 'MATEMÁTICA COMPUTACIONAL CC');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (149, false, 0, 0, 'QXD0096', 0, 'PROJETO DE PESQUISA CIENTÍFICA E TECNOLÓGICA RC');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (150, false, 0, 0, 'QXD0201', 0, 'ENGENHARIA SEMIÓTICA DD');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (151, false, 0, 0, 'QXD0152', 0, 'TEORIA DOS GRAFOS');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (152, false, 0, 0, '9990000', 0, 'SISTEMAS EMBARCADOS');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (153, false, 0, 0, 'QXD0202', 0, 'ERGONOMIA');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (154, false, 0, 0, 'QXD0004', 0, 'TEORIA GERAL DA ADMINISTRAÇÃO INTROD ADM');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (155, false, 0, 0, 'BCQ0002', 0, 'BCQ EDIÇÕES ANTERIORES');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (156, false, 0, 0, 'QXD0206', 0, 'MARKETING DD');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (157, false, 0, 0, 'QXD0030', 0, 'ÉTICA DIREITO E LEGISLAÇÃO SI');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (158, false, 0, 0, 'BCQ0003', 0, 'BCQ TECNICO COM EXEMPLAR UNICO E NAO PODE SER COMPLEMENTAR');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (159, false, 0, 0, 'BCQ0004', 0, 'BCQ VERIFICAR');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (160, false, 0, 0, 'QXD0161', 0, 'SEMIÓTICA DD');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (161, false, 0, 0, 'QXD0209', 0, 'REALIDADE VIRTUAL DD');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (162, false, 0, 0, 'BCQ0005', 0, 'BCQ COMPLEMENTA QUANTIDADE');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (163, false, 0, 0, 'BCQ0001', 0, 'BCQ LITERATURA E TÉCNICO');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (164, false, 0, 0, 'BCQ0006', 0, 'BCQ DISPONÍVEL MAS NÃO ALOCADO EM');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (165, false, 0, 0, 'QXD0134', 0, 'CÁLCULO DIFERENCIAL E INTEGRAL II');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (166, false, 0, 0, 'QXD0176', 0, 'APRENDIZADO DE MÁQUINA');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (167, false, 0, 0, 'QXD0183', 0, 'COMPUTAÇÃO PARALELA');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (168, false, 0, 0, 'QXD0186', 0, 'CÁLCULO NUMÉRICO');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (169, false, 0, 0, 'QXD0179', 0, 'ESTATÍSTICA MULTIVARIADA');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (170, false, 0, 0, 'QXD0180', 0, 'FÍSICA I');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (171, false, 0, 0, 'QXD0172', 0, 'LÓGICA MODAL');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (172, false, 0, 0, 'QXD0178', 0, 'MINERAÇÃO DE DADOS');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (173, false, 0, 0, 'QXD0169', 0, 'MODELAGEM E SIMULAÇÃO DISCRETA DE SISTEMA');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (174, false, 0, 0, 'QXD0171', 0, 'OTIMIZAÇÃO COMBINATÓRIA');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (175, false, 0, 0, 'QXD0181', 0, 'PESQUISA OPERACIONAL');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (176, false, 0, 0, 'QXD0188', 0, 'PROCESSAMENTO DE IMAGEM');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (177, false, 0, 0, 'QXD0184', 0, 'REALIDADE VIRTUAL CC');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (178, false, 0, 0, 'QXD0177', 0, 'RECUPERAÇÃO DE INFORMAÇÃO');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (179, false, 0, 0, 'QXD0167', 0, 'TEORIA DA PROVA');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (180, false, 0, 0, 'QXD0182', 0, 'VISÃO COMPUTACIONAL');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (181, false, 0, 0, 'QXD0153', 0, 'DESAFIOS DE PROGRAMAÇÃO');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (182, false, 0, 0, 'QXD0084', 0, 'ADMINISTRAÇÃO DE SISTEMAS OPERACIONAIS LINUX');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (183, false, 0, 0, 'QXD0199', 0, 'ARQUITETURA DA INFORMAÇÃO');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (184, false, 0, 0, 'QXD0204', 0, 'CINEMA E ANIMAÇÃO');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (185, false, 0, 0, 'QXD0189', 0, 'AVALIAÇÃO DA INTERAÇÃO HUMANO COMPUTADOR');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (186, false, 0, 0, 'QXD0197', 0, 'PROJETO DE INTERFACES PARA DISPOSITIVOS MÓVEIS');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (187, false, 0, 0, 'QXD0203', 0, 'FOTOGRAFIA');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (188, false, 0, 0, 'QXD0198', 0, 'CONCEPÇÃO E DESENVOLVIMENTO DE PRODUTOS');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (189, false, 0, 0, 'QXD0195', 0, 'DESIGN E INOVAÇÃO');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (190, false, 0, 0, 'QXD0193', 0, 'PROJETO DE INTERFACES WEB');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (191, false, 0, 0, 'QXD0208', 0, 'PROTOTIPAÇÃO RÁPIDA');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (192, false, 0, 0, 'QXD0192', 0, 'PROCESSOS DE CRIAÇÃO');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (193, false, 0, 0, 'QXD0194', 0, 'ÉTICA E LEGISLAÇÃO DD');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (194, false, 0, 0, 'QXD0205', 0, 'JOGOS ELETRÔNICOS');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (195, false, 0, 0, 'QXD0200', 0, 'DESIGN DE SISTEMAS  COLABORATIVOS');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (196, false, 0, 0, 'QXD0210', 0, 'SOCIOLOGIA E ANTROPOLOGIA DD');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (197, false, 0, 0, 'QXD0211', 0, 'USER EXPERIENCE UX');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (198, false, 0, 0, 'QXD0207', 0, 'PRÁTICAS EM DESIGN I');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (199, false, 0, 0, 'QXD0143', 0, 'MICROCONTROLADORES');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (200, false, 0, 0, 'QXD0212', 0, 'SEMINÁRIOS DD');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (201, false, 0, 0, 'QXD0160', 0, 'PROJETO INTEGRADO I DD');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (202, false, 0, 0, 'QXD0165', 0, 'PROJETO INTEGRADO II DD');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (203, false, 0, 0, 'QXD0190', 0, 'PROJETO INTEGRADO III DD');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (204, false, 0, 0, 'QXD0196', 0, 'PROJETO INTEGRADO IV DD');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (205, false, 0, 0, 'BCQ2016', 0, 'BCQ COMPRAR');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (206, false, 0, 0, 'QXD0088', 0, 'PROGRAMAÇÃO DE SCRIPTS');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (207, false, 120, 40, 'QXD0155', 0, 'ESTÁGIO SUPERVISIONADO I - CC');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (208, false, 120, 40, 'QXD0156', 0, 'ESTÁGIO SUPERVISIONADO II - CC');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (209, false, 0, 0, 'QXD0187', 0, 'TOPICOS ESPECIAIS I CC');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (210, false, 0, 0, 'QXD0175', 0, 'TOPICOS ESPECIAIS II CC');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (211, false, 0, 0, 'QXD0174', 0, 'TOPICOS ESPECIAIS III CC');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (212, false, 0, 0, 'QXD0173', 0, 'TOPICOS ESPECIAIS IV CC');
INSERT INTO disciplina (id, arquivada, carga_horaria_pratica, carga_horaria_teorica, codigo, creditos, nome) VALUES (213, false, 48, 16, 'PRG0003', 0, 'EDUCAÇAO AMBIENTAL');



-- PERIODOS
-- INSERT INTO periodo( id, ano, semestre, status) VALUES (?, ?, ?, ?);

INSERT INTO periodo (id, ano, semestre, status) VALUES (1, '2016', '1', 'CONSOLIDADA');
INSERT INTO periodo (id, ano, semestre, status) VALUES (2, '2016', '2', 'CONSOLIDADA');
INSERT INTO periodo (id, ano, semestre, status) VALUES (3, '2017', '1', 'CONSOLIDADA');
INSERT INTO periodo (id, ano, semestre, status) VALUES (4, '2017', '2', 'ABERTA');



-- OFERTAS
-- INSERT INTO oferta(id,  id, observacao, turno, vagas, disciplina_id, periodo_id, turma_id) INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (?, ?, ?, ?, ?, ?, ?);

-- CC 1
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (1, 'MANHA', 55, 4, 3, 23);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (2, 'MANHA', 55, 46, 3, 23);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (3, 'MANHA', 55, 92, 3, 23);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (4, 'MANHA', 55, 1, 3, 23);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (5, 'MANHA', 55, 2, 3, 23);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (6, 'TARDE', 55, 76, 3, 23);

-- CC 2
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (7, 'MANHA', 20, 7, 3, 24);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (8, 'NOITE', 15, 6, 3, 24);

-- CC 3
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (9, 'MANHA', 40, 83, 3, 25);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (10, 'MANHA', 40, 11, 3, 25);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (11, 'MANHA', 40, 15, 3, 25);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (12, 'MANHA', 45, 82, 3, 25);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (13, 'MANHA', 35, 37, 3, 25);

-- CC 5
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (14, 'MANHA', 20, 23, 3, 27);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (15, 'MANHA', 30, 18, 3, 27);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (16, 'MANHA', 30, 148, 3, 27);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (17, 'MANHA', 40, 19, 3, 27);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (18, 'MANHA', 20, 36, 3, 27);

-- CC 7
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (19, 'MANHA', 20, 27, 3, 29);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (20, 'MANHA', 11, 84, 3, 29);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (21, 'TARDE', 20, 181, 3, 29);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (22, 'TARDE', 15, 171, 3, 29);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (23, 'NOITE', 15, 176, 3, 29);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (24, 'NOITE', 15, 167, 3, 29);

-- ########################################################################################################

-- SI 1
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (25, 'MANHA', 55, 154, 3, 1);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (26, 'MANHA', 55, 76, 3, 1);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (27, 'MANHA', 30, 2, 3, 1);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (28, 'MANHA', 30, 2, 3, 1);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (29, 'MANHA', 55, 3, 3, 1);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (30, 'MANHA', 55, 46, 3, 1);

-- SI 3
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (31, 'MANHA', 35, 96, 3, 3);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (32, 'MANHA', 45, 12, 3, 3);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (33, 'MANHA', 35, 9, 3, 3);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (34, 'MANHA', 40, 10, 3, 3);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (35, 'MANHA', 45, 11, 3, 3);

-- SI 5
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (36, 'MANHA', 45, 17, 3, 5);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (37, 'MANHA', 45, 19, 3, 5);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (38, 'MANHA', 40, 18, 3, 5);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (39, 'MANHA', 45, 16, 3, 5);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (40, 'MANHA', 30, 22, 3, 5);

-- SI 7
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (41, 'MANHA', 20, 39, 3, 7);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (42, 'MANHA', 20, 36, 3, 7);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (43, 'MANHA', 25, 25, 3, 7);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (44, 'MANHA', 25, 84, 3, 7);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (45, 'TARDE', 25, 207, 3, 7);

-- ########################################################################################################

-- ES 1
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (46, 'MANHA', 60, 45, 3, 9);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (47, 'MANHA', 55, 93, 3, 9);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (48, 'MANHA', 55, 2, 3, 9);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (49, 'MANHA', 55, 46, 3, 9);

-- ES 2
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (50, 'NOITE', 25, 7, 3, 10);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (51, 'NOITE', 20, 7, 3, 10);

-- ES 3
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (52, 'TARDE', 45, 27, 3, 11);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (53, 'TARDE', 45, 14, 3, 11);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (54, 'TARDE', 50, 12, 3, 11);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (55, 'TARDE', 45, 9, 3, 11);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (56, 'TARDE', 45, 13, 3, 11);

-- ES 5
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (57, 'TARDE', 30, 18, 3, 13);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (58, 'TARDE', 30, 51, 3, 13);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (59, 'TARDE', 40, 53, 3, 13);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (60, 'TARDE', 40, 38, 3, 13);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (61, 'TARDE', 50, 50, 3, 13);

-- ES 7
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (62, 'TARDE', 30, 147, 3, 15);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (63, 'TARDE', 30, 56, 3, 15);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (64, 'TARDE', 0, 58, 3, 15);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (65, 'TARDE', 30, 80, 3, 15);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (66, 'TARDE', 30, 84, 3, 15);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (67, 'MANHA', 0, 59, 3, 15);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (68, 'MANHA', 0, 207, 3, 15);

-- ########################################################################################################

-- EC 1
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (69, 'TARDE', 60, 2, 3, 39);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (70, 'TARDE', 55, 46, 3, 39);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (71, 'TARDE', 60, 126, 3, 39);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (72, 'TARDE', 50, 127, 3, 39);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (73, 'TARDE', 50, 92, 3, 39);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (74, 'TARDE', 50, 76, 3, 39);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (75, 'TARDE', 20, 76, 3, 39);

-- EC 2
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (76, 'TARDE', 35, 108, 3, 40);

-- EC 3
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (77, 'TARDE', 50, 100, 3, 41);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (78, 'TARDE', 50, 129, 3, 41);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (79, 'TARDE', 50, 165, 3, 41);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (80, 'TARDE', 50, 130, 3, 41);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (81, 'TARDE', 50, 11, 3, 41);

-- EC 5
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (82, 'TARDE', 20, 199, 3, 43);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (83, 'TARDE', 30, 139, 3, 43);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (84, 'TARDE', 20, 136, 3, 43);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (85, 'TARDE', 50, 15, 3, 43);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (86, 'TARDE', 20, 137, 3, 43);
INSERT INTO oferta(id, turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (87, 'TARDE', 20, 138, 3, 43);

