-- CURSOS
INSERT INTO curso (id, codigo, nome, sigla) VALUES (1, 401, 'Sistemas de Informação', 'SI');
INSERT INTO curso (id, codigo, nome, sigla) VALUES (2, 402, 'Engenharia de Software', 'ES');
INSERT INTO curso (id, codigo, nome, sigla) VALUES (3, 403, 'Redes de Computadores', 'RC');
INSERT INTO curso (id, codigo, nome, sigla) VALUES (4, 404, 'Ciência da Computação', 'CC');
INSERT INTO curso (id, codigo, nome, sigla) VALUES (5, 406, 'Design Digital', 'DD');
INSERT INTO curso (id, codigo, nome, sigla) VALUES (6, 405, 'Engenharia de Computação', 'EC');

-- SISTEMAS DE INFORMAÇÃO
INSERT INTO turma(semestre, curso_id) VALUES (1, 1);
INSERT INTO turma(semestre, curso_id) VALUES (2, 1);	
INSERT INTO turma(semestre, curso_id) VALUES (3, 1);
INSERT INTO turma(semestre, curso_id) VALUES (4, 1);
INSERT INTO turma(semestre, curso_id) VALUES (5, 1);
INSERT INTO turma(semestre, curso_id) VALUES (6, 1);
INSERT INTO turma(semestre, curso_id) VALUES (7, 1);
INSERT INTO turma(semestre, curso_id) VALUES (8, 1);

-- ENGENHARIA DE SOFTWARE
INSERT INTO turma(semestre, curso_id) VALUES (1, 2);
INSERT INTO turma(semestre, curso_id) VALUES (2, 2);
INSERT INTO turma(semestre, curso_id) VALUES (3, 2);
INSERT INTO turma(semestre, curso_id) VALUES (4, 2);
INSERT INTO turma(semestre, curso_id) VALUES (5, 2);
INSERT INTO turma(semestre, curso_id) VALUES (6, 2);
INSERT INTO turma(semestre, curso_id) VALUES (7, 2);
INSERT INTO turma(semestre, curso_id) VALUES (8, 2);

-- REDES DE COMPUTADORES
INSERT INTO turma(semestre, curso_id) VALUES (1, 3);
INSERT INTO turma(semestre, curso_id) VALUES (2, 3);
INSERT INTO turma(semestre, curso_id) VALUES (3, 3);
INSERT INTO turma(semestre, curso_id) VALUES (4, 3);
INSERT INTO turma(semestre, curso_id) VALUES (5, 3);
INSERT INTO turma(semestre, curso_id) VALUES (6, 3);

-- CIÊNCIA DA COMPUTAÇÃO
INSERT INTO turma(semestre, curso_id) VALUES (1, 4);
INSERT INTO turma(semestre, curso_id) VALUES (2, 4);
INSERT INTO turma(semestre, curso_id) VALUES (3, 4);
INSERT INTO turma(semestre, curso_id) VALUES (4, 4);
INSERT INTO turma(semestre, curso_id) VALUES (5, 4);
INSERT INTO turma(semestre, curso_id) VALUES (6, 4);
INSERT INTO turma(semestre, curso_id) VALUES (7, 4);
INSERT INTO turma(semestre, curso_id) VALUES (7, 4);

-- DESIGN DIGITAL
INSERT INTO turma(semestre, curso_id) VALUES (1, 5);
INSERT INTO turma(semestre, curso_id) VALUES (2, 5);
INSERT INTO turma(semestre, curso_id) VALUES (3, 5);
INSERT INTO turma(semestre, curso_id) VALUES (4, 5);
INSERT INTO turma(semestre, curso_id) VALUES (5, 5);
INSERT INTO turma(semestre, curso_id) VALUES (6, 5);
INSERT INTO turma(semestre, curso_id) VALUES (7, 5);
INSERT INTO turma(semestre, curso_id) VALUES (8, 5);

-- ENGENHARIA DA COMPUTAÇÃO
INSERT INTO turma(semestre, curso_id) VALUES (1, 6);
INSERT INTO turma(semestre, curso_id) VALUES (2, 6);
INSERT INTO turma(semestre, curso_id) VALUES (3, 6);
INSERT INTO turma(semestre, curso_id) VALUES (4, 6);
INSERT INTO turma(semestre, curso_id) VALUES (5, 6);
INSERT INTO turma(semestre, curso_id) VALUES (6, 6);
INSERT INTO turma(semestre, curso_id) VALUES (7, 6);
INSERT INTO turma(semestre, curso_id) VALUES (8, 6);
INSERT INTO turma(semestre, curso_id) VALUES (9, 6);
INSERT INTO turma(semestre, curso_id) VALUES (10, 6);

