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
            // El PDF ya se genera directamente en el método mezclar
            controlador.getMezcla();
            System.out.println("PDF generado desde GeneradorPDF (delegado a Mezclador).");
        } else {
            System.out.println("No se puede generar el PDF debido a errores en los datos o template.");
        }
    }
}
