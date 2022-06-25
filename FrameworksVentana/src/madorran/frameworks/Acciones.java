package madorran.frameworks;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Acciones extends JPanel {

	private JButton salir;
	private JFrame frame;
	private JPanel panel;

	public Acciones(List<Accion> acciones) {

		frame = new JFrame();
		panel = new JPanel();
		frame.getContentPane().add(panel);

		frame.setTitle("Menu de acciones");
		frame.setBounds(160, 160, 593, 349);
		frame.setVisible(true);
		for (Accion accion : acciones) {
			JButton botonAccion = new JButton(accion.nombreItemMenu());
			botonAccion.addActionListener(event -> {
				accion.ejecutar();
				JFrame jFrame = new JFrame();
				JOptionPane.showMessageDialog(jFrame, accion.descripcionItemMenu());
			});
			panel.add(botonAccion);
			panel.revalidate();
			panel.repaint();
		}
		salir = new JButton("Salir");
		salir.addActionListener(event -> {
			frame.dispose();
		});
		panel.add(salir);

	}

}
