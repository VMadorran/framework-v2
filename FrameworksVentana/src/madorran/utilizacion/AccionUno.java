package madorran.utilizacion;

import madorran.frameworks.Accion;

public class AccionUno implements Accion {

	@Override
	public void ejecutar() {
		// TODO Auto-generated method stub
		System.out.println("Se esta ejecutando la accion uno");

	}

	@Override
	public String nombreItemMenu() {
		// TODO Auto-generated method stub

		return "Accion uno";
	}

	@Override
	public String descripcionItemMenu() {
		// TODO Auto-generated method stub
		return "Ejecutar� la acccion uno";
	}
}