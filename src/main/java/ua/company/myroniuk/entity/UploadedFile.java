package ua.company.myroniuk.entity;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Vitalii Myroniuk
 */
public class UploadedFile {
    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
