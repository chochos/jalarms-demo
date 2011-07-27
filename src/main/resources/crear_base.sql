CREATE TABLE maestro(
  clave  SERIAL PRIMARY KEY,
  nombre VARCHAR(80) NOT NULL,
  fecha  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  status INTEGER NOT NULL DEFAULT 1
);

CREATE TABLE detalle(
  clave    SERIAL PRIMARY KEY,
  master   INTEGER NOT NULL REFERENCES maestro(clave) ON DELETE CASCADE,
  detalle  VARCHAR(80) NOT NULL,
  cantidad INTEGER NOT NULL DEFAULT 1,
  precio   NUMERIC(10,2) NOT NULL DEFAULT 0.00
);