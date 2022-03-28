update alquiler
set cliente = :cliente,
	pelicula = :pelicula,
	fecha_alquiler = :fechaAlquiler,
	fecha_devolucion = :fechaDevolucion,
	valor = :valor
where id = :id