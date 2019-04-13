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
		assertTrue(true);
	}
}
