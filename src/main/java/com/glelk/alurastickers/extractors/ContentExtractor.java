package main.java.com.glelk.alurastickers.extractors;

import java.util.List;

import main.java.com.glelk.alurastickers.models.Conteudo;

public interface ContentExtractor {
    public List<Conteudo> extraiConteudos(String json);
}