-- DISCIPLINAS
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0108', 'INTRODUÇÃO À CIÊNCIA DA COMPUTAÇÃO', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0001', 'FUNDAMENTOS DE PROGRAMAÇÃO', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0002', 'INTRODUÇÃO A CIÊNCIA DA COMPUTAÇÃO E SISTEMAS DE INFORMAÇÃO', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0005', 'ARQUITETURA DE COMPUTADORES', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0006', 'CÁLCULO DIFERENCIAL E INTEGRAL I', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0007', 'PROGRAMAÇÃO ORIENTADA A OBJETOS', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0008', 'MATEMÁTICA DISCRETA', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0009', 'TEORIA GERAL DE SISTEMAS', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0010', 'ESTRUTURA DE DADOS', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0011', 'FUNDAMENTOS DE BANCO DE DADOS', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0012', 'PROBABILIDADE E ESTATÍSTICA', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0013', 'SISTEMAS OPERACIONAIS', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0014', 'ANÁLISE E PROJETO DE SISTEMAS', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0016', 'LINGUAGENS DE PROGRAMAÇÃO', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0017', 'LÓGICA PARA COMPUTAÇÃO', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0018', 'CONSTRUÇÃO DE SISTEMAS DE GERÊNCIA DE BANCO DE DADOS', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0019', 'ENGENHARIA DE SOFTWARE', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0020', 'DESENVOLVIMENTO DE SOFTWARE PARA WEB', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0021', 'REDES DE COMPUTADORES', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0022', 'AUDITORIA DE SEGURANÇA DE SISTEMAS DE INFORMAÇÃO', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0023', 'GERÊNCIA DE PROJETOS DE SOFTWARE', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0024', 'AVALIAÇÃO DE SISTEMAS', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0025', 'COMPILADORES', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0026', 'CONTABILIDADE E CUSTOS', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0027', 'E-BUSINESS', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0028', 'ECONOMIA E FINANÇAS', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0029', 'EMPREENDEDORISMO', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0031', 'FILOSOFIA DA CIÊNCIA', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0032', 'FUNÇÕES EMPRESARIAIS', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0033', 'GERÊNCIA DE REDES', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0034', 'GERÊNCIA DE PROJETOS', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0035', 'INGLÊS INSTRUMENTAL I', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0036', 'INGLÊS INSTRUMENTAL II', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0037', 'INTELIGÊNCIA ARTIFICIAL', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0038', 'INTERFACE HUMANO-COMPUTADOR', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0039', 'INTRODUÇÃO A COMPUTAÇÃO GRAFICA', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0040', 'LINGUAGENS FORMAIS E AUTOMATOS', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0041', 'PROJETO E ANALISE DE ALGORITMOS', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0042', 'QUALIDADE DE SOFTWARE', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0043', 'SISTEMAS DISTRIBUIDOS', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0044', 'SISTEMAS MULTIMIDIA', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0046', 'TEORIA DA COMPUTAÇÃO', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0047', 'TOPICOS AVANÇADOS EM BANCO DE DADOS', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0048', 'TOPICOS AVANÇADOS EM REDES DE COMPUTADORES', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0055', 'INTRODUÇÃO A COMPUTAÇÃO E ENGENHARIA DE SOFTWARE', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0056', 'MATEMÁTICA BÁSICA', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0057', 'INTRODUÇÃO A PROCESSO E REQUISITOS DE SOFTWARE', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0058', 'PROJETO DETALHADO DE SOFTWARE', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0059', 'REDES E SISTEMAS DISTRIBUÍDOS', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0060', 'PROCESSOS DE SOFTWARE', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0061', 'REQUISITOS DE SOFTWARE', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0062', 'MANUTENÇÃO DE SOFTWARE', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0063', 'VERIFICAÇÃO E VALIDAÇÃO', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0064', 'ARQUITETURA DE SOFTWARE', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0065', 'ESPECIFICAÇÃO FORMAL DE SOFTWARE', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0066', 'GERÊNCIA DE CONFIGURAÇÃO', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0067', 'LEITURA DE SOFTWARE', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0068', 'REUSO DE SOFTWARE', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0074', 'DESENVOLVIMENTO DE SOFTWARE CONCORRENTE', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0075', 'REDES SOCIAIS', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0076', 'SISTEMAS MULTIAGENTES', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0081', 'INFORMATICA E ORGANIZAÇÃO DE COMPUTADORES', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0083', 'MÉTODOS E TÉCNICAS DE PESQUISA', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0085', 'ADMINISTRAÇÃO DE SISTEMAS OPERACIONAIS WINDOWS', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0086', 'INTERNET E ARQUITETURA TCP/IP', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0087', 'LABORATÓRIO EM INFRAESTRUTURA DE REDES DE COMPUTADORES', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0089', 'REDES DE ALTA VELOCIDADE', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0090', 'REDES DE COMUNICAÇÕES MÓVEIS', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0092', 'SERVIÇOS DE REDES DE COMPUTADORES', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0093', 'ANÁLISE DE DESEMPENHO DE REDES DE COMPUTADORES', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0094', 'GESTÃO DE TECNOLOGIA DA INFORMAÇÃO E COMUNICAÇÃO', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0095', 'PROJETO INTEGRADO EM REDES DE COMPUTADORES', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0099', 'DESENVOLVIMENTO DE SOFTWARE PARA PERSISTÊNCIA', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0102', 'DESENVOLVIMENTO DE SOFTWARE PARA DISPOSITIVOS MÓVEIS', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0107', 'PROGRAMAÇÃO LINEAR', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0109', 'PRÉ-CÁLCULO', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0113', 'LINGUA BRASILEIRA DE SINAIS - LIBRAS', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, '1111111', 'PRÁTICAS EM TECNOLOGIA DA INFORMAÇÃO I', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, '1111112', 'PRÁTICAS EM TECNOLOGIA DA INFORMAÇÃO II', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0078', 'INTRODUÇÃO AO DESENVOLVIMENTO DE JOGOS', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'PRG0002', 'RELAÇOES ETNICO-RACIAIS E AFRICANIDADES', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0114', 'PROGRAMAÇÃO FUNCIONAL', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0115', 'ESTRUTURA DE DADOS AVANÇADA', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0110', 'PROJETO DE PESQUISA CIENTÍFICA E TECNOLÓGICA', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0082', 'MATEMÁTICA COMPUTACIONAL RC', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0069', 'SEGURANÇA ES CC', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0091', 'SEGURANÇA DA INFORMAÇÃO RC', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0045', 'SOCIOLOGIA SI', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0077', 'MÉTODOS E FERRAMENTAS DA ENGENHARIA DE SOFTWARE', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0015', 'GESTÃO DA INFORMAÇÃO E DOS SISTEMAS DE INFORMAÇÃO E GESTÃO DA INF E CONHEC', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0106', 'GOVERNANÇA ESTRATÉGICA DE TECNOLOGIA DA INFORMAÇÃO E GESTÃO DE TI', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0103', 'ÉTICA DIREITO E LEGISLAÇÃO CC EC RC', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0054', 'ÉTICA NORMAS E POSTURA PROFISSIONAL ES', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0168', 'ALGORITMOS PROBABILÍSTICOS', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0185', 'ANALISE E DESEMPENHO DE SISTEMAS', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0049', 'TRABALHO COOPERATIVO BASEADO EM COMPUTADORES', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0073', 'EXPERIMENTAÇÃO EM ENGENHARIA DE SOFTWARE', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0072', 'INTEGRAÇÃO DE APLICAÇÕES', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0071', 'ESTIMATIVA DE CUSTOS EM PROJETOS DE SOFTWARE', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0005', 'TOPICOS ESPECIAIS I SI', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0051', 'TOPICOS ESPECIAIS II SI', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0053', 'TOPICOS ESPECIAIS IV SI ES', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0052', 'TOPICOS ESPECIAIS III SI ES', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'PRG0004', 'EDUCAÇÃO EM DIREITOS HUMANOS', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0154', 'GESTÃO DE PROCESSOS DE NEGÓCIOS', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'PRG0005', 'DIFERENÇA E ENFRENTAMENTO PROFISSIONAL NAS DESIGUALDADES SOCIAIS', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0170', 'CRIPTOGRAFIA', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0116', 'ÁLGEBRA LINEAR', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0119', 'COMPUTAÇÃO GRÁFICA', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0121', 'DESENHO I', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0122', 'HISTÓRIA DA ARTE', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0123', 'EDIÇÃO DIGITAL DE IMAGENS', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0124', 'MULTIMÍDIA', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0125', 'INTRODUÇÃO À PROGRAMAÇÃO PARA DESIGN', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0126', 'PSICOLOGIA E PERCEPÇÃO', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0127', 'COMUNICAÇÃO VISUAL I', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0128', 'DESENHO II', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0129', 'PROGRAMAÇÃO PARA DESIGN', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0130', 'HISTÓRIA DO DESIGN', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0159', 'MODELAGEM TRIDIMENSIONAL', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0162', 'SOCIEDADE   CULTURA E TECNOLOGIAS', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0163', 'COMUNICAÇÃO VISUAL II', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0164', 'LINGUAGENS DE MARCAÇÃO E SCRIPTS', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0166', 'DIREÇÃO DE ARTE', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0191', 'TIPOGRAFIA', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0117', 'CIRCUITOS DIGITAIS', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0118', 'INTRODUÇÃO À ENGENHARIA DE COMPUTAÇÃO', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0142', 'INTRODUÇÃO À ARQUITETURA DE COMPUTADORES', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0132', 'ARQUITETURA E ORGANIZAÇÃO DE COMPUTADORES I', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0147', 'SISTEMAS OPERACIONAIS I', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0149', 'TÉCNICAS DE PROGRAMAÇÃO PARA SISTEMAS EMBARCADOS I', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0133', 'ARQUITETURA E ORGANIZAÇÃO DE COMPUTADORES II', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0140', 'EQUAÇÕES DIFERENCIAIS', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0148', 'SISTEMAS OPERACIONAIS II', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0150', 'TÉCNICAS DE PROGRAMAÇÃO PARA SISTEMAS EMBARCADOS II', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0131', 'ANÁLISE DE CIRCUITOS', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0136', 'ELETRICIDADE E MAGNETISMO', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0139', 'ENGENHARIA DE SOFTWARE EC', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0146', 'SISTEMAS DIGITAIS PARA COMPUTADORES', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0137', 'ELETRÔNICA FUNDAMENTAL I', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0144', 'SINAIS E SISTEMAS', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0138', 'ELETRÔNICA FUNDAMENTAL II', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0151', 'SISTEMAS DE AUTOMAÇÃO E CONTROLE', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0141', 'INSTRUMENTAÇÃO', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0145', 'SISTEMAS DE TEMPO REAL', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0135', 'CÁLCULO DIFERENCIAL E INTEGRAL III', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0079', 'COMPUTAÇÃO EM NUVEM', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0120', 'MATEMÁTICA COMPUTACIONAL CC', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0096', 'PROJETO DE PESQUISA CIENTÍFICA E TECNOLÓGICA RC', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0201', 'ENGENHARIA SEMIÓTICA DD', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0152', 'TEORIA DOS GRAFOS', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, '9990000', 'SISTEMAS EMBARCADOS', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0202', 'ERGONOMIA', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0004', 'TEORIA GERAL DA ADMINISTRAÇÃO INTROD ADM', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'BCQ0002', 'BCQ EDIÇÕES ANTERIORES', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0206', 'MARKETING DD', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0030', 'ÉTICA DIREITO E LEGISLAÇÃO SI', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'BCQ0003', 'BCQ TECNICO COM EXEMPLAR UNICO E NAO PODE SER COMPLEMENTAR', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'BCQ0004', 'BCQ VERIFICAR', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0161', 'SEMIÓTICA DD', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0209', 'REALIDADE VIRTUAL DD', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'BCQ0005', 'BCQ COMPLEMENTA QUANTIDADE', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'BCQ0001', 'BCQ LITERATURA E TÉCNICO', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'BCQ0006', 'BCQ DISPONÍVEL MAS NÃO ALOCADO EM', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0134', 'CÁLCULO DIFERENCIAL E INTEGRAL II', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0176', 'APRENDIZADO DE MÁQUINA', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0183', 'COMPUTAÇÃO PARALELA', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0186', 'CÁLCULO NUMÉRICO', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0179', 'ESTATÍSTICA MULTIVARIADA', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0180', 'FÍSICA I', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0172', 'LÓGICA MODAL', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0178', 'MINERAÇÃO DE DADOS', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0169', 'MODELAGEM E SIMULAÇÃO DISCRETA DE SISTEMA', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0171', 'OTIMIZAÇÃO COMBINATÓRIA', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0181', 'PESQUISA OPERACIONAL', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0188', 'PROCESSAMENTO DE IMAGEM', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0184', 'REALIDADE VIRTUAL CC', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0177', 'RECUPERAÇÃO DE INFORMAÇÃO', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0167', 'TEORIA DA PROVA', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0182', 'VISÃO COMPUTACIONAL', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0153', 'DESAFIOS DE PROGRAMAÇÃO', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0084', 'ADMINISTRAÇÃO DE SISTEMAS OPERACIONAIS LINUX', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0199', 'ARQUITETURA DA INFORMAÇÃO', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0204', 'CINEMA E ANIMAÇÃO', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0189', 'AVALIAÇÃO DA INTERAÇÃO HUMANO COMPUTADOR', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0197', 'PROJETO DE INTERFACES PARA DISPOSITIVOS MÓVEIS', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0203', 'FOTOGRAFIA', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0198', 'CONCEPÇÃO E DESENVOLVIMENTO DE PRODUTOS', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0195', 'DESIGN E INOVAÇÃO', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0193', 'PROJETO DE INTERFACES WEB', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0208', 'PROTOTIPAÇÃO RÁPIDA', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0192', 'PROCESSOS DE CRIAÇÃO', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0194', 'ÉTICA E LEGISLAÇÃO DD', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0205', 'JOGOS ELETRÔNICOS', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0200', 'DESIGN DE SISTEMAS  COLABORATIVOS', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0210', 'SOCIOLOGIA E ANTROPOLOGIA DD', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0211', 'USER EXPERIENCE UX', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0207', 'PRÁTICAS EM DESIGN I', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0143', 'MICROCONTROLADORES', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0212', 'SEMINÁRIOS DD', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0160', 'PROJETO INTEGRADO I DD', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0165', 'PROJETO INTEGRADO II DD', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0190', 'PROJETO INTEGRADO III DD', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0196', 'PROJETO INTEGRADO IV DD', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'BCQ2016', 'BCQ COMPRAR', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0088', 'PROGRAMAÇÃO DE SCRIPTS', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 120, 40, 'QXD0155', 'ESTÁGIO SUPERVISIONADO I - CC', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 120, 40, 'QXD0156', 'ESTÁGIO SUPERVISIONADO II - CC', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0187', 'TOPICOS ESPECIAIS I CC', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0175', 'TOPICOS ESPECIAIS II CC', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0174', 'TOPICOS ESPECIAIS III CC', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 0, 0, 'QXD0173', 'TOPICOS ESPECIAIS IV CC', 0); 
INSERT INTO disciplina( carga_horaria_pratica, carga_horaria_teorica, codigo, nome, creditos)  VALUES ( 48, 16, 'PRG0003', 'EDUCAÇAO AMBIENTAL', 0);

