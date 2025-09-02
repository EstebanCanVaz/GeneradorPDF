import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LecturaTemplate {
    private String ruta;
    private String temp;
    private List<String> identificadores = new ArrayList<>();

    public LecturaTemplate(String ruta) {
        this.ruta = ruta;
        this.temp = leerTemp();
        this.identificadores = getIdentificadores();
    }

    public String leerTemp() {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    public List<String> getIdentificadores() {
        List<String> identificadoresList = new ArrayList<>();
        int startIdx, endIdx;
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) == '<') {
                startIdx = i + 1;
                endIdx = temp.indexOf('>', startIdx);
                if (endIdx != -1) {
                    identificadoresList.add(temp.substring(startIdx, endIdx));
                    i = endIdx;
                }
            }
        }
        return identificadoresList;
    }

    public String getTemp() {
        return temp;
    }

    public List<String> getIdentificadoresList() {
        return identificadores;
    }
}
