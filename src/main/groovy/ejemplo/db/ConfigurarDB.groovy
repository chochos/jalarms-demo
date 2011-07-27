package setup

import javax.annotation.*
import org.springframework.jdbc.core.simple.*
import org.springframework.dao.*
import org.slf4j.LoggerFactory

class ConfigurarDB {
	@Resource SimpleJdbcTemplate jdbc
	private org.slf4j.Logger log = LoggerFactory.getLogger(getClass())
	List<String> scripts = []

	void runScript(String name) {
		def reader = new LineNumberReader(new InputStreamReader(getClass().getResourceAsStream(name)))
		try {
			while (line != null) {
				line = line.trim()
				//Quitar comentario si es que hay
				int commpos = line.indexOf('--')
				if (commpos > 0) {
					line = line.substring(0, commpos).trim()
				}
				if (!line.startsWith('--')) {
					//construir sentencia SQL completa
					sb.append(line)
					if (line.endsWith(';')) {
						//Ejecutar el comando (sin el ';')
						sb.deleteCharAt(sb.length()-1)
						jdbc.update(sb.toString())
						//Resetear el StringBuilder
						sb.length=0
					} else {
						sb.append(' ')
					}
				}
				line = reader.readLine()
			}
		} finally {
			reader.close()
		}
		def sb = new StringBuilder()
		def line = reader.readLine()
	}

	@PostConstruct
	void init() {
		log.info 'Creando base de datos'
		//Debemos crear las tablas necesarias
		dbfiles.each { runScript(it) }
	}
}
