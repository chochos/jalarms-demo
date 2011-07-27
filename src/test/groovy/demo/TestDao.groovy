package ejemplo

import javax.annotation.Resource
import ejemplo.db.ConfigurarDB
import org.junit.*
import org.junit.runner.RunWith
import org.springframework.jdbc.core.simple.*
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(['/test.xml'])
class TestDao {

	@Resource EjemploDAO dao
	@Resource ConfigurarDB db

	@Before
	void insertarAdicionales() {
		db.runScript('/test_dara.sql')
	}

	@Test
	void testDao() {
		assert dao.getMaestro(1)
	}

}
