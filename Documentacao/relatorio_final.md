# Empacotadeira



Arthur Vítor Sapore - arthur.sapore@sga.pucminas.br

Paulo Victor Jesus de Sousa - paulo.sousa.1137246@sga.pucminas.br

Tarcísio Pais de Souza Junior - tarcisio.junior.1284505@sga.pucminas.br

---

_Curso de Sistemas de Informações, Unidade São Gabriel_

_Instituto de Informática e Ciências Exatas – Pontifícia Universidade de Minas Gerais (PUC MINAS), Belo Horizonte – MG – Brasil_

---

_**Resumo**. Escrever aqui o resumo. O resumo deve contextualizar rapidamente o trabalho, descrever seu objetivo e, ao final, 
mostrar algum resultado relevante do trabalho (até 10 linhas)._

---


## 1. Introdução
 Uma empresa tem seu negócio baseado em empacotar produtos que serão enviados a lojas, supermercados e distribuidoras para venda fracionada ao consumidor final. Este processo está prestes a ser automatizado utilizando uma esteira e braços mecânicos, mas os gerentes estão na dúvida sobre como obter o melhor rendimento do equipamento.
 O funcionamento básico do equipamento é receber um lote de produtos, empacotá-lo e colocá-lo em  seguida em uma caixa que será depois levada para transporte. De maneira geral, os produtos são colocados em uma esteira e, ao passar por um braço mecânico, este fará a embalagem dos produtos e a remoção desta embalagem para a caixa de transporte.



### 1.1 Contextualização
	


### 1.2 Problema
 O processo de empacotamento está prestes a ser automatizado utilizando uma esteira e braços mecânicos, mas os gerentes estão na dúvida sobre como obter o melhor rendimento do equipamento.
 
 Esta mudança visa aumentar a capacidade de produção da empresa para atender a mais pedidos diários e garantir o prazo de todos que optaram a pagar um adicional por isso. Além disso, a empresa vai passar a aceitar pedidos ao longo do dia (anteriormente, as listas de pedidos eram montadas com um dia de antecedência).


### 1.3 Objetivo Geral
 O objetivo deste trabalho é realizar simulações computacionais de como se daria o empacotamento de uma quantidade de pedidos pré-determinados, criados a partir da demanda esperada da empresa para um dia típico de trabalho. 

### 1.3.1 Objetivos Especificos
 • Minimizar o tempo médio gasto para terminar todos os pacotes;
 • Maximizar a quantidade de pacotes produzidos antes de meio dia, quando sai a primeira van para entrega;
 • Atender a prazos estritos de clientes prioritários, que pagam a mais por isso.

### 1.4 Justificativa



## 2. Modelagem do processo de negócio
### 2.1. Análise da situação atual

Atualmente, todo processo de empacotamento da empresa é realizado manualmente por diversos funcionários, o que acaba prejudicando significativamente a eficiência do empacotamento. Além disso, a empresa gera a lista de pedidos antecipadamente, ou seja, os pedidos que serão empacotados no dia são ordenados no dia anterior. 
Desta maneira, todos os pedidos esperam no mínimo 1 dia útil para serem empacotados. Impossibilitando assim, que a empresa receba e empacote os produtos no mesmo dia.


## 2.2. Descrição Geral da proposta



## 3. Projeto da Solução
### 3.2. Tecnologias

Tecnologia utilizada: JAVA.


Ferramentas: Eclipse IDE;



## 4. Modelagem de dados

Apresente o modelo de dados. Defina o dicionário de dados com os respectivos formatos e significados.



## 5. Indicadores de desempenho

Apresente aqui os principais indicadores de desempenho e algumas metas para o processo. Atenção: as informações necessárias para gerar os indicadores devem estar contempladas no diagrama de classe. 

Usar o seguinte modelo:

