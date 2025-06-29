## Proposta 

O 'novo' sistema de cadastro de jogadores do UOL precisa de uma nova cara! Isso porque a área de lazer da empresa definiu que todo jogador deverá ter um codinome. A proposta foi um sucesso e muitos candidatos se inscreveram, por isso a área de lazer acabou restringindo os codinomes em duas listas distintas: "Os Vingadores" e "A Liga da Justiça".

O desafio é elaborar um sistema em Java capaz de:

1. Permitir o cadastro de jogadores de acordo com os codinomes contidos nos links de referência vingadores.json e liga_da_justica.xml
2. Apresentar um cadastro contendo nome, e-mail e telefone do jogador (sendo que nome e e-mail são obrigatórios)
3. Persistir a informação cadastrada em um banco de dados em memória, como HSQLDB ou arquivo
4. Obter, a qualquer momento, a lista de todos os jogadores cadastrados com seus respectivos codinomes e também a informação de qual lista o codinome foi extraído
5. Impedir a utilização de um mesmo codinome para diferentes usuários (a menos que o codinome seja para listas diferentes)
6. Incluir o codinome escolhido dentro das listas Os Vingadores ou A Liga da Justiça
7. Obrigatoriamente, ler a informação do codinome em arquivos na internet (links abaixo). Atenção: não vale guardar a informação do codinome localmente (em um arquivo, em uma classe, em um banco de dados etc.)


## Arquitetura de referência

![alt text](https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/arquitetura.png)

### Casos de uso

+ Cadastro com sucesso:
	1. O usuário 'Felipe' cadastra seu nome, e-mail e telefone, e escolhe a lista vingadores.json
	2. O sistema recebe o cadastro e verifica se há codinomes disponíveis na lista vingadores.json
	3. O sistema encontra um codinome livre e o escolhe
	4. O sistema persiste nome, e-mail, telefone, codinome e arquivo de referência em um banco de dados em memória ou em um arquivo
	5. O sistema informa que o usuário foi cadastrado corretamente e mostra uma imagem de sucesso
	
+ Lista escolhida não tem codinomes disponíveis:
	1. O usuário 'João' cadastra seu nome, e-mail e telefone, e escolhe a lista liga_da_justica.xml
	2. O sistema recebe o cadastro e verifica se há codinomes disponíveis na lista liga_da_justica.xml
	3. O sistema não encontra um codinome livre
	4. O sistema informa que aquela lista não possui mais usuários disponíveis

+ Relatório de usuários cadastrados:
	1. O usuário 'Luís' clica em “Visualizar relatório de jogadores”
	2. O sistema consulta o banco de dados em memória ou em arquivo
	3. O sistema apresenta todos os usuários cadastrados. Cada linha tem as informações: nome, e-mail, telefone, codinome e arquivo referência

