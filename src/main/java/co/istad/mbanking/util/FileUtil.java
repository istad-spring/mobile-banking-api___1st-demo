package co.istad.mbanking.util;

import co.istad.mbanking.api.file.FileDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Component
public class FileUtil {

    @Value("${file.server-path}")
    private String fileServerPath;

    @Value("${file.base-url}")
    private String fileBaseUrl;

    public FileDto upload(MultipartFile file) {

        int lastDotIndex = file.getOriginalFilename().lastIndexOf(".");
        String extension = file.getOriginalFilename().substring(lastDotIndex + 1);

        long size = file.getSize();

        String name = String.format("%s.%s", UUID.randomUUID(), extension);

        String url = String.format("%s%s", fileBaseUrl, name);

        Path path = Paths.get(fileServerPath + name);

        try {
            Files.copy(file.getInputStream(), path);
            return FileDto.builder()
                    .name(name)
                    .url(url)
                    .extension(extension)
                    .size(size)
                    .build();

        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Upload file failed, please contact developer [012345678]!");
        }
    }

}
