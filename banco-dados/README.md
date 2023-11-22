<h1 align="center"> Estrutura de Banco de Dados </h1>

<p align="center">
  Projeto final
</p>

<p align="center">
  <img alt="License" src="https://img.shields.io/badge/License-MIT-green.svg"> <img alt="License" src="https://img.shields.io/badge/java_8-✓-blue.svg"> <img alt="License" src="https://img.shields.io/badge/mysql-✓-blue.svg"
</p>


O banco de dados *nome_seu_banco* foi desenvolvido para gerenciar informações relacionadas a uma instituição educacional. Ele consiste em cinco tabelas principais:

*Aluno (aluno)*
```
*id: Identificador único do aluno.
nome: Nome do aluno.
cpf: Número de CPF do aluno.
email: Endereço de e-mail do aluno.
status: Status do aluno.

```

*Professor (professor)*
```
id: Identificador único do professor.
nome: Nome do professor.
salario: Salário do professor.
status: Status do professor.
```

*Curso (curso)*
```
id: Identificador único do curso.
nome: Nome do curso.
valor: Valor do curso.
duracao: Duração do curso em dias.
professor_id: Referência ao professor responsável pelo curso.
```
*Matrícula (matricula)*
```
datamatricula: Data de matrícula do aluno.
prestacoes: Número de prestações do curso.
aluno_id: Referência ao aluno matriculado.
```
*Turma (turma)*
```
id: Identificador único da turma.
numero: Número da turma.
dataInicio: Data de início da turma.
numeroVagas: Número de vagas disponíveis na turma.
curso_id: Referência ao curso associado à turma.
aluno_id: Referência ao aluno na turma.
matricula_aluno_id: Referência à matrícula do aluno.
```` 
Como Usar
Execução no MySQL Workbench:

1. Criação Automática do Banco de Dados:

- O script fornecido realiza a criação automática do banco de dados chamado *nome_seu_banco* no MySQL Workbench.

2. Execução do Script:

- Abra o MySQL Workbench e cole o script no editor SQL.
  
- Execute as instruções SQL para criar todas as tabelas necessárias no banco de dados.
  
3. Integração com a Aplicação:

- Configure as conexões do seu aplicativo para apontar para o banco de dados *nome_seu_banco*.
  
- Utilize as tabelas criadas conforme necessário para armazenar e recuperar informações em sua aplicação.

Observações Importantes:

- Certifique-se de que o MySQL Workbench esteja conectado ao servidor de banco de dados apropriado antes de executar o script.
  
- Verifique se as credenciais de conexão na aplicação estão atualizadas para refletir as configurações do banco de dados *nome_seu_banco*.
  
- Ao integrar com a aplicação, utilize consultas SQL para interagir com as tabelas conforme necessário.

Lembre-se de adaptar essas instruções com informações específicas do seu ambiente, como credenciais de banco de dados, caso necessário.







