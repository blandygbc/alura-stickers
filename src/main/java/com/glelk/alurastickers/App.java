package main.java.com.glelk.alurastickers;

import java.net.URL;
import java.util.List;

import main.java.com.glelk.alurastickers.extractors.ContentExtractor;
import main.java.com.glelk.alurastickers.extractors.NasaContentExtractor;
import main.java.com.glelk.alurastickers.generator.StickersGenerator;
import main.java.com.glelk.alurastickers.models.Conteudo;
import main.java.com.glelk.alurastickers.net.ClienteHttp;

public class App {
    public static void main(String[] args) throws Exception {

        final String url = "https://api.mocki.io/v2/549a5d8b/NASA-APOD";

        ClienteHttp http = new ClienteHttp();
        String json = http.buscaDados(url);

        ContentExtractor extrator = new NasaContentExtractor();
        List<Conteudo> listaDeConteudos = extrator.extraiConteudos(json);

        StickersGenerator stickersGenerator = new StickersGenerator();

        for (Conteudo conteudo : listaDeConteudos) {
            System.out.println(conteudo.getTitulo());
            stickersGenerator.cria(
                    new URL(conteudo.getUrlImagem()).openStream(),
                    conteudo.getTitulo());

        }

    }
}
