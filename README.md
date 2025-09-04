# Generador de PDF

Proyecto de la asignatura Arquitectura de Software que crea documentos PDF personalizados combinando plantillas de texto con datos de archivos CSV.

## ¿Cómo funciona?

El sistema funciona en 4 pasos principales:

1. **Lectura de Template**: Lee un archivo de plantilla (`template.txt`) que contiene texto con marcadores de posición entre corchetes angulares (ej: `<destinatario>`, `<remitente>`)

2. **Lectura de Datos CSV**: Procesa un archivo CSV (`datos.csv`) que contiene los datos para reemplazar los marcadores de la plantilla

3. **Validación**: Verifica que todos los marcadores del template tengan datos correspondientes en el archivo CSV

4. **Generación**: Combina la plantilla con cada fila de datos del CSV, reemplazando los marcadores con los valores reales, y genera documentos PDF personalizados

## Estructura del Proyecto

- `main.java.Main.java`: Punto de entrada que coordina todo el proceso
- `main.java.LecturaTemplate.java`: Lee y extrae marcadores de la plantilla
- `main.java.LecturaCSV.java`: Procesa el archivo de datos CSV
- `main.java.Controlador.java`: Coordina la validación y mezcla de datos
- `main.java.Validador.java`: Valida la compatibilidad entre template y datos
- `GeneradorPDF.java`: Genera los documentos PDF finales
- `main.java.Mezclador.java`: Combina plantillas con datos (clase auxiliar)

## Ejemplo

**Template** (`template.txt`):
```
Estimado <destinatario>,
...
Atentamente,
<remitente>
```

**Datos** (`datos.csv`):
```
destinatario,remitente
Mauricio,Esteban
Jose Marin,Julio Quijano
```

**Resultado**: Se generan PDFs personalizados para cada fila del CSV.
