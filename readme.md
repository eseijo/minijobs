# Mini jobs API

## Database

### Docker Setup

First, start the database container:

```bash
docker compose up
```

### Database Management Commands

The following commands are available to manage the database:

```bash
# Reset the database (drops everything and recreates from scratch)
make db-reset

# Apply the database schema only
make db-schema

# Load seed data into the database
make db-seed
```
