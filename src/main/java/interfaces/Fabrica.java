package interfaces;
import logica.*;

public class Fabrica {
	private static Fabrica instancia = null;
	
	private Fabrica(){}
	
	public static Fabrica getInstancia() {
		if (instancia == null)
			instancia = new Fabrica();
		return instancia;
	}
	
	public IControladorAltaInstituto getIControladorAltaInstituto() {
		return new ControladorAltaInstituto();		
	}
	
	public IControladorAltaUsuario getIControladorAltaUsuario() {
		return new ControladorAltaUsuario();	
		
	}
	
	public IControladorAltaCurso getIControladorAltaCurso() {
		return new ControladorAltaCurso();
		
		
	}
	
	public IControladorAltaEdicion getIControladorAltaEdicion() {
		return new ControladorAltaEdicion();
		
		
	}
	
	public IControladorConsultaEdicion getIControladorConsultaEdicion() {
		return new ControladorConsultaEdicion();
		
		
	}
	
	public IControladorInscripcionAEdicion getIControladorInscripcionAEdicion() {
		return new ControladorInscripcionAEdicion();
		
		
	}
	
	public IControladorConsultaCurso getIControladorConsultaCurso() {
		return new ControladorConsultaCurso();
		
		
	}
	/*
	public IControladorAgregarCursoAPF getIControladorAgregarCursoAPF() {
		return new ControladorAgregarCursoAPF();
		
		
	}
	public IControladorAltaCurso getIControladorAltaCurso() {
		return new ControladorAltaCurso();
		
		
	}
	public IControladorAltaEdicion getIControladorAltaEdicion() {
		return new ControladorAltaEdicion();
		
		
	}
	
	public IControladorAltaProgFormacion getIControladorAltaProgFormacion() {
		return new ControladorAltaProgFormacion();
		
		
	}
	
	public IControladorConsultaCurso getIControladorConsultaCurso() {
		return new ControladorConsultaCurso();
		
		
	}
	public IControladorConsultaEdicion getIControladorConsultaEdicion() {
		return new ControladorConsultaEdicion();
		
		
	}
	public IControladorConsultaProgFormacion getIControladorConsultaProgFormacion() {
		return new ControladorProgFormacion();
		
		
	}
	
	public IControladorConsultaUsuario getIControladorConsultaUsuario() {
		return new ControladorConsultaUsuario();
		
		
	}
	
	public IControladorModificarDatosUsuario getIControladorModificarDatosUsuario() {
		return new ControladorModificarDatosUsuario();
		
		
	}
	
	*/
}
