💰 Java Currency Converter
Visão Geral
Este projeto é um conversor de moedas simples e eficaz, desenvolvido em Java. Ele permite obter as taxas de câmbio mais recentes e realizar conversões entre diferentes moedas, conectando-se à API pública do ExchangeRate-API para garantir valores atualizados. É uma ferramenta ideal para quem busca conversões rápidas ou para entender a integração de APIs RESTful em aplicações Java.

✨ Como Funciona
O coração do programa reside na sua capacidade de consumir uma API externa para obter dados em tempo real. Veja os passos principais:

Requisição da API:

O programa inicia construindo uma URL para a API do ExchangeRate-API, incluindo uma chave de API (necessária para autenticação e uso do serviço).
Ele usa o HttpClient do Java para fazer uma requisição HTTP GET para essa URL.
A resposta da API é um texto no formato JSON, que contém as taxas de câmbio.
<!-- end list -->

Java

// ... (imports)
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        // ...
        String apiKey = "SUA_CHAVE_AQUI"; // Sua chave da API
        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/USD"; // URL da API com base USD

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        // response.body() agora contém o JSON das taxas de câmbio
        // ...
    }
    // ...
}
Parsing do JSON com Gson:

A biblioteca Gson é utilizada para "traduzir" o texto JSON recebido da API em um objeto Java compreensível (DadosCambio).
Este objeto contém um mapa (conversion_rates) onde as chaves são os códigos das moedas (ex: "BRL", "CNY") e os valores são suas respectivas taxas em relação à moeda base (USD, neste caso).
<!-- end list -->

Java

// ...
// Depois de receber a resposta da API
Gson gson = new Gson();
DadosCambio dados = gson.fromJson(response.body(), DadosCambio.class);
// 'dados.conversion_rates' agora tem as taxas de câmbio
// ...

static class DadosCambio {
    String base_code; // Por exemplo, "USD"
    Map<String, Double> conversion_rates; // Mapa com as taxas: {"BRL": 4.90, "EUR": 0.92, ...}
}
Interação com o Usuário e Conversão:

O programa exibe um menu de opções no console, permitindo ao usuário escolher a conversão desejada.
Após o usuário inserir o valor, o programa acessa o mapa conversion_rates para pegar a taxa de câmbio da moeda selecionada.
A conversão é então calculada (multiplicação para USD para outra moeda, ou divisão para outra moeda para USD) e o resultado é exibido formatado.
<!-- end list -->

Java

// ...
// Dentro do loop principal para interação com o usuário
System.out.print("Digite o valor: ");
double valor = scanner.nextDouble();

switch (opcao) {
    case 1: // Dólar => Yuan (China)
        double paraYuan = valor * dados.conversion_rates.get("CNY");
        System.out.printf("%.2f USD = %.2f Yuan Chinês\n", valor, paraYuan);
        break;
    case 2: // Yuan => Dólar
        double paraUsdFromYuan = valor / dados.conversion_rates.get("CNY");
        System.out.printf("%.2f Yuan = %.2f USD\n", valor, paraUsdFromYuan);
        break;
    // ... (outras opções de conversão)
}
// ...
🚀 Tecnologias Utilizadas
Java 11+: Linguagem de programação.
java.net.http.HttpClient: Cliente HTTP nativo do Java para requisições web.
Google Gson: Biblioteca para serialização/desserialização JSON.
🛠️ Como Usar
Pré-requisitos
Certifique-se de ter o Java Development Kit (JDK) 11 ou superior instalado em sua máquina.

Configuração e Execução
Obtenha sua Chave de API:

Visite o site da ExchangeRate-API.
Crie uma conta gratuita para obter sua API Key.
Copie o Código Fonte:

Crie um arquivo chamado Main.java e cole todo o código fornecido nele.
Insira sua Chave de API:

No arquivo Main.java, localize a linha:
Java

String apiKey = "5f84bd6fdc5c126234f93711"; // Substitua esta chave pela SUA CHAVE REAL
Substitua o valor 5f84bd6fdc5c126234f93711 pela API Key que você obteve no passo 1.
Adicione a Dependência Gson:

Maven: Adicione ao seu pom.xml:
XML

<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.10.1</version> </dependency>
Gradle: Adicione ao seu build.gradle:
Groovy

implementation 'com.google.code.gson:gson:2.10.1' // Use a versão mais recente
Compilação Manual: Baixe o JAR do Gson (pesquise por "gson maven repository" para encontrar o link de download direto) e inclua-o no seu classpath ao compilar e executar.
Compile e Execute:

Via IDE (IntelliJ IDEA, Eclipse, VS Code): Importe o projeto e execute a classe Main. A IDE se encarregará das dependências.
Via Linha de Comando:
Bash

# Compile
javac -cp "caminho/para/gson.jar" Main.java

# Execute
java -cp ".;caminho/para/gson.jar" Main
(No Linux/macOS, use : em vez de ; para separar os itens do classpath).
🤝 Contribuições
Sinta-se à vontade para propor melhorias, adicionar novas moedas ou refatorar o código. Pull requests são sempre bem-vindos!
