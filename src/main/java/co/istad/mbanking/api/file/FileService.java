package co.istad.mbanking.api.file;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileService {


    Resource download(String name);


    void deleteByName(String name);

    /**
     * uses to find file by name
     * @param name of file
     * @return FileDto
     * @throws IOException internal error
     */
    FileDto findByName(String name) throws IOException;

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
