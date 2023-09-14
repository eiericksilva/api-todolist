# TODO LIST - API
A TodoListAPI é uma API robusta e flexível para gerenciar listas de tarefas. Ela permite que os desenvolvedores criem, atualizem, leiam e excluam (Famoso CRUD) tarefas em uma lista de tarefas pessoal. Esta API é perfeita para aplicativos de gerenciamento de tarefas, aplicativos de produtividade e qualquer aplicativo que necessite de funcionalidade de lista de tarefas.

## Tecnologias Utilizadas
- Spring Boot
- Spring MVC
- Spring Data JPA
- H2 Database

## Lista de Recursos (Alguns em Desenvolvimento)
**USUÁRIO(User)**
  1. Criar usuário
  2. Editar dados pessoais do usuários
  3. Remover o usuário
  4. Listar Todos usuários

**TAREFA(Task)**
  1. Criar uma tarefa
  2. Editar atributos da tarefa
  3. Remover tarefa
  4. Listar todas tarefas

## Práticas Adotadas
- **API Rest**
       - Tratamento de Exceções (Handle Exceptions): Retorno específico para o usuário em caso de algum comportamento inesperado do Servidor ou um erro do Cliente durante o consumo da API;
- **Arquitetura em Camadas:** Dividi minha aplicação em Camadas, para dividir responsabilidades, são elas:
1. **Entities:** Core do Negócio;
2. **Repositories:** Responsável por acessar o Banco de Dados através do **Hibernate**;
3. **Services:** Casos de uso da aplicação;
4. **Controllers:**: Lida com diretamente com a intereção com o sistema.

## Como executar essa aplicação?
R.:


## Endpoints da API + Documentação Swagger:
R.:

# NOTAS ADICONAIS
Esta API foi projetada para ser escalável e pode ser estendida para incluir recursos adicionais, vou citar algumas que está no meu radar estudar e implementar aqui:
1.  Data Transfer Object (DTO)
2.  Testes Funcionais (JUnit5)
3.  Lembrete das tarefas agendadas