-- PERIODOS
-- INSERT INTO periodo( id, ano, semestre, status) VALUES (?, ?, ?, ?);

INSERT INTO periodo( ano, semestre, status) VALUES (2016, 1, "CONSOLIDADA");
INSERT INTO periodo( ano, semestre, status) VALUES (2016, 2, "CONSOLIDADA");
INSERT INTO periodo( ano, semestre, status) VALUES (2017, 1, "CONSOLIDADA");
INSERT INTO periodo( ano, semestre, status) VALUES (2017, 2, "ABERTA");



-- OFERTAS
-- INSERT INTO oferta( id, observacao, turno, vagas, disciplina_id, periodo_id, turma_id) INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES (?, ?, ?, ?, ?, ?, ?);

-- CC 1
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('MANHA', 55, 4, 3, 23);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('MANHA', 55, 46, 3, 23);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('MANHA', 55, 92, 3, 23);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('MANHA', 55, 1, 3, 23);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('MANHA', 55, 2, 3, 23);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('TARDE', 55, 76, 3, 23);

-- CC 2
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('MANHA', 20, 7, 3, 24);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('NOITE', 15, 6, 3, 24);

-- CC 3
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('MANHA', 40, 83, 3, 25);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('MANHA', 40, 11, 3, 25);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('MANHA', 40, 15, 3, 25);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('MANHA', 45, 82, 3, 25);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('MANHA', 35, 37, 3, 25);

