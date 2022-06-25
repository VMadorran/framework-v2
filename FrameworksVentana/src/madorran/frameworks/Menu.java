package madorran.frameworks;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Menu {

	List<Accion> acciones = new ArrayList<Accion>();
	String pathProperties;

	public Menu(String pathProperties) throws Exception {
		if (pathProperties == null)
			throw new Exception("El path ingresado es nulo");
		this.pathProperties = pathProperties;
	}

	public void iniciar() {

		Properties prop = new Properties();
		try (InputStream configFile = getClass().getResourceAsStream(this.pathProperties);) {
			prop.load(configFile);
			String clase = prop.getProperty("clase");
			String[] clases = clase.split(";");
			for (int i = 0; i < clases.length; i++) {
				Class<?> c = Class.forName(clases[i]);
				this.acciones.add((Accion) c.getDeclaredConstructor().newInstance());
			}

			this.mostrarAcciones();
		} catch (Exception e) {
			throw new RuntimeException("No fue posible crear las instancias de acciones... ", e);
		}

	}

	private void mostrarAcciones() {

		var acciones = new Acciones(this.acciones);
		acciones.getVisibleRect();

	}

}
