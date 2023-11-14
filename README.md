# Implementação de uma Árvore Binária de Busca (ABB)

Neste projeto foi implementado uma estrutura de dados do tipo **Árvore Binária de Busca (ABB)**.

Além das três operações básicas de inserção, remoção e busca, a árvore implementamos mais 8 métodos para tornar a estrutura mais completa.

Este projeto foi realizado durante o período 2023.2 do Bacharelado em Tecnologia da Informação (BTI) da Universidade Federal do Rio Grande do Norte (UFRN).

## ⏯️ Compilação e Execução

### ⚒️ Ferramentas

O trabalho foi implementado na linguagem de programação Java. Portanto, para rodar o trabalho, deve-se ter instalado em sua máquina a Java Development Kit (JDK)

Logo, para instalar o compilador em sistemas Unix-like, como o Ubuntu, basta digitar um dos seguintes comandos no terminal (mais recomendado o primeiro):

```console
 sudo apt update
 sudo apt install default-jdk
```

### Compilação

Para compilar o projeto, entre na pasta do projeto e execute o comando de compilação na pasta raiz do projeto:

```sh
# Entrar na pasta raiz do projeto
cd ProjetoEDB2_ABB/src

# Compilar o projeto
javac ABBAumentada.java
```

### Execução

Para execução do projeto devem ser passados dois arquivos como argumentos:

```sh
 java ABBAumentada arquivo1.txt aquivo2.txt
```

- O primeiro, chamado de **arquivo1.txt **,contém contém uma
descrição da ABB que será utilizada e é denominado arquivo de entrada da ABB. O arquivo de entrada da ABB contém uma sequência de valores inteiros separados por um espaço, os valores a serem armazenados na árvore
- O segundo, chamado de **arquivo de comandos**, contém uma sequência de operações (uma operação por linha) a serem realizadas pelo seu árvore binária de busca.
  O arquivo de comando poderá utilizar as operações a seguir:
  
  ```sh
  ENESIMO N
  POSICAO N
  MEDIANA
  MEDIA
  CHEIA
  COMPLETA
  IMPRIMA S
  REMOVA N
  BUSCAR N
  INSERIR N
  ```
  
