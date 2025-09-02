import java.util.List;

public class Controlador {
    private LecturaTemplate template;
    private LecturaCSV csv;
    private Validador validador = new Validador();

    public Controlador(LecturaTemplate template, LecturaCSV csv) {
        this.template = template;
        this.csv = csv;
    }

    public boolean compararIdentificadores() {
        return validador.validarTemplate(template) && validador.validarDatos(csv, template);
    }

    public List<String> getMezcla() {
        return csv.getRegistrosList().stream()
                  .map(registro -> {
                      String temp = template.getTemp();
                      for (String identificador : template.getIdentificadoresList()) {
                          temp = temp.replace("<" + identificador + ">", registro.get(identificador));
                      }
                      return temp;
                  })
                  .toList();
    }
}
