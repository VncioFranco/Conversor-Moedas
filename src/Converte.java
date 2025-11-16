import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class Converte {

    private String carregarChaveApi() {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            props.load(fis);

            return props.getProperty("api.key");

        } catch (IOException e) {

            System.err.println("\n ERRO: Não foi possível carregar o arquivo config.properties. Sua chave API não foi lida.");
            System.err.println("Por favor, crie o arquivo e certifique-se de que ele está no diretório correto.");
            return "CHAVE_DEMOSTRACAO_OU_VAZIA";
        }
    }
    double resultadoConversao;
    public  Conversor converteMoeda(String moedaAlvo, String moedaBase, int quantidade) throws IOException, InterruptedException {
        String apiKey =carregarChaveApi();

        String url = ("https://v6.exchangerate-api.com/v6/"+apiKey+"/pair/" + moedaBase + "/" + moedaAlvo + "/" + quantidade);
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            JsonElement elemento = JsonParser.parseString(response.body());
            JsonObject objectRoot = elemento.getAsJsonObject();


            double taxaConversao = objectRoot.get("conversion_rate").getAsDouble();
             resultadoConversao = objectRoot.get("conversion_result").getAsDouble();

            return new Conversor(moedaBase, moedaAlvo, taxaConversao, resultadoConversao);




        } catch (IOException e) {
            System.out.println("Erro de rede ou interrupção: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            System.out.println("Erro: " + e);
            return null;

        }

    }

    }


