package com.javarush.task.pro.task15.task1521;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Этот код работает!
 * */
public class TestUrl {
    public static void main(String[] args) throws IOException {
        String image = "https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png";
        URL url = new URL(image);
        InputStream input = url.openStream();

        Path path = Path.of("c:\\temp\\GoogleLogo.png");
        Files.copy(input, path);
    }
}
