package br.com.consultacep.principal;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.print("Digite o cep: ");
        Scanner leitura = new Scanner(System.in);
        String cep = leitura.nextLine();

        String endereco = "https://viacep.com.br/ws/" + cep + "/json/";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        String json = response.body();
        System.out.println(json);
    }
}
