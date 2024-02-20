# Buscador Fipe

### Tecnologias usadas: 

Java, JavaFX, Spring Boot, CSS

![](https://github.com/Beforg/assets/blob/main/fipe/principal.png)

## Descrição

Este projeto é uma aplicação Java Spring Boot que se conecta a uma API para buscar dados da FIPE (Fundação Instituto de Pesquisas Econômicas), utilizando o framework JavaFX para a interface do usuário.

## Estrutura do Projeto

O projeto é estruturado da seguinte maneira:

- `src/main/java/br/com/alura/BuscaFIPE/controller`: Este pacote contém a classe `MainController`, que controla a interface do usuário definida no arquivo `main.fxml`.

- `src/main/java/br/com/alura/BuscaFIPE/service`: Este pacote contém a classe `ConsumoApi`, que é responsável por se conectar à API e buscar dados.

- `src/main/java/br/com/alura/BuscaFIPE/model`: Este pacote contém classes de modelo que representam os dados retornados pela API. Essas classes são usadas para deserializar os dados JSON retornados pela API.

- `src/main/java/br/com/alura/BuscaFIPE/utils`: Este pacote contém classes utilitárias que fornecem funcionalidades adicionais para a aplicação.

## Sobre:

O projeto conta com uma interface básica que contém ChoiceBox que carregam os dados da FIPE dependendo da escolha do usuário.

![](https://github.com/Beforg/assets/blob/main/fipe/opcao.png)

A interação com a opção vai liberando as outras caixas de seleção para o usuário ir configurando sua busca até o resultado final.
Após ter colocado todos os parâmetros, o resultado final aparece a direita das caixas de seleções, trazendo informações como Valor, modelo, ano, mês de referência, entre outros.

![](https://github.com/Beforg/assets/blob/main/fipe/fim.png)

## Como usar

Para usar este projeto, você pode clonar o repositório e importá-lo para a sua IDE preferida que suporte projetos Spring Boot (como IntelliJ IDEA ou Eclipse). Em seguida, você pode executar a aplicação a partir da classe principal.

## Considerações finais:

Projeto feito com base na formação Java Web da alura.
