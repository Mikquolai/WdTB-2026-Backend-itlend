-- Dane startowe aplikacji. Tabele tworzy Hibernate z encji, a ten plik Spring Boot uruchamia zaraz potem.
-- LAB 01: dopiszcie tu konta wszystkich osób z zespołu (reguła R1.03).
-- LAB 02: dopiszcie dane do swoich tabel (kolejność: najpierw tabele, na które wskazują klucze obce).
insert into user_account (email, display_name, role, created_at) values
    ('ola@student.merito.pl',   'Ola',   'USER',    current_timestamp),
    ('kuba@student.merito.pl',  'Kuba',  'USER',    current_timestamp),
    ('firma@example.com',       'Firma', 'PARTNER', current_timestamp),
    ('admin@example.com',       'Admin', 'ADMIN',   current_timestamp),
    ('mikolaj.turek@student.merito.pl',       'Mikolaj', 'USER',   current_timestamp),
    ('kacper.nicpon@student.merito.pl',       'Kacper', 'USER',   current_timestamp),
    ('kordian.kowacz@student.merito.pl',       'Kordian', 'USER',   current_timestamp);



-- ===== LAB 02 · location =====
insert into location (name, city, street, postal_code, phone, employee_count) values
    ('Oddział Wrocław',  'Wrocław',  'ul. Legnicka 48',     '54-202', '+48 21 37 420 66', 45),
    ('Oddział Warszawa', 'Warszawa', 'ul. Marszałkowska 10', '00-590', '+48 21 37 420 67', 80),
    ('Oddział Kraków',   'Kraków',   'ul. Dietla 25',       '31-070', '+48 21 37 420 68', 30),
    ('Oddział Gdańsk',   'Gdańsk',   'ul. Długa 5',         '80-827', '+48 21 37 420 69', 22);

-- ===== LAB 02 · equipment =====
insert into equipment (name, serial_number, category, purchase_date, purchase_price, status) values
    ('Dell Latitude 5440',     'DL-2024-0017', 'LAPTOP',    '2024-03-12', 4200.00, 'LOANED'),
    ('Projektor Epson EB-X49', 'EP-2023-0004', 'PROJECTOR', '2023-09-01', 2300.00, 'AVAILABLE'),
    ('Monitor LG 27UP650',     'LG-2024-0102', 'MONITOR',   '2024-06-20', 1350.00, 'IN_SERVICE');

-- ===== LAB 02 · loan =====
insert into loan (borrower_name, purpose, status, returned_at, start_date, end_date) values
    ('Jan Kamiński',      'Szkolenie wyjazdowe',     'ACTIVE',   null,         '2026-10-20', '2026-10-27'),
    ('Marta Lewandowska', 'Prezentacja dla klienta', 'RETURNED', '2026-10-10', '2026-10-08', '2026-10-10'),
    ('Tomasz Zieliński',  'Praca zdalna',            'OVERDUE',  null,         '2026-09-15', '2026-10-15');


-- LAB 01: Wasze konta (zmieńcie na swoje dane, rola USER)
-- insert into user_account (email, display_name, role, created_at) values
--     ('imie.nazwisko@student.merito.pl', 'Imię', 'USER', current_timestamp);
