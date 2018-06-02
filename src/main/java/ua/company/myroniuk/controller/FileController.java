package ua.company.myroniuk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ua.company.myroniuk.entity.UploadedFile;
import ua.company.myroniuk.exception.BadFileNameException;
import ua.company.myroniuk.validator.FileValidator;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Vitalii Myroniuk
 */
@Controller
@SessionAttributes("fileName")
public class FileController {
    private static final String CATALINA_HOME = "catalina.home";

    @Autowired
    private FileValidator fileValidator;

    @RequestMapping(path = "/upload_file", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView uploadFile(@ModelAttribute(name = "file") UploadedFile uploadedFile,
                                   BindingResult bindingResult) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        MultipartFile multipartFile = uploadedFile.getFile();
        fileValidator.validate(uploadedFile, bindingResult);
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("/home");
        } else {
            uploadFile(multipartFile);
            RedirectView redirectView = new RedirectView("success_uploaded_file");
            redirectView.setStatusCode(HttpStatus.FOUND);
            modelAndView.setView(redirectView);
            modelAndView.addObject("fileName",  multipartFile.getOriginalFilename());
        }
        return modelAndView;
    }

    @RequestMapping(path = "/success_uploaded_file", method = RequestMethod.GET)
    public String successUploadedFile() {
        return "success_uploaded_file";
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "IOException was thrown!")
    @ExceptionHandler(IOException.class)
    public void handleIOException() {
    }

    @ExceptionHandler(BadFileNameException.class)
    public ModelAndView handleBadFileNameException(Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.addObject("error", e.getMessage());
        return modelAndView;
    }

    private void uploadFile(MultipartFile multipartFile) throws Exception {
        byte[] bytes = multipartFile.getBytes();
        String fileName = multipartFile.getOriginalFilename();
        String path = System.getProperty(CATALINA_HOME);
        File dir = new File(path + File.separator + "tmp");
        if(!dir.exists()) {
            dir.mkdirs();
        }
        File file = new File(dir.getAbsolutePath() + File.separator + fileName);
        BufferedOutputStream baos = new BufferedOutputStream(new FileOutputStream(file));
        baos.write(bytes);
        baos.flush();
        baos.close();
//        throw new IOException();
//        throw new BadFileNameException("File name is not valid");
//        throw new Exception();
    }

}
