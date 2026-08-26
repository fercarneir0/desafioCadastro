# Desafio PROGRAMAÇÃO - Sistema de Cadastros 🚀

### Desafio criado por Lucas Carrilho - [@devmagro](https://www.linkedin.com/in/karilho/)

Twitter: [@devmagro 🐦 ](https://x.com/devmagro)

Instagram: [@devmagro 📸](https://instagram.com/devmagro)

YouTube: [@devmagro 🎥](https://www.youtube.com/@devmagro)

---

## 📌 Sobre o projeto

Este projeto foi desenvolvido como parte do **Desafio Cadastro do DevMagro**, com o objetivo de colocar em prática conceitos de **Java, Programação Orientada a Objetos e boas práticas de desenvolvimento**.

A aplicação consiste em um **sistema de cadastro e gerenciamento de pets via CLI (Command-Line Interface)**, permitindo cadastrar, listar, buscar, alterar e remover animais.

Durante todo o desenvolvimento, busquei seguir o princípio de **responsabilidade única**, procurando manter cada função responsável por uma tarefa específica. Essa abordagem ajudou a manter o código mais organizado, legível e fácil de evoluir.

### 🔎 Destaque do projeto

Uma das maiores dificuldades encontradas durante o desenvolvimento foi a implementação da **busca de pets utilizando múltiplos critérios**.

Inicialmente, a filtragem estava sendo realizada utilizando `List`, com funções específicas para cada tipo de critério. Porém, percebi que essa abordagem poderia se tornar pouco escalável caso fosse necessário combinar diferentes filtros, pois seria necessário criar e combinar diversas funções.

Pesquisando outras possibilidades do Java, conheci a interface **`Predicate`** e utilizei esse recurso para desenvolver uma solução mais **escalável, reutilizável e versátil**.

Com essa abordagem, os filtros podem ser combinados de acordo com a necessidade do usuário, permitindo utilizar **quantos critérios forem necessários a partir das funções de filtro já existentes**, sem a necessidade de criar uma nova função para cada combinação possível.

## 🛠️ Tecnologias e conceitos utilizados

- Java
- Programação Orientada a Objetos (POO)
- CLI (Command-Line Interface)
- Collections / `List`
- `Predicate`
- Enums
- Tratamento de exceções
- Manipulação de arquivos
- Java IO
- File Systems
- Padrão MVC
- Boas práticas de programação
- Git e GitHub

## 🚀 Como executar o projeto

A aplicação funciona via **CLI (Command-Line Interface)**, com todas as funcionalidades sendo acessadas através do terminal.

### ▶️ Iniciando o projeto

1. Clone o repositório:

   ```bash
   git clone <URL_DO_REPOSITORIO>

   2. Abra o projeto na sua IDE de preferência.
3. Localize a classe `Main`.
4. Execute o método `main`.
5. O menu da aplicação será exibido no console.

A partir daí, basta seguir as opções apresentadas no terminal para utilizar o sistema.

### 💻 Exemplo

```text
1. Cadastrar novo pet
2. Alterar os dados do pet cadastrado
3. Deletar um pet cadastrado
4. Listar todos os pets cadastrados
5. Listar pet por algum critério
6. Sair
