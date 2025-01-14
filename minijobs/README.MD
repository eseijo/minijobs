# Minijobs API REST
Implementación del API REST de Jobs hecha en Java con Spring y usando una arquitectura hexagonal.

## Instrucciones de ejecución
1. Compilación
```bash
./mvnw clean install
```
2. Ejecución
```bash
./mvnw spring-boot:run
```
3. Se pueden realizar pruebas a través de la interfaz Swagger-UI accediendo al enlace `http://localhost:8080/swagger-ui/index.html`. 
Adjunto también un ejemplo en curl:
```bash
curl -X 'POST' \
  'http://localhost:8080/api/jobs/find' \
  -H 'accept: */*' \
  -H 'api-key: abc123token' \
  -H 'Content-Type: application/json' \
  -d '{
  "jobCountryCode": "ES",
  "jobTitle": "QA",
  "pageNumber": 0,
  "pageSize": 3
}'
```

## Trabajo pendiente y aspectos a mejorar
Por falta de tiempo, ha quedado trabajo sin resolver y que completaría la prueba:

1. Tests

Faltaría testear el desarrollo, añadiendo tests unitarios en las diferentes capas y, al menos, tests de integración para probar el controller.

2. Transaccionalidad

Revisar la transaccionalidad e implementarla de tal manera que sea eficiente para un entorno en el que se requiera un throughput alto.

3. Acceso a datos

La consulta a base de datos de los jobs podría refactorizarse para hacerla más mantenible y para facilitar la inclusión de nuevos parámetros de filtrado.

También sería mejorable el código que gestiona el uso de créditos. Se podría hacer más mantenible, eficiente en el acceso a base de datos e incluir lógica para gastar los créditos de determinada manera, en vez de usar las facturas dependiendo del orden en que se recuperen de la base de datos.

4. Documentación

Sería interesante añadir anotaciones en el `JobsController` para documentar, mediante openapi, el endpoint implementado y que la información pudiese ser consultada desde Swagger.
