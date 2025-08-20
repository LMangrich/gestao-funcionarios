## Gestão de Funcionários 👨‍💼👩‍💼

Projeto desenvolvido em Java 17 utilizando Maven, com foco em manipulação de listas de funcionários, aplicação de regras de negócio e boas práticas de programação orientada a objetos.

## 📌 Funcionalidades

O sistema permite:

- Inserir funcionários em uma lista pré-definida.

- Remover um funcionário pelo nome.

- Formatar e imprimir funcionários com:
  - Datas no formato dd/MM/yyyy.
  - Salários com separador de milhar (.) e decimal (``,`).

- Atualizar salários aplicando percentuais de aumento.

- Agrupar funcionários por função utilizando Map.

- Filtrar aniversariantes de meses específicos.

- Encontrar o funcionário mais velho (maior idade).

- Ordenar funcionários por nome em ordem alfabética.

- Calcular o valor total de salários.

- Calcular quantos salários mínimos cada funcionário recebe.

## 🚀 Como executar

1. Clone o repositório:
```
git clone https://github.com/seu-usuario/gestao-funcionarios.git
````

2. Entre na pasta do projeto:
```
cd gestao-funcionarios
```

3. Compile o projeto com Maven:
```
mvn clean compile
```

4. Execute a classe principal:
```
java -cp target/classes com.empresa.funcionarios.principal.Principal
```

E prontinho!!
