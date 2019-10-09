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


## Requisitos já implementados (08/10/19)
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
![](https://i.imgur.com/lt4H0tU.png)

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


## Diagrama de Classes
![](https://i.imgur.com/WdFf7F7.png)
