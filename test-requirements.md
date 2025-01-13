# "Mini Jobs API" Test

## Objective

Create a production-ready REST API with a single endpoint that enables searching for jobs based on specific filters. The purpose of this test is to assess your backend development skills.

## Requirements

### Authentication

Authentication is not required for this test. Identify the user in the database using the `api_key` in the header.

### Filters

The request body must accept at least the following filters:

- `job_country_code`: Filter jobs based on the country code.
- `job_title`: Filter jobs based on the job title.
- `company_country_code`: Filter jobs based on the company's country code.

### Pagination

It's mandatory to implement any type of pagination mechanism.

### API Credits

This is a credit-based API. The API must consume credits for each record returned in the response.

- 1 record returned = 1 credit.
- Users can have multiple invoices, each with an assigned package of credits.
- Ensure that users cannot exceed their available credit balance.
- Implement a mechanism to check and deduct credits from the user account for each API call.

### Performance
- The service should be as efficient as possible to handle millions of jobs.

## Database

The PostgreSQL database is pre-configured and ready for use. You may modify the schema as needed to better fit your implementation or to improve performance. Detailed instructions on how to start the database, create the schema, and populate the data can be found in the readme file. 

## Instructions

Fork this repository, implement the requirements and send us by email the link to your repository.

You can use any programming language, framework or technology to implement the requirements.

If any requirements are not clear enough, make reasonable business decisions to fill in the gaps. Document these decisions in the readme file to provide context for your implementation.

Good luck, and happy coding!