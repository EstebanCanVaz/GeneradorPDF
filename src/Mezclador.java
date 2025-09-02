import java.util.List;
import java.util.Map;

public class Mezclador {
    public List<String> mezclar(List<String> template, List<Map<String, String>> registros) {
        return registros.stream()
                        .map(registro -> {
                            String result = template.get(0);
                            for (String key : registro.keySet()) {
                                result = result.replace("<" + key + ">", registro.get(key));
                            }
                            return result;
                        })
                        .toList();
    }
}
