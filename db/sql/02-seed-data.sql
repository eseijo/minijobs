-- Create a user
INSERT INTO
    users (email, token)
VALUES
    ('test@example.com', 'abc123token') RETURNING id;

-- Create 2 invoices for the user
INSERT INTO
    invoices (user_id, credits)
VALUES
    (1, 100),
    (1, 200);

-- Create 10 companies
INSERT INTO
    companies (name, domain, country_code)
VALUES
    ('TechCorp Solutions', 'techcorp.com', 'US'),
    ('Digital Dynamics', 'digitaldynamics.io', 'CA'),
    ('Innovation Labs', 'innovationlabs.co.uk', 'GB'),
    ('Future Systems', 'futuresystems.de', 'DE'),
    ('Cloud Nine Tech', 'cloudnine.fr', 'FR'),
    ('Data Driven Inc', 'datadriven.nl', 'NL'),
    ('Smart Software Co', 'smartsoftware.es', 'ES'),
    ('AI Solutions Ltd', 'aisolutions.it', 'IT'),
    ('Cyber Systems', 'cybersystems.se', 'SE'),
    ('Web Wizards', 'webwizards.no', 'NO');

-- Create 10 jobs (one for each company)
INSERT INTO
    jobs (
        posted_at,
        discovered_at,
        title,
        description,
        country_code,
        company_id
    )
VALUES
    (
        '2024-03-15 10:00:00',
        '2024-03-15 10:30:00',
        'Senior Software Engineer',
        'Looking for an experienced developer with 5+ years in full-stack development...',
        'US',
        1
    ),
    (
        '2024-03-14 09:00:00',
        '2024-03-14 09:45:00',
        'DevOps Engineer',
        'Seeking a DevOps engineer to manage our cloud infrastructure...',
        'CA',
        2
    ),
    (
        '2024-03-13 14:00:00',
        '2024-03-13 14:15:00',
        'Frontend Developer',
        'React specialist needed for our growing team...',
        'GB',
        3
    ),
    (
        '2024-03-12 11:00:00',
        '2024-03-12 11:30:00',
        'Backend Engineer',
        'Python/Django developer needed for our backend team...',
        'DE',
        4
    ),
    (
        '2024-03-11 13:00:00',
        '2024-03-11 13:45:00',
        'Data Scientist',
        'Looking for a data scientist with ML experience...',
        'FR',
        5
    ),
    (
        '2024-03-10 15:00:00',
        '2024-03-10 15:30:00',
        'Product Manager',
        'Technical product manager needed for our AI team...',
        'NL',
        6
    ),
    (
        '2024-03-09 10:00:00',
        '2024-03-09 10:15:00',
        'QA Engineer',
        'Automation testing specialist needed...',
        'ES',
        7
    ),
    (
        '2024-03-08 09:00:00',
        '2024-03-08 09:30:00',
        'Mobile Developer',
        'iOS developer with Swift experience...',
        'IT',
        8
    ),
    (
        '2024-03-07 14:00:00',
        '2024-03-07 14:45:00',
        'Security Engineer',
        'Cybersecurity specialist needed for our security team...',
        'SE',
        9
    ),
    (
        '2024-03-06 11:00:00',
        '2024-03-06 11:15:00',
        'Full Stack Developer',
        'MERN stack developer needed for web applications...',
        'NO',
        10
    );