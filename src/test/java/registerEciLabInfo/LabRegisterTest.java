package registerEciLabInfo;

import static org.junit.Assert.assertTrue;
import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.Generate.*;
import static org.quicktheories.generators.SourceDSL.*;
import org.junit.Test;
import java.sql.Date;

import com.google.inject.Inject;
import com.registerLab.ECILabException;
import com.registerLab.entities.Elemento;
import com.registerLab.entities.Equipo;
import com.registerLab.servicios.ServiciosECILabImpl;

public class LabRegisterTest extends TestBase{
	@Inject
	private ServiciosECILabImpl lab;
	@Test
	public void siUnEquipoNoExisteDeberiaPoderRegistrarlo() {
		
		qt().forAll(integers().between(0, 1000)).check(id->{
			try {
				lab.insertarEquipoSinLaboratorio(id, null,null, new Date(01,02,2017));
				System.out.println("Salio");
				Equipo eq = lab.getEquipo(id);
				return eq.getId()==id;
			}catch(ECILabException e) {
				return lab.getEquipo(id)!=null;
			}
		});
	}
	@Test
	public void deberiaRegistrarUnElementoSiNoExiste() {
		qt().forAll(integers().between(0, 1000)).check(id->{
			try {
				lab.AgregarElemento(id,"TORRE","LENOVO","IDEA PAD",new Date(19,02,2015),null,null);
			}catch(ECILabException e) {
				
			}
			System.out.println(lab.getElemento(id).getId()==id);
			return lab.getElemento(id).getId()==id;
		});
		}
	@Test
	public void deberiaRegistrarUnElementoSiSuTipoEsCorrecto() {
		qt().forAll(integers().between(0, 100),integers().between(0, 100)).check((num,id)->{
			String[] arr = new String[] {"TORRE","PANTALLA","TECLADO","MOUSE","XXXXX","YYYYYY","ZZZZZZZ","WWWWWWW","KKKKKK","TORREX"};
			String t = arr[num%10];
			try {
				lab.AgregarElemento(id,t,"LENOVO","IDEA PAD",new Date(19,02,2015),null,null);
			}catch(ECILabException e) {
				if(e.getMessage().equals("Categoria Erronea")) return !(t.equals("TORRE") || t.equals("PANTALLA") || t.equals("TECLADO") || t.equals("MOUSE"));
			}
			return lab.getElemento(id)!=null;
		});
	}
	@Test
	public void deberiaAsociarUnElementoAUnEquipo() {
		qt().forAll(integers().allPositive(),integers().allPositive()).check(
				(idEle,idEq) -> {
			try {
				lab.AgregarElemento(idEle,"TORRE","LENOVO","IDEA PAD",new Date(19,02,2015),null,null);
			}catch(Exception e) {
				
			}
			try {
				lab.insertarEquipoSinLaboratorio(idEq, null,null, new Date(01,02,2017));
			}catch(Exception e) {
				
			}
			try {
				lab.asociarElemento(idEle, idEq);
			} catch (ECILabException e1) {
				
			}
			Equipo equipo = lab.getEquipo(idEq);
			for(Elemento e:equipo.getElementos()) {
				if(e.getId()==idEle) return true;
			}
			return false;
			
		});
	}
	@Test
	public void deberiaRegistrarNovedad() {
		try {
			lab.registrarUsuario(15, "juan", "pal", "juan@mail.escuelaing.edu.co", "admin", "kl");
		}catch(Exception e) {
			
		}
		try {
			lab.AgregarElemento(-1, "TORRE", "LENOVO", "IDEA", new Date(01, 02, 2019),null,null);
		}catch(Exception e) {
			
		}
		try {
			lab.insertarEquipoSinLaboratorio(-1, new Date(2, 3, 2019),null,null);
		}catch(Exception e) {
			
		}
		qt().forAll(strings().allPossible().ofLength(50)).check(novedad->{
			try {
				lab.AgregarNovedad(novedad, novedad, -1, -1, 15);
			} catch (ECILabException e) {
				return false;
			}
			return true;
		});
		
	}
}
