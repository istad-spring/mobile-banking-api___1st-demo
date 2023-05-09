package co.istad.mbanking.api.file;

import co.istad.mbanking.base.BaseRest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/files")
@Slf4j
@RequiredArgsConstructor
public class FileRestController {

    private final FileService fileService;

    @GetMapping("/download/{name}")
    public ResponseEntity<?> download(@PathVariable String name) {
        Resource resource = fileService.download(name);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header("Content-Disposition", "attachment; filename=" + resource.getFilename())
                .body(resource);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{name}")
    public void deleteByName(@PathVariable String name) {
        fileService.deleteByName(name);
    }

    @GetMapping("/{name}")
    public BaseRest<?> findByName(@PathVariable String name) throws IOException {
        FileDto fileDto = fileService.findByName(name);
        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("File has been found")
                .timestamp(LocalDateTime.now())
                .data(fileDto)
                .build();
    }

    @PostMapping
    public BaseRest<?> uploadSingle(@RequestPart MultipartFile file) {
        log.info("File Request = {}", file);

        FileDto fileDto = fileService.uploadSingle(file);

        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("File has been uploaded")
                .timestamp(LocalDateTime.now())
                .data(fileDto)
                .build();
    }

    @PostMapping("/multiple")
    public BaseRest<?> uploadMultiple(@RequestPart List<MultipartFile> files) {
        log.info("File Request = {}", files);

        List<FileDto> filesDto = fileService.uploadMultiple(files);

        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("File has been uploaded")
                .timestamp(LocalDateTime.now())
                .data(filesDto)
                .build();
    }

}
