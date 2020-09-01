package presentacion;


import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import interfaces.IControladorAltaCurso;
import javax.swing.JLabel;
import javax.swing.JTextField;

import datatype.DtCurso;
import excepciones.CursoRepetidoException;
import excepciones.NoExisteCursoException;
import excepciones.NoExisteInstitutoException;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;

public class IngresarCurso extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	private IControladorAltaCurso iConAltCur;
	
	private JTextField textFieldNombre;
	private JTextField textFieldDescripcion;
	private JTextField textFieldCantHoras;
	private JTextField textFieldDuracion;
	private JTextField textFieldURL;
	private JTextField textFieldInstituto;
	private JTextField textFieldCreditos;
	

	
	public IngresarCurso(IControladorAltaCurso iConAltCur) {
		this.iConAltCur = iConAltCur;
		setResizable(true);
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Ingresar Curso");
		setBounds(100, 100, 809, 483);
		getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(76, 74, 70, 15);
		getContentPane().add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(186, 72, 172, 19);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("DESCRIPCIÓN");
		lblDescripcion.setBounds(76, 127, 92, 15);
		getContentPane().add(lblDescripcion);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setBounds(186, 125, 172, 19);
		getContentPane().add(textFieldDescripcion);
		textFieldDescripcion.setColumns(10);
		
		JLabel lblDuracin = new JLabel("DURACIÓN");
		lblDuracin.setBounds(76, 176, 79, 15);
		getContentPane().add(lblDuracin);
		
		JLabel lblCantidadDeHoras = new JLabel("CANTIDAD DE HORAS");
		lblCantidadDeHoras.setBounds(76, 224, 150, 15);
		getContentPane().add(lblCantidadDeHoras);
		
		textFieldCantHoras = new JTextField();
		textFieldCantHoras.setBounds(279, 224, 79, 19);
		getContentPane().add(textFieldCantHoras);
		textFieldCantHoras.setColumns(10);
		
		textFieldDuracion = new JTextField();
		textFieldDuracion.setBounds(279, 174, 79, 19);
		getContentPane().add(textFieldDuracion);
		textFieldDuracion.setColumns(10);
		
		JLabel lblUrl = new JLabel("URL");
		lblUrl.setBounds(77, 325, 32, 15);
		getContentPane().add(lblUrl);
		
		textFieldURL = new JTextField();
		textFieldURL.setBounds(126, 323, 232, 19);
		getContentPane().add(textFieldURL);
		textFieldURL.setColumns(10);
		
		JLabel lblPrevias = new JLabel("PREVIAS");
		lblPrevias.setBounds(76, 364, 62, 15);
		getContentPane().add(lblPrevias);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresarCursoConfirmarActionPerformed(e);
			}
		});
		btnConfirmar.setBounds(454, 140, 117, 25);
		getContentPane().add(btnConfirmar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresarCursoCancelarActionPerformed(e);
			}
		});
		btnCancelar.setBounds(454, 202, 117, 25);
		getContentPane().add(btnCancelar);
		
		JLabel lblInstituto = new JLabel("INSTITUTO");
		lblInstituto.setBounds(76, 32, 85, 15);
		getContentPane().add(lblInstituto);
		
		textFieldInstituto = new JTextField();
		textFieldInstituto.setBounds(186, 30, 172, 19);
		getContentPane().add(textFieldInstituto);
		textFieldInstituto.setColumns(10);
		
		JLabel lblCrditos = new JLabel("CRÉDITOS");
		lblCrditos.setBounds(76, 271, 70, 15);
		getContentPane().add(lblCrditos);
		
		textFieldCreditos = new JTextField();
		textFieldCreditos.setBounds(279, 269, 79, 19);
		getContentPane().add(textFieldCreditos);
		textFieldCreditos.setColumns(10);


	}
	protected void ingresarCursoConfirmarActionPerformed(ActionEvent e) {
		String instituto= textFieldInstituto.getText();
		String nombre = textFieldNombre.getText();
		String desc = textFieldDescripcion.getText();
		String d = textFieldDuracion.getText();
		String cHoras  = textFieldCantHoras.getText();
		String cred = textFieldCreditos.getText();
		Date fechaR = new Date();
		String url = textFieldURL.getText();
		List <String> previas = new ArrayList<String>();
		if (checkTextField(instituto) & checkTextField(nombre)& checkTextField(desc) & checkTextFieldInt(cHoras) & checkTextFieldInt(cred) & checkTextFieldInt(d) & checkTextField(url)) {
			
			int duracion = Integer.parseInt(d);
			int cantHoras = Integer.parseInt(cHoras);
			int creditos = Integer.parseInt(cred);
			DtCurso dt = new DtCurso(nombre, desc, duracion, cantHoras, creditos, fechaR, url, previas);			
			try {
				iConAltCur.ingresarCurso(instituto, dt);
				iConAltCur.confirmarAltaCurso();
				JOptionPane.showMessageDialog(this, "El curso se ha creado con éxito", "Ingresar Curso", JOptionPane.INFORMATION_MESSAGE);

			}catch (NoExisteInstitutoException neie) {
	              JOptionPane.showMessageDialog(this, neie.getMessage(), "Ingresar Curso", JOptionPane.ERROR_MESSAGE);

			}catch (CursoRepetidoException cre) {
	              JOptionPane.showMessageDialog(this, cre.getMessage(), "Ingresar Curso", JOptionPane.ERROR_MESSAGE);

			}catch(NoExisteCursoException nece) {
	               JOptionPane.showMessageDialog(this, nece.getMessage(), "Ingresar Curso", JOptionPane.ERROR_MESSAGE);

			}
		}
		limpiarFormulario();
        setVisible(false);
	
	}
	
	
	protected void ingresarCursoCancelarActionPerformed(ActionEvent e) {
		iConAltCur.cancelarAltaCurso();
		limpiarFormulario();
		setVisible(false);
	}
	
	
	private boolean checkTextField(String string) {
		
		if(string.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Ningún campo puede quedar vacío.", "Ingresar Curso",
                    JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		return true;			
		
	}

	
	private boolean checkTextFieldInt(String string) {
	    if (string.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Ningún campo puede quedar vacío.", "Ingresar Curso",
	                JOptionPane.ERROR_MESSAGE);
	        return false;
	    }
	    try {
	        Integer.parseInt(string);
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(this, "Cantidad de horas, créditos y duración deben ser un número.", "Ingresar Curso",
	                JOptionPane.ERROR_MESSAGE);
	        return false;
	    }
	    return true;
	}
	
	private void limpiarFormulario() {
		textFieldInstituto.setText("");
		textFieldNombre.setText("");
		textFieldDescripcion.setText("");
		textFieldCantHoras.setText("");
		textFieldDuracion.setText("");
		textFieldCreditos.setText("");
		textFieldURL.setText("");
	}
}
