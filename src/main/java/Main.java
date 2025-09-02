public class Main {
    public static void main(String[] args) {
        LecturaTemplate lecturaTemplate = new LecturaTemplate("template.txt");
        LecturaCSV lecturaCSV = new LecturaCSV("datos.csv", lecturaTemplate.getIdentificadoresList());
        Controlador controlador = new Controlador(lecturaTemplate, lecturaCSV);
        GeneradorPDF generadorPDF = new GeneradorPDF();
        generadorPDF.generar(controlador);
    }
}

