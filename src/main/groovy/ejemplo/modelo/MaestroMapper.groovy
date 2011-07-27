package ejemplo.modelo

import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

class MaestroMapper implements RowMapper<Maestro> {

	Maestro mapRow(ResultSet rs, int rowNum) {
		return new Maestro(clave:rs.getInt(1), nombre:rs.getString(2), fecha:rs.getTimestamp(3),
			status:rs.getInt(4))
	}

}
