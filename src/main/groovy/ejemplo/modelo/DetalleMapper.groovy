package ejemplo.modelo

import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

class DetalleMapper implements RowMapper<Detalle> {

	Detalle mapRow(ResultSet rs, int rowNum) {
		return new Detalle(clave:rs.getInt(1), detalle:rs.getString(2), cantidad:rs.getInt(3),
			precio:rs.getBigDecimal(4))
	}

}
