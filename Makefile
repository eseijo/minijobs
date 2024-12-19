.PHONY: db-reset db-schema db-seed

db-reset:
	./db/scripts/db.sh reset

db-schema:
	./db/scripts/db.sh schema

db-seed:
	./db/scripts/db.sh seed