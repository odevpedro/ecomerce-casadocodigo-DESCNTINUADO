package br.com.deveficiente.youtubeapidacdc.bookdeatils;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class LocalUploader implements Uploader{
    @Override
    public String upload(MultipartFile file) {
        System.out.println("Enviando arquivo");
        return "htpp://google.com" + file.getOriginalFilename();
    }
}
