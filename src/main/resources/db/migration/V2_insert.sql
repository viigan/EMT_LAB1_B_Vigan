INSERT INTO hosts(created_at, updated_at, name, surname, country_id)
VALUES
    (now(), now(),'Finki', 'Finkovski', (SELECT id FROM countries WHERE name='Macedonia')),
    (now(), now(), 'Petko', 'Petkovski', (SELECT id FROM countries WHERE name='United States of America')),
    (now(), now(), 'John', 'Finki', (SELECT id FROM countries WHERE name='United Kingdom')),
    (now(), now(), 'Programerko', 'Programerkovski', (SELECT id FROM countries WHERE name='Australia')),
    (now(), now(), 'Jay', 'Quellin', (SELECT id FROM countries WHERE name='Argentina')),
    (now(), now(), 'Dee', 'Nice', (SELECT id FROM countries WHERE name='Japan')),
    (now(), now(), 'A. A.', 'Ron', (SELECT id FROM countries WHERE name='Germany')),
    (now(), now(), 'Tim O.', 'Thee', (SELECT id FROM countries WHERE name='Canada'));
