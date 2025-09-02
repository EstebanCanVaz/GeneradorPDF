import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

public class GeneradorPDF {
    public void generar(Controlador controlador) {
        if (controlador.compararIdentificadores()) {
            List<String> mezclas = controlador.getMezcla();
            try {
                Document document = new Document();
                PdfWriter.getInstance(document, new FileOutputStream("output.pdf"));
                document.open();
                for (int i = 0; i < mezclas.size(); i++) {
                    document.add(new Paragraph(mezclas.get(i)));
                    document.newPage();
                }
                document.close();
                System.out.println("PDF generado exitosamente.");
            } catch (DocumentException | FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No se puede generar el PDF debido a errores en los datos o template.");
        }
    }
}