package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

	public static void main(String arg[]) {

		ReadProperties miPrincipal = new ReadProperties();
		miPrincipal.leerArchivo();
	}

	/**
	 * Lee un archivo de propiedades desde una ruta especifica y se imprime en
	 * pantalla.
	 */
	private void leerArchivo() {
		try {

			/** Creamos un Objeto de tipo Properties */
			Properties propiedades = new Properties();

			/** Cargamos el archivo desde la ruta especificada */
			propiedades.load(new FileInputStream(
					"src/properties/armas.properties"));

			/** Obtenemos los parametros definidos en el archivo */
			String tipo = propiedades.getProperty("arma.espadaancha.tipo");
			String categoria = propiedades.getProperty("arma.espadaancha.categoria");

			/** Imprimimos los valores */
			System.out.println("Tipo: " + tipo + "\n" + "Categoria: " + categoria);

		} catch (FileNotFoundException e) {
			System.out.println("Error, El archivo no exite");
		} catch (IOException e) {
			System.out.println("Error, No se puede leer el archivo");
		}
	}
}
