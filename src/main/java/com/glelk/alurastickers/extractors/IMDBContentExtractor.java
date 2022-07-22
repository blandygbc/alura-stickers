package main.java.com.glelk.alurastickers.extractors;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import main.java.com.glelk.alurastickers.models.Conteudo;
import main.java.com.glelk.alurastickers.net.JsonParser;

public class IMDBContentExtractor implements ContentExtractor {
    public List<Conteudo> extraiConteudos(String json) {
        JsonParser jsonParser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = jsonParser.parse(json);

        List<Conteudo> conteudos = new ArrayList<>();

        for (Map<String, String> atributos : listaDeAtributos) {
            Conteudo conteudo = new Conteudo(atributos.get("title"), atributos.get("image"));
            conteudos.add(conteudo);
        }
        return conteudos;
    }
}
