-- Dane startowe aplikacji. Tabele tworzy Hibernate z encji, a ten plik Spring Boot uruchamia zaraz potem.
-- LAB 01: dopiszcie tu konta wszystkich osób z zespołu (reguła R1.03).
-- LAB 02: dopiszcie dane do swoich tabel (kolejność: najpierw tabele, na które wskazują klucze obce).
-- LAB 03: kolejność sekcji: user_account → location → employee → equipment → loan → loan_item
--
-- Numery kont: 1 Ola, 2 Kuba, 3 Firma, 4 Admin (demo) · 5 Mikołaj, 6 Kacper, 7 Kordian (zespół)
--              8 Jan, 9 Marta, 10 Tomasz (pracownicy firmy, LAB 03)
insert into user_account (email, display_name, role, created_at) values
    ('ola@student.merito.pl',   'Ola',   'USER',    current_timestamp),
    ('kuba@student.merito.pl',  'Kuba',  'USER',    current_timestamp),
    ('firma@example.com',       'Firma', 'PARTNER', current_timestamp),
    ('admin@example.com',       'Admin', 'ADMIN',   current_timestamp),
    ('mikolaj.turek@student.merito.pl',       'Mikolaj', 'USER',   current_timestamp),
    ('kacper.nicpon@student.merito.pl',       'Kacper', 'USER',   current_timestamp),
    ('kordian.kowacz@student.merito.pl',       'Kordian', 'USER',   current_timestamp),
    ('jan.kaminski@itlend.pl',      'Jan',    'USER', current_timestamp),
    ('marta.lewandowska@itlend.pl', 'Marta',  'USER', current_timestamp),
    ('tomasz.zielinski@itlend.pl',  'Tomasz', 'USER', current_timestamp);



-- ===== LAB 02 · location =====                 (1 Wrocław, 2 Warszawa, 3 Kraków, 4 Gdańsk)
insert into location (name, city, street, postal_code, phone, employee_count) values
    ('Oddział Wrocław',  'Wrocław',  'ul. Legnicka 48',     '54-202', '+48 21 37 420 66', 45),
    ('Oddział Warszawa', 'Warszawa', 'ul. Marszałkowska 10', '00-590', '+48 21 37 420 67', 80),
    ('Oddział Kraków',   'Kraków',   'ul. Dietla 25',       '31-070', '+48 21 37 420 68', 30),
    ('Oddział Gdańsk',   'Gdańsk',   'ul. Kręta 5',         '80-827', '+48 21 37 420 69', 22);

-- ===== LAB 03 · employee =====                 (location_id → location, user_account_id → user_account, 1:1)
insert into employee (first_name, last_name, email, job_title, location_id, user_account_id) values
    ('Jan',    'Kamiński',      'jan.kaminski@itlend.pl',      'Handlowiec',        1, 8),
    ('Marta',  'Lewandowska',   'marta.lewandowska@itlend.pl', 'Key Account Manager', 2, 9),
    ('Tomasz', 'Zieliński',     'tomasz.zielinski@itlend.pl',  'Programista',       3, 10),
    ('Ewa',    'Nowak',         'ewa.nowak@itlend.pl',         'Księgowa',          4, null);

-- ===== LAB 02 · equipment =====                (location_id → oddział macierzysty)
insert into equipment (name, serial_number, category, purchase_date, purchase_price, status, location_id) values
    ('Dell Latitude 5440',     'DL-2024-0017', 'LAPTOP',    '2024-03-12', 4200.00, 'LOANED',     1),
    ('Projektor Epson EB-X49', 'EP-2023-0004', 'PROJECTOR', '2023-09-01', 2300.00, 'AVAILABLE',  2),
    ('Monitor LG 27UP650',     'LG-2024-0102', 'MONITOR',   '2024-06-20', 1350.00, 'IN_SERVICE', 3),
    ('Lenovo ThinkPad T14',    'LN-2025-0031', 'LAPTOP',    '2025-02-03', 4800.00, 'LOANED',     3);

-- ===== LAB 02 · loan =====                     (employee_id → employee)
insert into loan (employee_id, purpose, status, returned_at, start_date, end_date) values
    (1, 'Szkolenie wyjazdowe',     'ACTIVE',   null,         '2026-10-20', '2026-10-27'),
    (2, 'Prezentacja dla klienta', 'RETURNED', '2026-10-10', '2026-10-08', '2026-10-10'),
    (3, 'Praca zdalna',            'OVERDUE',  null,         '2026-09-15', '2026-10-15');

-- ===== LAB 03 · loan_item =====                (wiele-do-wielu: loan_id → loan, equipment_id → equipment)
insert into loan_item (loan_id, equipment_id, condition_on_issue, condition_on_return) values
    (1, 1, 'GOOD', null),      -- Jan: laptop Dell, jeszcze nie zwrócony
    (2, 2, 'GOOD', 'GOOD'),    -- Marta: projektor, zwrócony
    (2, 1, 'GOOD', 'WORN'),    -- Marta: ten sam laptop Dell wcześniej, zwrócony z rysami
    (3, 4, 'WORN', null);      -- Tomasz: ThinkPad, przeterminowany