-- CC 5
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('MANHA', 20, 23, 3, 27);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('MANHA', 30, 18, 3, 27);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('MANHA', 30, 148, 3, 27);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('MANHA', 40, 19, 3, 27);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('MANHA', 20, 36, 3, 27);

-- CC 7
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('MANHA', 20, 27, 3, 29);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('MANHA', 11, 84, 3, 29);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('TARDE', 20, 181, 3, 29);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('TARDE', 15, 171, 3, 29);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('NOITE', 15, 176, 3, 29);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('NOITE', 15, 167, 3, 29);

-- ########################################################################################################

-- SI 1
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('MANHA', 55, 154, 3, 1);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('MANHA', 55, 76, 3, 1);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('MANHA', 30, 2, 3, 1);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('MANHA', 30, 2, 3, 1);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('MANHA', 55, 3, 3, 1);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('MANHA', 55, 46, 3, 1);

-- SI 3
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('MANHA', 35, 96, 3, 3);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('MANHA', 45, 12, 3, 3);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('MANHA', 35, 9, 3, 3);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('MANHA', 40, 10, 3, 3);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('MANHA', 45, 11, 3, 3);

-- SI 5
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('MANHA', 45, 17, 3, 5);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('MANHA', 45, 19, 3, 5);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('MANHA', 40, 18, 3, 5);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('MANHA', 45, 16, 3, 5);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('MANHA', 30, 22, 3, 5);

