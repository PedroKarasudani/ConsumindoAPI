package br.com.consultacep.principal;

import java.io.FileWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.print("Digite o cep: ");
        Scanner leitura = new Scanner(System.in);
        String cep = leitura.nextLine();

        String endereco = "https://viacep.com.br/ws/" + cep + "/json/";

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        String json = response.body();
        
        FileWriter escrita = new FileWriter("cep.json");
        escrita.write(gson.toJson(json));
        escrita.close();
    }
}
