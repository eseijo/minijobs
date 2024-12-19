#!/bin/bash

# Colors for output
GREEN='\033[0;32m'
RED='\033[0;31m'
NC='\033[0m' # No Color

# Function to check if postgres is ready
wait_for_postgres() {
    echo "Waiting for PostgreSQL to start..."
    until docker compose exec postgres pg_isready -U myuser -d mydb
    do
        echo "Waiting..."
        sleep 2
    done
    echo -e "${GREEN}PostgreSQL is ready!${NC}"
}

# Command handler
case "$1" in
    "reset")
        echo "Resetting database..."
        docker compose down -v
        docker compose up -d
        wait_for_postgres
        ;;
    "schema")
        echo "Running schema..."
        docker compose exec postgres psql -U myuser -d mydb -f /sql/01-schema.sql
        ;;
    "seed")
        echo "Seeding data..."
        docker compose exec postgres psql -U myuser -d mydb -f /sql/02-seed-data.sql
        ;;
    *)
        echo -e "${RED}Usage: $0 {reset|schema|seed}${NC}"
        echo "Commands:"
        echo "  reset  - Recreate the database from scratch"
        echo "  schema - Run only the schema script"
        echo "  seed   - Run only the seed data script"
        exit 1
        ;;
esac 