package main.java.com.glelk.alurastickers.generator;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class StickersGenerator {
    public void cria(InputStream inputStream, String nomeArquivo) throws IOException {
        BufferedImage imgOriginal = ImageIO.read(inputStream);
        int width = imgOriginal.getWidth();
        int height = imgOriginal.getHeight() + 200;

        BufferedImage newImg = new BufferedImage(width, height, Transparency.TRANSLUCENT);

        Graphics2D graphics = (Graphics2D) newImg.getGraphics();
        graphics.drawImage(imgOriginal, 0, 0, null);

        graphics.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 64));
        graphics.setColor(Color.YELLOW);
        graphics.drawString("TOPZERA", width * 29 / 100, height - 100);

        ImageIO.write(newImg, "png", new File("assets/generated_stickers/" + nomeArquivo + ".png"));
    }
}
