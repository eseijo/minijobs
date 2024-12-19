# "Mini Jobs API" Test

## Objective

Create a REST API with a single endpoint that enables searching for jobs based on specific filters and supports pagination. The purpose of this test is to assess your backend development skills, API design capabilities, and handling of data.

## Requirements

### Authentication

Authentication is not required for this test. Identify the user in the database using the `api_key` header.

### Filters

The request body must accept at leastthe following filters:

- `job_country_code`: Filter jobs based on the country code.
- `job_title`: Filter jobs based on the job title.
- `company_country_code`: Filter jobs based on the company's country code.

Filters are optional, but when provided, they should refine the results.

### Pagination

It's mandatory to implement any type of pagination mechanism.

### Data Sources

The PostgreSQL database is pre-configured and ready for use. You may modify the schema as needed to better fit your implementation. Detailed instructions on how to start the database, create the schema, and populate the data can be found in the readme file. 

### API Credits

This is a credit-based API. The API must consume credits for each record returned in the response.

- 1 record returned = 1 credit.
- Users can have multiple invoices, each with an assigned package of credits.
- Ensure that users cannot exceed their available credit balance.
- Implement a mechanism to check and deduct credits from the user account for each API call.

### Technology Choice

You can select any programming language, framework or technology.

## Instructions

Fork this repository, implement the requirements and send us by email the link to your repository.

Good luck, and happy coding!
