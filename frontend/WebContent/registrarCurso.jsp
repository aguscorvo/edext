<%@page import="interfaces.Fabrica" %>
<%@page import="interfaces.IControladorAltaCurso" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<%@include file="/header.jsp"%>
<link rel="stylesheet" href="css/estilos.css">
<title>Registro de curso</title>
</head>

<body>

<%Fabrica fab = Fabrica.getInstancia();
IControladorAltaCurso iCon = fab.getIControladorAltaCurso();
String [] institutos= iCon.getInstitutos();
String [] cursos=iCon.getCursos();
String [] categorias=iCon.getCategorias();

%>

<form action="RegistrarCurso" method="post" id="formulario">
  
  <select name="instituto" class="custom-select" id="instituto" required>
	  <option selected disabled value="">Seleccione instituto</option>
	  
		  <%int i=0;
		  while (i<institutos.length){%>
			  <option value="<%=institutos[i]%>"><%=institutos[i]%></option>
			 <% i++;
		  } %>	
	    
  </select>
  
  <div class="form-group">
    <input type="text" name= "nombre" class="form-control" placeholder="Nombre" required >
  </div>
  <div class="form-group">
    <input type="text" name= "descripcion" class="form-control" placeholder="Descripción" required>
  </div>
  <div class="form-group">
    <input type="number" name= "duracion" class="form-control" placeholder="Duración"  required>
  </div>
  <div class="form-group">
    <input type="number" name= "cantHoras" class="form-control" placeholder="Cantidad de horas"  required>
  </div>
  <div class="form-group">
    <input type="number" name= "creditos" class="form-control" placeholder="Créditos"  required>
  </div>
  <div class="form-group">
    <input type="url" name= "url" class="form-control" placeholder="Url" required>
  </div>  
  
  <select name="previas" class="custom-select" multiple id="previas">
	  <option selected disabled value="">Seleccione previa</option>
	  
		  <%int j=0;
		  while (j<cursos.length){%>
			  <option value="<%=cursos[j]%>"><%=cursos[j]%></option>
			 <% j++;
		  } %>	
	  
  </select>
   
   <select name="categorias" class="custom-select"  multiple id="categorias" required>
	  <option selected disabled value="">Seleccione categoría/s</option>
	  
		<%int k=0;
		  while (k<categorias.length){%>
			  <option value="<%=categorias[k]%>" ><%=categorias[k]%></option>
			 <% k++;
		  } %>	

  </select>
  
  
  <button type="submit" class="btn btn-dark">Submit</button> 
  
   
</form>






<%@include file="/footer.jsp"%>

</body>
</html>