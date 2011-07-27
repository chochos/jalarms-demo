package ejemplo

import javax.annotation.Resource
import ejemplo.modelo.*
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate

class EjemploDAO {

	@Resource SimpleJdbcTemplate jdbc

	Maestro getMaestro(int clave) {
		Maestro m = jdbc.queryForObject("SELECT clave,nombre,fecha,status FROM maestro WHERE clave=?",
			new MaestroMapper(), clave)
		List<Detalle> dets = jdbc.query("SELECT clave,detalle,cantidad,precio FROM detalle WHERE master=?",
			new DetalleMapper(), clave)
		m.detalles = dets
		m
	}

}