-- SI 7
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('MANHA', 20, 39, 3, 7);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('MANHA', 20, 36, 3, 7);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('MANHA', 25, 25, 3, 7);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('MANHA', 25, 84, 3, 7);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('TARDE', 25, 207, 3, 7);

-- ########################################################################################################

-- ES 1
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('MANHA', 60, 45, 3, 9);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('MANHA', 55, 93, 3, 9);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('MANHA', 55, 2, 3, 9);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('MANHA', 55, 46, 3, 9);

-- ES 2
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('NOITE', 25, 7, 3, 10);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('NOITE', 20, 7, 3, 10);

-- ES 3
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('TARDE', 45, 27, 3, 11);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('TARDE', 45, 14, 3, 11);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('TARDE', 50, 12, 3, 11);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('TARDE', 45, 9, 3, 11);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('TARDE', 45, 13, 3, 11);

-- ES 5
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('TARDE', 30, 18, 3, 13);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('TARDE', 30, 51, 3, 13);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('TARDE', 40, 53, 3, 13);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('TARDE', 40, 38, 3, 13);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('TARDE', 50, 50, 3, 13);

-- ES 7
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('TARDE', 30, 147, 3, 15);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('TARDE', 30, 56, 3, 15);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('TARDE', 0, 58, 3, 15);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('TARDE', 30, 80, 3, 15);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('TARDE', 30, 84, 3, 15);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('MANHA', 0, 59, 3, 15);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('MANHA', 0, 207, 3, 15);

-- ########################################################################################################

-- EC 1
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('TARDE', 60, 2, 3, 39);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('TARDE', 55, 46, 3, 39);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('TARDE', 60, 126, 3, 39);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('TARDE', 50, 127, 3, 39);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('TARDE', 50, 92, 3, 39);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('TARDE', 50, 76, 3, 39);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('TARDE', 20, 76, 3, 39);

-- EC 2
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('TARDE', 35, 108, 3, 40);

-- EC 3
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('TARDE', 50, 100, 3, 41);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('TARDE', 50, 129, 3, 41);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('TARDE', 50, 165, 3, 41);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('TARDE', 50, 130, 3, 41);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('TARDE', 50, 11, 3, 41);

-- EC 5
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('TARDE', 20, 199, 3, 43);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('TARDE', 30, 139, 3, 43);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('TARDE', 20, 136, 3, 43);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('TARDE', 50, 15, 3, 43);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('TARDE', 20, 137, 3, 43);
INSERT INTO oferta(turno, vagas, disciplina_id, periodo_id, turma_id) VALUES ('TARDE', 20, 138, 3, 43);









