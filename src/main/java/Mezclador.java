import java.util.List;
import java.util.Map;

public class Mezclador {
    public List<String> mezclar(String template, List<Map<String, String>> registros, List<String> identificadores) {
        return registros.stream()
                        .map(registro -> {
                            String result = template;
                            for (String identificador : identificadores) {
                                result = result.replace("<" + identificador + ">", registro.get(identificador));
                            }
                            return result;
                        })
                        .toList();
    }
}
