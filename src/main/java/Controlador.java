import java.util.List;

public class Controlador {
    private LecturaTemplate template;
    private LecturaCSV csv;
    private Validador validador = new Validador();
    private Mezclador mezclador = new Mezclador();

    public Controlador(LecturaTemplate template, LecturaCSV csv) {
        this.template = template;
        this.csv = csv;
    }

    public boolean compararIdentificadores() {
        return validador.validarTemplate(template) && validador.validarDatos(csv, template);
    }

    public List<String> getMezcla() {
        return mezclador.mezclar(template.getTemp(), csv.getRegistrosList(), template.getIdentificadoresList());
    }
}
