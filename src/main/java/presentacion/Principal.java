package presentacion;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import interfaces.Fabrica;
import interfaces.IControladorAgregarCursoAPF;
import interfaces.IControladorAltaCurso;
import interfaces.IControladorAltaEdicion;
import interfaces.IControladorAltaInstituto;
import interfaces.IControladorAltaProgFormacion;
import interfaces.IControladorAltaUsuario;
import interfaces.IControladorConsultaCurso;
import interfaces.IControladorConsultaEdicion;
import interfaces.IControladorInscripcionAEdicion;

import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.awt.event.ActionEvent;
<<<<<<< HEAD
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;

public class Principal {
	private JFrame frame;
	private IngresarInstituto ingresarInstitutoInternalFrame;
	private IngresarUsuario ingresarUsuarioInternalFrame;
	private IngresarCurso ingresarCursoInternalFrame;
	private IngresarEdicion	ingresarEdicionInternalFrame;
	private ConsultaEdicion consultarEdicionInternalFrame;
	private InscripcionAEdicion inscribirAEdicionInternalFrame;
	private ConsultaCurso consultarCursoInternalFrame;
	private IngresarPrograma ingresarProgramaInternalFrame;
	private AgregarCursoAPrograma agregarCursoAPFInternalFrame;
	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Principal() throws PropertyVetoException {
		initialize();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("joaquin");
		System.out.println("Conexion creada");
		Fabrica f = Fabrica.getInstancia();
		IControladorAltaInstituto IConAltInst = f.getIControladorAltaInstituto();
		IControladorAltaUsuario IConAltUsu = f.getIControladorAltaUsuario();
		IControladorAltaCurso IConAltCur = f.getIControladorAltaCurso();
		IControladorAltaEdicion IConAltEd = f.getIControladorAltaEdicion();
		IControladorConsultaEdicion IConConEdi = f.getIControladorConsultaEdicion();
		IControladorInscripcionAEdicion IConInsEd = f.getIControladorInscripcionAEdicion();
		IControladorConsultaCurso IConConCur = f.getIControladorConsultaCurso();
		IControladorAltaProgFormacion IConAltPF = f.getIControladorAltaProgFormacion();
		IControladorAgregarCursoAPF IConAgrCurAPF = f.getIControladorAgregarCursoAPF();
				
		Dimension desktopSize = frame.getSize();
		Dimension jInternalFrameSize;
		
		ingresarInstitutoInternalFrame = new IngresarInstituto(IConAltInst);
		ingresarUsuarioInternalFrame = new IngresarUsuario(IConAltUsu);
		ingresarCursoInternalFrame = new IngresarCurso(IConAltCur);
		ingresarEdicionInternalFrame = new IngresarEdicion(IConAltEd);
		consultarEdicionInternalFrame = new ConsultaEdicion(IConConEdi);
		inscribirAEdicionInternalFrame = new InscripcionAEdicion(IConInsEd);
		consultarCursoInternalFrame = new ConsultaCurso(IConConCur);
		ingresarProgramaInternalFrame = new IngresarPrograma(IConAltPF);
		agregarCursoAPFInternalFrame = new AgregarCursoAPrograma (IConAgrCurAPF);
		
		
		
		//dejamos el jInternalFrame en el medio de la pantalla
		jInternalFrameSize = ingresarInstitutoInternalFrame.getSize();
		ingresarInstitutoInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
		    (desktopSize.height- jInternalFrameSize.height)/2);
		
		ingresarInstitutoInternalFrame.setVisible(false);
		frame.getContentPane().add(ingresarInstitutoInternalFrame);
		ingresarInstitutoInternalFrame.getContentPane().setLayout(null);
		
