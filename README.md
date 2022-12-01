** README **

# Customers & Devices
Set di api **REST compliant** che permettano di gestire operazioni CRUD di anagrafica utente e device

# TO CALL EXAMPLE
GET  http://localhost:8080/enrctn/service/be/resources/customers

POST http://localhost:8080/enrctn/service/be/resources/customers
{
		"name": "N",
		"surname": "S",
		"fiscalCode": "CF",
		"andress": "A"
}

# TO START
mvn clean install
mvn spring-boot:run


# TODO
- Ogni utente può avere fino a 2 device associati
- Recuperare i dati aggregati di utente e device
- CONTROLLI VALIDAZIONI REQUEST (BAD REQUEST)
- CONTROLLI LOGICI VARI (ES. PER INSERIMENTO DEVICE)
- JUNIT


