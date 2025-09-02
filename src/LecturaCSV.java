import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class LecturaCSV {
    private String ruta;
    private Set<String> identificadoresSet;
    private List<Map<String, String>> registros = new ArrayList<>();

    public LecturaCSV(String ruta, List<String> identificadores) {
        this.ruta = ruta;
        this.identificadoresSet = new HashSet<>(identificadores);
        this.registros = getRegistros();
    }

    public List<Map<String, String>> getRegistros() {
        List<Map<String, String>> registrosList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String line;
            String[] headers = br.readLine().split(",");
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Map<String, String> registro = new HashMap<>();
                for (int i = 0; i < headers.length; i++) {
                    if (identificadoresSet.contains(headers[i])) {
                        registro.put(headers[i], data[i]);
                    }
                }
                registrosList.add(registro);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return registrosList;
    }

    public List<Map<String, String>> getRegistrosList() {
        return registros;
    }
}
