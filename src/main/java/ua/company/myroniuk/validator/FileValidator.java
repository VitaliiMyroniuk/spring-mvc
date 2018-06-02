package ua.company.myroniuk.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ua.company.myroniuk.entity.UploadedFile;

/**
 * @author Vitalii Myroniuk
 */
public class FileValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object object, Errors errors) {
        UploadedFile uploadedFile = (UploadedFile) object;
        if (uploadedFile.getFile().getSize() == 0) {
            errors.rejectValue("file", "uploadFile.selectFile", "Please select a file");
        }
    }
}