| **Indicador** | **Objetivos** | **Descrição** | **Cálculo** | **Fonte dados** | **Perspectiva** |
| --- | --- | --- | --- | --- | --- |
| Quantidade de pedidos empacotados na esteira 1 | Analisar quantitativamente a eficiência da esteira 1. | Avalia a quantidade de pedidos empacotados pela esteira 1. | Somatório de pacotes produzidos | Classe Esteira| Maior possível |
| Quantidade de pedidos empacotados na esteira 2| Analisar quantitativamente a eficiência da esteira 2. | Avalia a quantidade de pedidos empacotados pela esteira 2. | Somatório de pacotes produzidos | Classe Esteira| Maior possível |
| Tempo Médio de Retorno | Analisar qualitativamente a eficiência do algoritmo de escalonamento implementado | Avalia a média do tempo de retorno que as duas esteiras proporcionaram | (tempoMedioEsteira1+tempoMedioEsteria2)/2; | Algoritmo de escalonamento| Menor possível |
| Pedidos fora do prazo | Analisar qualitativamente a eficiência dos algoritmos de escalonamento | Avalia quantos pedidos perderam o prazo | Somatório de pedidos que perderam o prazo | Somatório de pedidos que perderam o prazo | Classe Esteira| Menor possível |
| Quantidade de pacotes embalados pela esteira 1 antes da saída da van | Analisar quantitativamente a eficiência da esteira 1 | Analisa quantos produtos foram entregues antes da saída da van | Somatório de pacotes embalados antes do meio dia (12:00) | Classe Esteira. | Maior possível |
| Quantidade de pacotes embalados pela esteira 2 antes da saída da van | Analisar quantitativamente a eficiência da esteira 2 | Analisa quantos produtos foram entregues antes da saída da van | Somatório de pacotes embalados antes do meio dia (12:00) | Classe Esteira. | Maior possível |



Obs.: todas as informações para gerar os indicadores devem estar no diagrama de classe **a ser proposto**

## 7.Sistema desenvolvido

Faça aqui uma breve descrição do software e coloque as principais telas com uma explicação de como usar cada uma.

## 8. Avaliação

Faça aqui sobre a avaliação do software. Indique se ele atendeu as expectativas e ele é viável. Para não ficar subjetivo, o ideal é fazer um questionário e pedir ao usuário do processo que faça a avaliação

## 9. Conclusão

Apresente aqui a conclusão do seu trabalho. Discussão dos resultados obtidos no trabalho, onde se verifica as observações pessoais de cada aluno. Poderá também apresentar sugestões de novas linhas de estudo.

# REFERÊNCIAS

Como um projeto de software não requer revisão bibliográfica, a inclusão das referências não é obrigatória. No entanto, caso você deseje incluir referências relacionadas às tecnologias, padrões, ou metodologias que serão usadas no seu trabalho, relacione-as de acordo com a ABNT.

Verifique no link abaixo como devem ser as referências no padrão ABNT:

http://www.pucminas.br/imagedb/documento/DOC\_DSC\_NOME\_ARQUI20160217102425.pdf


**[1.1]** - _ELMASRI, Ramez; NAVATHE, Sham. **Sistemas de banco de dados**. 7. ed. São Paulo: Pearson, c2019. E-book. ISBN 9788543025001._

**[1.2]** - _COPPIN, Ben. **Inteligência artificial**. Rio de Janeiro, RJ: LTC, c2010. E-book. ISBN 978-85-216-2936-8._

**[1.3]** - _CORMEN, Thomas H. et al. **Algoritmos: teoria e prática**. Rio de Janeiro, RJ: Elsevier, Campus, c2012. xvi, 926 p. ISBN 9788535236996._

**[1.4]** - _SUTHERLAND, Jeffrey Victor. **Scrum: a arte de fazer o dobro do trabalho na metade do tempo**. 2. ed. rev. São Paulo, SP: Leya, 2016. 236, [4] p. ISBN 9788544104514._

**[1.5]** - _RUSSELL, Stuart J.; NORVIG, Peter. **Inteligência artificial**. Rio de Janeiro: Elsevier, c2013. xxi, 988 p. ISBN 9788535237016._



# APÊNDICES

**Colocar link:**

Do código;

Dos artefatos;

Da apresentação final;

Do vídeo de apresentação.




