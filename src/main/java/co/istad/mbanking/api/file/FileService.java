package co.istad.mbanking.api.file;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {

    /**
     * uses to upload a single file
     * @param file request form data from client
     * @return FileDto
     */
    FileDto uploadSingle(MultipartFile file);

    /**
     * uses to upload multiple files
     * @param files request form data from client
     * @return FileDto
     */
    List<FileDto> uploadMultiple(List<MultipartFile> files);

}
