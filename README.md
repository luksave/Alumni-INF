# Projeto Alumni INF

[![Build Status](https://travis-ci.com/luksave/Alumni-INF.svg?branch=master)](https://travis-ci.com/luksave/Alumni-INF)

## Descrição do Projeto Alumni-INF
Nos últimos anos, o Instituto de Informática da Universidade Federal de Goiás (INF-UFG) tem identificado uma necessidade crescente de obter informações sobre os ex-alunos (do latim alumni) tanto dos cursos de graduação quanto dos cursos de pós-graduação oferecidos pelo instituto. O INF-UFG acredita que vários benefícios poderiam ser obtidos com um sistema Alumni como, por exemplo:

- A construção de uma rede de contatos (networking) entre os ex-aluno;
- O estabelecimento de um canal de comunicação entre os ex-alunos para a divulgação de
assuntos de seu interesse comum, como por exemplo, oportunidades de trabalho e ações e
eventos promovidos (ou não) pelo instituto ou pela universidade;
- A produção de dados estatísticos sobre ex-alunos para as coordenadorias de cursos de
graduação e de pós-graduação do instituto.


Entretanto, existe um problema que precisa ser considerado para desenvolver o sistema Alumni INF: os sistemas de informação da UFG não possuem as informações dos ex-alunos posteriores à conclusão do seu vínculo com a universidade e o instituto.

Por outro lado, esses mesmos sistemas de informação armazenam informações relevantes sobre os ex-alunos em suas bases de dados como, por exemplo, dados pessoais, de matrícula e o histórico de disciplinas cursadas na UFG.


## Requisitos já implementados (15/10/19)
**[RF01]** Como sistema Alumni INF, desejo importar do módulo
Graduação do SIGAA os dados de ex-alunos de graduação do INF,
para que possam ser usados para validação de cadastros de
usuários. Seguem os dados que comporão o perfil do ex-aluno: nome
completo, CPF, data de nascimento, foto, e-mail e telefone de contato,
nome(s) do(s) curso(s) de graduação concluído(s) e respectivo(s)
ano(s) de conclusão e componentes curriculares.

**[RF04]** Como ex-aluno, desejo validar meu cadastro importado do
SIGAA para que possa cadastrar as credenciais de acesso ao Alumni
INF. Apenas o CPF e o número de matrícula são necessários para a
validação do cadastro no Alumni INF. Um nome de usuário único e
uma senha são gerados automaticamente pelo sistema Alumni INF.

**[RF05]** Como ex-aluno desejo realizar login para que tenha acesso
ao Alumni INF. Para isso, precisará de nome de usuário único e senha
gerados pelo sistema.

**[RF07]** Como usuário externo, desejo cadastrar uma conta de usuário
para que tenha acesso ao Alumni INF. Os dados relativos à conta
incluem nome de usuário único, senha, nome completo do
representante da empresa, CPF, razão social, CNPJ, logotipo, e-mail
e telefone de contato e senha de acesso. Um nome de usuário único e
uma senha são gerados automaticamente pelo sistema Alumni INF.

**[RF08]** Como usuário-externo desejo realizar login para que tenha
acesso ao Alumni INF. Para isso, precisará de nome de usuário único
e senha gerados pelo sistema.

**[RF018]** Como usuário externo, desejo gerenciar oportunidades
profissionais para que possa preencher vagas de emprego de forma
mais eficiente. Cada oportunidade profissional possui um título
descritivo, habilidades exigidas, cidade de atuação, formação
acadêmica (não ou curso superior exigido), atividades a serem
realizadas e faixa salarial.

## Diagrama de caso de uso
![](https://i.imgur.com/UgxzlhS.png)

## Caso de uso detalhado
**Nota:** Alguns detalhes ainda devem ser implementados.


### CASO DE USO UC01: CADASTRAR USUÁRIO EXTERNO

**Ator primário:** Usuário Externo.

**Pré-Condições:** nenhuma.

**Pós-Condições:** conta de usuário externo cadastrada no sistema.

**Fluxo Principal de Eventos**

1. O ator solicita o cadastro de uma conta no sistema.
2. O sistema exibe os campos para criação de uma conta de usuário externo: nome completo do representante da empresa, CPF, razão social, CNPJ, e-mail e telefone de contato (obrigatórios).
3. O ator preenche e submete os campos requeridos pelo sistema.
4. O sistema verifica que usuário externo não existe, por meio do campo CNPJ.
5. O sistema gera automaticamente as credenciais de acesso (nome de usuário único e senha) do usuário recém-criado.
6. O sistema registra as informações fornecidas explicitamente pelo ator e aquelas geradas automaticamente.
7. O sistema envia credenciais de acesso ao e-mail fornecido pelo ator.
8. O sistema exibe mensagem ao ator que o cadastro foi realizado com sucesso e que as credenciais de acesso foram enviadas para o e-mail registrado.

**Fluxo Alternativo - Desistência do ator**

3. O ator desiste de cadastrar uma conta no sistema.
4. O caso de uso se encerra.

**Fluxo Alternativo - Preenchimento de dados obrigatórios**

3. O ator não preenche ao menos um campo obrigatório.
4. O sistema exibe mensagem ao ator indicando o(s) campo(s) que precisa(m) ser obrigatoriamente preenchido.
5. O caso de uso volta para o passo 3 do fluxo principal.

**Fluxo Alternativo - Conta de usuário externo existente**

4. O ator não preenche ao menos um campo obrigatório.
5. O sistema exibe mensagem ao ator indicando que já existe uma conta de usuário com o CNPJ fornecido.
6. O caso de uso volta para o passo 3 do fluxo principal.



### CASO DE USO UC02: REALIZAR LOGIN

**Ator primário:** Usuário Externo.

**Pré-Condições:** o usuário externo deve estar cadastrado no sistema

**Pós-Condições:** usuário externo logado no sistema.

**Fluxo Principal de Eventos**

1. O ator solicita acesso ao sistema.
2. O sistema exibe os campos para ter acesso ao sistema: nome de usuário e senha (obrigatórios).
3. O ator preenche e submete os campos requeridos pelo sistema.
4. O sistema verifica que ator existe e as credenciais de acesso são válidas.
5. O sistema notifica ao ator que ele está com acesso habilitado.

**Fluxo Alternativo - Preenchimento de dados obrigatórios**

3. O ator não preenche ao menos um campo obrigatório.
4. O sistema exibe mensagem ao ator indicando o(s) campo(s) que precisa(m) ser obrigatoriamente preenchido.
5. O caso de uso volta para o passo 3 do fluxo principal.

**Fluxo Alternativo - Ator Inexistente**

4. O sistema verifica que ator não está cadastrado.
5. O sistema exibe mensagem ao ator indicando que não existe conta cadastrada.
6. O caso de uso se encerra.

**Fluxo Alternativo - Credenciais de Acesso Inválidas**

4. O sistema verifica que as credenciais de acesso do ator cadastrado são inválidas.
5. O sistema exibe mensagem ao ator indicando que as suas credenciais de acesso são
inválidas.
6. O caso de uso volta para o passo 3 do fluxo principal.


### CASO DE USO UC03: CADASTRAR OPORTUNIDADE DE VAGA

**Ator primário:** Usuário Externo.

**Pré-Condições:** o usuário externo deve estar cadastrado e logado no sistema

**Pós-Condições:** anúncio de oportunidade de vaga cadastrado no sistema.

**Fluxo Principal de Eventos**

1. O ator solicita o cadastro de oportunidade de vaga.
2. O sistema exibe os campos para preenchimento da oportunidade de vaga: título
descritivo, habilidades exigidas, cidade de atuação, formação acadêmica exigida e
atividades a serem realizadas (obrigatórios); faixa salarial (opcional).
3. O ator preenche e submete os campos requeridos pelo sistema.
4. O sistema registra as informações.
5. O sistema exibe mensagem ao ator que o cadastro foi realizado com sucesso.

**Fluxo Alternativo - Desistência do ator**

3. O ator desiste de cadastrar uma oportunidade de vaga.
4. O caso de uso se encerra.

**Fluxo Alternativo - Preenchimento de dados obrigatórios**

3. O ator não preenche ao menos um campo obrigatório.
4. O sistema exibe mensagem ao ator indicando o(s) campo(s) que precisa(m) ser obrigatoriamente preenchido.
5. O caso de uso volta para o passo 3 do fluxo principal.

**Fluxo Alternativo - Credenciais de Acesso Inválidas**

4. O sistema verifica que as credenciais de acesso do ator cadastrado são inválidas.
5. O sistema exibe mensagem ao ator indicando que as suas credenciais de acesso são
inválidas.
6. O caso de uso volta para o passo 3 do fluxo principal.


### CASO DE USO UC04: VALIDAR EX-ALUNO

**Ator primário:** Ex-aluno.

**Pré-Condições:** dados do ex-aluno devem ser importados do módulo Graduação do SIGAA,
como: nome completo, CPF, data de nascimento, foto, e-mail e telefone de contato, nome(s)
do(s) curso(s) de graduação concluído(s) e respectivo(s) ano(s) de conclusão e componentes
curriculares (disciplinas cursadas por período).

**Pós-Condições:** conta de ex-aluno validada no sistema.

**Fluxo Principal de Eventos**
1. Quando for o 1o acesso do ator ao sistema, ele solicita a validação de sua conta.
2. O sistema exibe os campos obrigatórios para validação de conta: o CPF e um número
de matrícula de curso do ator.
3. O ator preenche e submete os campos requeridos pelo sistema.
4. O sistema verifica que o ator existe e possui uma conta ainda não validada.
5. O sistema gera automaticamente as credenciais de acesso (nome de usuário único e
senha) do ator recém-validado.
6. O sistema registra que a conta do ator está validada.
7. O sistema registra o nome de usuário único e a senha geradas automaticamente para o
ator.
8. O sistema envia credenciais de acesso ao e-mail fornecido pelo ator.
9. O sistema exibe mensagem ao ator que a conta foi validada com sucesso e que as
credenciais de acesso foram enviadas para o e-mail cadastrado no sistema.

**Fluxo Alternativo - Desistência do ator**

3. O ator desiste de validar sua conta no sistema.
4. O caso de uso se encerra.

**Fluxo Alternativo - Preenchimento de dados obrigatórios**

3. O ator não preenche ao menos um campo obrigatório.
4. O sistema exibe mensagem ao ator indicando o(s) campo(s) que precisa(m) ser obrigatoriamente preenchido.
5. O caso de uso volta para o passo 3 do fluxo principal.

**Fluxo Alternativo - CPF ou número de matrícula inválidos**

4. O sistema verifica que o CPF ou número de matrícula fornecidos pelo ator são inválidas.
5. O sistema exibe mensagem ao ator indicando que a invalidade dessas informações.
6. O caso de uso volta para o passo 3 do fluxo principal.

**Fluxo Alternativo - Conta já validada**

4. O sistema verifica que a conta do ator já foi validada previamente.
5. O sistema exibe mensagem ao ator indicando que a conta já foi validada e sugere
consultar o e-mail cadastrado no sistema para localizar suas credenciais de acesso.
6. O caso de uso se encerra.


### CASO DE USO UC05: REALIZAR LOGIN (similar ao UC02, muda apenas tipo de usuário)

**Ator primário:** Ex-aluno.

**Pré-Condições:** o ex-aluno deve estar validado no sistema.

**Pós-Condições:** ex-aluno logado no sistema.


**Fluxo Principal de Eventos**
1. O ator solicita acesso ao sistema.
2. O sistema exibe os campos para ter acesso ao sistema: nome de usuário e senha
(obrigatórios).
3. O ator preenche e submete os campos requeridos pelo sistema.
4. O sistema verifica que ator existe e as credenciais de acesso são válidas.
5. O sistema notifica ao ator que ele está com acesso habilitado.

**Fluxo Alternativo - Preenchimento de dados obrigatórios**

3. O ator não preenche ao menos um campo obrigatório.
4. O sistema exibe mensagem ao ator indicando o(s) campo(s) que precisa(m) ser obrigatoriamente preenchido.
5. O caso de uso volta para o passo 3 do fluxo principal.

**Fluxo Alternativo - Ator Inexistente**

4. O sistema verifica que ator não está cadastrado.
5. O sistema exibe mensagem ao ator indicando que não existe conta cadastrada.
6. O caso de uso se encerra.

**Fluxo Alternativo - Credenciais de Acesso Inválidas**
4. O sistema verifica que as credenciais de acesso do ator cadastrado são inválidas.
5. O sistema exibe mensagem ao ator indicando que as suas credenciais de acesso são
inválidas.
6. O caso de uso volta para o passo 3 do fluxo principal.


### CASO DE USO UC05: CANDIDATAR-SE À OPORTUNIDADE DE VAGA

**Ator primário:** Ex-aluno.

**Pré-Condições:** o ex-aluno deve estar logado no sistema.

**Pós-Condições:** ex-aluno registrado como candidato à vaga de emprego.


**Fluxo Principal de Eventos**

1.O ator solicita a lista de oportunidades de vagas.
2 O sistema exibe uma lista de oportunidades de vagas, por padrão, em ordem alfabética
de título descritivo
3 Enquanto o ator desejar, ele seleciona uma oportunidade de vaga para candidatura.
4 O ator candidata-se à(s) oportunidade(s) de vaga selecionada(s).
5 O sistema registra a(s) candidatura(s) informada(s).
6 O sistema exibe mensagem ao ator que a(s) candidatura(s) foi(ram) registrada(s) com
sucesso.

**Fluxo Alternativo - Desistência do ator**

3. O ator desiste de validar sua conta no sistema.
4. O caso de uso se encerra.

**Fluxo Alternativo - Desistência do ator de candidatar-se à(s) oportunidade(s) de vaga selecionada(s)**

3. O ator desiste de candidatar-se à(s) oportunidade(s) de vaga selecionada(s).
4. O caso de uso se encerra.
