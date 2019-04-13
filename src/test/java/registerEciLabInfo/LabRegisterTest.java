package registerEciLabInfo;

import static org.junit.Assert.assertTrue;
import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.Generate.*;
import static org.quicktheories.generators.SourceDSL.*;
import org.junit.Test;
import java.sql.Date;

import com.google.inject.Inject;
import com.registerLab.ECILabException;
import com.registerLab.entities.Equipo;
import com.registerLab.servicios.ServiciosECILabImpl;

public class LabRegisterTest extends TestBase{
	@Inject
	private ServiciosECILabImpl lab;
	@Test
	public void siUnEquipoNoExisteDeberiaPoderRegistrarlo() {
		
		qt().forAll(integers().allPositive()).check(id->{
			try {
				lab.insertarEquipoSinLaboratorio(id, null,null, new Date(01,02,2017));
				System.out.println("Salio");
				Equipo eq = lab.getEquipo(id);
				return eq.getId()==id;
			}catch(ECILabException e) {
				System.out.println("My error "+e.getMessage());
				return lab.getEquipo(id)!=null;
			}
		});
	}
}
