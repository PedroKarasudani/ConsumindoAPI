package br.com.consultacep.principal;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;


import com.google.gson.Gson;

public class ConsultaCep {

        
          
        public Endereco buscaEndereco(String cep){
            URI endereco = URI.create("https://viacep.com.br/ws/" + cep + "/json/");
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(endereco).build();
            try {
                HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
                return new Gson().fromJson(response.body(), Endereco.class);
            } catch (Exception e) {
                throw new RuntimeException("Nao consegui obter o endereco atraves desse CEP!!");
            }
            
            //String json = response.body();
            // Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
            // Endereco meuEndereco = gson.fromJson(json, Endereco.class);
            // return meuEndereco;
        }

}
