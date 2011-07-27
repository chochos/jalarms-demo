package demo

import javax.annotation.*
import ejemplo.modelo.*
import org.junit.*
import org.junit.runner.RunWith
import org.springframework.jdbc.core.simple.*
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(['/test.xml'])
class TestMappers {

	@Resource SimpleJdbcTemplate jdbc

	@Test
	void testMaestroMapper() {
		Maestro m = jdbc.queryForObject("SELECT clave,nombre,fecha,status FROM maestro where clave=1",
			new MaestroMapper())
	}

}
