package br.com.deveficiente.youtubeapidacdc.bookdeatils;

import org.springframework.web.multipart.MultipartFile;

@FunctionalInterface
public interface Uploader {
    public String upload(MultipartFile file);
}
