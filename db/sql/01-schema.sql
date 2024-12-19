CREATE TABLE
    users (
        id SERIAL PRIMARY KEY,
        email VARCHAR(255) UNIQUE NOT NULL,
        token VARCHAR(255) NOT NULL,
        created_at TIMESTAMP
        WITH
            TIME ZONE DEFAULT CURRENT_TIMESTAMP
    );

CREATE TABLE
    invoices (
        id SERIAL PRIMARY KEY,
        user_id INTEGER REFERENCES users (id),
        credits INTEGER NOT NULL,
        created_at TIMESTAMP
        WITH
            TIME ZONE DEFAULT CURRENT_TIMESTAMP
    );

CREATE TABLE
    companies (
        id SERIAL PRIMARY KEY,
        name VARCHAR(255) NOT NULL,
        domain VARCHAR(255) NOT NULL,
        country_code VARCHAR(2) NOT NULL,
        created_at TIMESTAMP
        WITH
            TIME ZONE DEFAULT CURRENT_TIMESTAMP
    );

CREATE TABLE
    jobs (
        id SERIAL PRIMARY KEY,
        posted_at TIMESTAMP,
        title VARCHAR(255) NOT NULL,
        description TEXT NOT NULL,
        country_code VARCHAR(2) NOT NULL,
        company_id INTEGER REFERENCES companies (id),
        discovered_at TIMESTAMP
        WITH
            TIME ZONE DEFAULT CURRENT_TIMESTAMP
    );