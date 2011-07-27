package demo

import javax.annotation.*
import org.junit.*
import org.junit.runner.RunWith
import org.springframework.jdbc.core.simple.*
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(['/test.xml'])
class Prueba {
	@Resource SimpleJdbcTemplate jdbc

	@Test
	void leerMaestro() {
		assert 1 == jdbc.queryForInt("SELECT count(*) FROM maestro")
	}

	@Test
	void leerDetalle() {
		assert 3 == jdbc.queryForInt("SELECT count(*) FROM detalle")
	}

}
