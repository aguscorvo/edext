package interfaces;
import java.util.List;

import datatype.DtEdicion;

public interface IControladorConsultaEdicion {
	public List<String> ingresarInstituto(String instituto);
	public List<String> ingresarCurso(String curso);
	public DtEdicion ingresarEdicion(String edicion);
	public String[] getInstitutos();
	public String[] getCursos(String instituto);
	public String[] getEdiciones(String curso);
}