		jInternalFrameSize = ingresarUsuarioInternalFrame.getSize();
		ingresarUsuarioInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
		    (desktopSize.height- jInternalFrameSize.height)/2);
		
		ingresarUsuarioInternalFrame.setVisible(false);
		frame.getContentPane().add(ingresarUsuarioInternalFrame);
		ingresarUsuarioInternalFrame.getContentPane().setLayout(null);
		
		jInternalFrameSize = ingresarCursoInternalFrame.getSize();
		ingresarCursoInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
		    (desktopSize.height- jInternalFrameSize.height)/2);
		
		ingresarCursoInternalFrame.setVisible(false);
		frame.getContentPane().add(ingresarCursoInternalFrame);
		ingresarCursoInternalFrame.getContentPane().setLayout(null);
		
		jInternalFrameSize = ingresarEdicionInternalFrame.getSize();
		ingresarEdicionInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
		    (desktopSize.height- jInternalFrameSize.height)/2);
		
		ingresarEdicionInternalFrame.setVisible(false);
		frame.getContentPane().add(ingresarEdicionInternalFrame);
		ingresarEdicionInternalFrame.getContentPane().setLayout(null);
		
		jInternalFrameSize = consultarEdicionInternalFrame.getSize();
		consultarEdicionInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
		    (desktopSize.height- jInternalFrameSize.height)/2);
		
		consultarEdicionInternalFrame.setVisible(false);
		frame.getContentPane().add(consultarEdicionInternalFrame);
		consultarEdicionInternalFrame.getContentPane().setLayout(null);
		
		jInternalFrameSize =inscribirAEdicionInternalFrame.getSize();
		inscribirAEdicionInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
		    (desktopSize.height- jInternalFrameSize.height)/2);
		
		inscribirAEdicionInternalFrame.setVisible(false);
		frame.getContentPane().add(inscribirAEdicionInternalFrame);
		inscribirAEdicionInternalFrame.getContentPane().setLayout(null);
		
		jInternalFrameSize =consultarCursoInternalFrame.getSize();
		consultarCursoInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
		    (desktopSize.height- jInternalFrameSize.height)/2);
		
		consultarCursoInternalFrame.setVisible(false);
		frame.getContentPane().add(consultarCursoInternalFrame);
		consultarCursoInternalFrame.getContentPane().setLayout(null);
		
		jInternalFrameSize =ingresarProgramaInternalFrame.getSize();
		consultarCursoInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
		    (desktopSize.height- jInternalFrameSize.height)/2);
		
		ingresarProgramaInternalFrame.setVisible(false);
		frame.getContentPane().add(ingresarProgramaInternalFrame);
		ingresarProgramaInternalFrame.getContentPane().setLayout(null);
				
		jInternalFrameSize =agregarCursoAPFInternalFrame.getSize();
		agregarCursoAPFInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
		    (desktopSize.height- jInternalFrameSize.height)/2);
		
		agregarCursoAPFInternalFrame.setVisible(false);
		frame.getContentPane().add(agregarCursoAPFInternalFrame);
		agregarCursoAPFInternalFrame.getContentPane().setLayout(null);
		
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 923, 578);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnAltas = new JMenu("Altas");
		menuBar.add(mnAltas);
		
		JMenuItem mntmInstitutos = new JMenuItem("Instituto");
		mntmInstitutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ingresarInstitutoInternalFrame.setVisible(true);
			}
		});
		mnAltas.add(mntmInstitutos);
		
		JMenuItem mntmUsuario = new JMenuItem("Usuario");
		mntmUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ingresarUsuarioInternalFrame.setVisible(true);
			}
		});
		mnAltas.add(mntmUsuario);
		
		JMenuItem mntmCurso = new JMenuItem("Curso");
		mntmCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ingresarCursoInternalFrame.setVisible(true);
				ingresarCursoInternalFrame.iniciarlizarComboBoxes();
			}
		});
		mnAltas.add(mntmCurso);
		
		JMenuItem mntmEdicionDeCurso = new JMenuItem("Edición de curso");
		mntmEdicionDeCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ingresarEdicionInternalFrame.setVisible(true);
				ingresarEdicionInternalFrame.iniciarlizarComboBoxCurso();
				ingresarEdicionInternalFrame.iniciarlizarComboBoxDocentes();
			}
		});
		mnAltas.add(mntmEdicionDeCurso);
		
		JMenuItem mntmProgramaDeFormacion = new JMenuItem("Programa de formación");
		mntmProgramaDeFormacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ingresarProgramaInternalFrame.setVisible(true);
			}
		});
		mnAltas.add(mntmProgramaDeFormacion);
		
		JMenu mnConsultas = new JMenu("Consultas");
		menuBar.add(mnConsultas);
		
		JMenuItem mntmEdicionDeCurso_1 = new JMenuItem("Edición de curso");
		mntmEdicionDeCurso_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				consultarEdicionInternalFrame.setVisible(true);
				consultarEdicionInternalFrame.iniciarlizarComboBoxInstituto();
				consultarEdicionInternalFrame.iniciarlizarComboBoxCurso();
				consultarEdicionInternalFrame.iniciarlizarComboBoxEdicion();
			}
		});
		mnConsultas.add(mntmEdicionDeCurso_1);
		
		JMenuItem mntmCurso_1 = new JMenuItem("Curso");
		mntmCurso_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				consultarCursoInternalFrame.setVisible(true);
				consultarCursoInternalFrame.inicializarComboBoxInstituto();
				consultarCursoInternalFrame.inicializarComboBoxCurso();
			}
		});
		mnConsultas.add(mntmCurso_1);
		
		JMenu mnInscripciones = new JMenu("Inscripciones");
		menuBar.add(mnInscripciones);
		
		JMenuItem mntmAEdicion = new JMenuItem("a edición");
		mntmAEdicion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inscribirAEdicionInternalFrame.setVisible(true);
				inscribirAEdicionInternalFrame.iniciarlizarComboBoxInstituto();
				inscribirAEdicionInternalFrame.iniciarlizarComboBoxCurso();
			}
		});
		mnInscripciones.add(mntmAEdicion);
		
		JMenu mnAgregar = new JMenu("Agregar");
		menuBar.add(mnAgregar);
		
		JMenuItem mntmCursoAPrograma = new JMenuItem("curso a programa de formación");
		mntmCursoAPrograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agregarCursoAPFInternalFrame.setVisible(true);
				agregarCursoAPFInternalFrame.inicializarComboBoxCurso();
				agregarCursoAPFInternalFrame.inicializarComboBoxProgramas();

			}
		});
		mnAgregar.add(mntmCursoAPrograma);
	}
}
