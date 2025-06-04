import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);

        String apiKey = "5f84bd6fdc5c126234f93711";
        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/USD";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        Gson gson = new Gson();
        DadosCambio dados = gson.fromJson(response.body(), DadosCambio.class);

        while (true) {
            System.out.println("\n====================");
            System.out.println("Escolha uma opção (1 a 6):");
            System.out.println("1 - Dólar => Yuan (China)");
            System.out.println("2 - Yuan => Dólar");
            System.out.println("3 - Dólar => Real Brasileiro");
            System.out.println("4 - Real => Dólar");
            System.out.println("5 - Dólar => Euro");
            System.out.println("6 - Euro => Dólar");
            System.out.println("7 - Sair");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();

            if (opcao == 7) {
                System.out.println("Programa finalizado.");
                break;
            }

            System.out.print("Digite o valor: ");
            double valor = scanner.nextDouble();

            switch (opcao) {
                case 1:
                    double paraYuan = valor * dados.conversion_rates.get("CNY");
                    System.out.printf("%.2f USD = %.2f Yuan Chinês\n", valor, paraYuan);
                    break;
                case 2:
                    double paraUsdFromYuan = valor / dados.conversion_rates.get("CNY");
                    System.out.printf("%.2f Yuan = %.2f USD\n", valor, paraUsdFromYuan);
                    break;
                case 3:
                    double paraReal = valor * dados.conversion_rates.get("BRL");
                    System.out.printf("%.2f USD = %.2f BRL\n", valor, paraReal);
                    break;
                case 4:
                    double paraUsdFromReal = valor / dados.conversion_rates.get("BRL");
                    System.out.printf("%.2f BRL = %.2f USD\n", valor, paraUsdFromReal);
                    break;
                case 5:
                    double paraEuro = valor * dados.conversion_rates.get("EUR");
                    System.out.printf("%.2f USD = %.2f EUR\n", valor, paraEuro);
                    break;
                case 6:
                    double paraUsdFromEuro = valor / dados.conversion_rates.get("EUR");
                    System.out.printf("%.2f EUR = %.2f USD\n", valor, paraUsdFromEuro);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }

    static class DadosCambio {
        String base_code;
        Map<String, Double> conversion_rates;
    }
}
