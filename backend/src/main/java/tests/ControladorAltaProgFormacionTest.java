package tests;

import java.util.Date;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import datatype.DtProgFormacion;
import excepciones.ProgramaRepetidoException;
import interfaces.Fabrica;
import interfaces.IControladorAltaProgFormacion;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControladorAltaProgFormacionTest {

	public Fabrica f = Fabrica.getInstancia();
	public IControladorAltaProgFormacion iCon = f.getIControladorAltaProgFormacion();

	@Test
	public void Test_1_ingresarProgFormacionOK() throws ProgramaRepetidoException{
		
		Date fecha = new Date();
		DtProgFormacion programa = new DtProgFormacion("programaPrueba","es una prueba",fecha,fecha,fecha);
		iCon.ingresarProgFormacion(programa);
		iCon.confirmarAltaPrograma();
	};
	
	@Test(expected = ProgramaRepetidoException.class)
	public void Test_2_ingresarProgFormacionERROR() throws ProgramaRepetidoException{
		Date fecha = new Date();
		DtProgFormacion programa = new DtProgFormacion("programaPrueba","es una prueba",fecha,fecha,fecha);
		iCon.ingresarProgFormacion(programa);
		iCon.confirmarAltaPrograma();

	}

	
}