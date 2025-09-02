import java.util.Map;

public class Validador {
    public boolean validarTemplate(LecturaTemplate template) {
        return !template.getIdentificadoresList().isEmpty();
    }

    public boolean validarDatos(LecturaCSV csv, LecturaTemplate template) {
        for (String identificador : template.getIdentificadoresList()) {
            boolean found = false;
            for (Map<String, String> registro : csv.getRegistrosList()) {
                if (registro.containsKey(identificador)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }
}

