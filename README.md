💰 Java Currency Converter
Este projeto é um conversor de moedas simples feito em Java. Ele se conecta a uma API online para pegar as taxas de câmbio mais recentes e permite que você faça conversões de forma rápida e fácil.

🚀 Como Rodar o Projeto
É bem simples colocar este conversor para funcionar!

1. Pegue sua Chave da API
Primeiro, você precisa de uma chave de API gratuita.

Acesse o site da ExchangeRate-API.
Crie uma conta e pegue sua chave.
2. Configure o Código
Copie todo o código Java que você tem e salve-o em um arquivo chamado Main.java.
Abra o arquivo Main.java e encontre esta linha:
Java

String apiKey = "5f84bd6fdc5c126234f93711"; // Substitua esta chave pela SUA CHAVE REAL
Troque "5f84bd6fdc5c126234f93711" pela chave de API que você pegou no site da ExchangeRate-API.
3. Adicione a Biblioteca Gson
Este projeto usa uma biblioteca chamada Gson para ler os dados da internet. Você precisa adicioná-la ao seu projeto:

Se você usa Maven (recomendado para projetos maiores): Adicione este código ao seu arquivo pom.xml:
XML

<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.10.1</version> </dependency>
Se você usa Gradle: Adicione este código ao seu arquivo build.gradle:
Groovy

implementation 'com.google.code.gson:gson:2.10.1' // Use a versão mais recente
Se você não usa Maven/Gradle (compilação manual):
Baixe o arquivo .jar do Gson. Você pode pesquisar por "gson maven repository" e encontrar o link para download direto da versão mais recente.
Guarde este arquivo .jar em uma pasta fácil de acessar.
4. Compile e Execute!
Agora é só rodar o programa:

Usando uma IDE (como IntelliJ IDEA, Eclipse, VS Code):

Abra o projeto na sua IDE.
Geralmente, sua IDE vai cuidar das dependências automaticamente.
Basta rodar a classe Main.
Usando o Terminal (linha de comando):

Abra seu terminal ou prompt de comando.
Vá até a pasta onde você salvou o arquivo Main.java.
Para compilar (se você baixou o Gson JAR):
Bash

javac -cp "caminho/para/gson.jar" Main.java
(No Linux/macOS, use : em vez de ; para o classpath.)
Para executar:
Bash

java -cp ".;caminho/para/gson.jar" Main
(Novamente, no Linux/macOS, use : em vez de ;.)
🖥️ O Que Você Verá (Exemplo de Uso)
Ao rodar o programa, você verá um menu no terminal, algo assim:

====================
Escolha uma opção (1 a 6):
1 - Dólar => Yuan (China)
2 - Yuan => Dólar
3 - Dólar => Real Brasileiro
4 - Real => Dólar
5 - Dólar => Euro
6 - Euro => Dólar
7 - Sair
Opção:
Digite o número da opção que você quer e pressione Enter.
O programa vai pedir para você digitar o valor que quer converter. Digite o número e pressione Enter.
Pronto! Ele vai mostrar o resultado da conversão.
Você pode continuar fazendo conversões até escolher a opção 7 - Sair para finalizar o programa.
