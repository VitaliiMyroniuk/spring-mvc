package ua.company.myroniuk.util;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author Vitalii Myroniuk
 */
public class PdfBuilder extends AbstractPdfView {

    private static final String PARAGRAPH = "Some paragraph";

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document,
                                    PdfWriter pdfWriter, HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse) throws Exception {
        document.add(new Paragraph(PARAGRAPH));
    }

}
