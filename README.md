# Conversor de Moeda

## Linguagem Usada
- Java

## Conhecimentos utilizados
- Orientação a objetos
- Consumo de API

## API
A API de cotações utilizada foi do [AwesomeAPI](https://docs.awesomeapi.com.br/api-de-moedas) que é distribuida gratuitamente e conta com mais de 150 moedas diferentes e cerca de 460 combinações de conversão.

- [Moedas aceitas](https://economia.awesomeapi.com.br/xml/available/uniq)
- [Combinações aceitas](https://economia.awesomeapi.com.br/xml/available)

## Observações
Por haver um número limitado de combinações foi utilizado apenas as moedas Dólar(USD), Real(BRL) e o Euro(EUR) como moeda "Primarias", uma vez que essas três moedas são as que mais apresentam combinações. Porém, ainda pode haver erro de combinação inválida.

Caso queira vê todas as combinações possíveis existe a versão [Conversor-MoedaV2](https://github.com/andreivan245/Conversor-MoedaV2.git).

## Instalação


Requer o [Java](https://www.java.com/pt-BR/) instalado e o [Git](https://git-scm.com/).

Para a instalação escolha uma pasta para clonar o repositório e digite o seguinte comando

```sh
git clone https://github.com/andreivan245/Conversor-Moeda.git
```
E por fim execute o arquivo Conversor Moeda.jar


Ou se preferir baixe diretamente [aqui](https://github.com/andreivan245/Conversor-Moeda/archive/refs/heads/main.zip) o zip do projeto.

Em seguida extraia

E por fim execute o arquivo Conversor Moeda.jar

## Bug
Até o dia de hoje 05/10/2022 a API apresenta um erro em algumas cotações ao retorna o valor da cotação, esse erro se dá pela posicão incorreta da casa decimal de valores >= 1000. O que acaba por prejudicar algumas conversões.

