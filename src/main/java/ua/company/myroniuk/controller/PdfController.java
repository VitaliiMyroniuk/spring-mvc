package ua.company.myroniuk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Vitalii Myroniuk
 */
@Controller
public class PdfController {

    @RequestMapping(path = "/download_pdf", method = RequestMethod.GET)
    public String downloadPdf() {
        return "pdf_view";
    }

}
