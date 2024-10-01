INSERT INTO customer (dni, id, firstname, lastname, email) values
('47597655', '29', 'Juan', 'Sevallos', 'jsevallos@gmail.com'),
('38243678', '54', 'Vincent', 'Roy', 'rvincent@icloud.ca'),
('48194542', '65', 'Jack', 'Cole', 'j.cole@hotmail.ca'),
('61785376', '56', 'Eliana', 'Gonzales', 'e_gonzales@google.org'),
('29690668', '57', 'Grady', 'Avery', 'g-avery8812@google.edu'),
('22694889', '35', 'Fleur', 'Roberts', 'rfleur@outlook.couk'),
('45991734', '58', 'Jameson', 'Owen', 'j-owen@icloud.edu'),
('45873875', '53', 'Kylie', 'Hahn', 'h.kylie4110@aol.edu'),
('29586275', '24', 'Demetria', 'Delacruz', 'delacruz_demetria@icloud.edu'),
('77833354', '02', 'Zelenia', 'Erickson','erickson-zelenia2406@google.net'),
('49819485', '03', 'Zelda', 'Mckee', 'mckee_zelda9047@google.ca');

INSERT INTO account (account_type, balance, status, customer_id, id, account_number) values
('AHORROS', 0, TRUE, 'db30d8ed-2f4b-4911-916c-e3e5c9ab39ee', '1', '821 3263063359'),
('CORRIENTE', 0, TRUE, 'b24a4d1e-43c6-4a92-8ebb-3fdb92cf764f', '2', '314 4263045357'),
('AHORROS', 0, TRUE, '93504984-a74b-4d7f-befa-26c3efa5e7d7', '3', '738 3263063356'),
('CORRIENTE', 0, FALSE, 'c6a06136-9b14-4443-afc1-6152472513b3', '4', '434 4263045354'),
('AHORROS', 0, TRUE, '4bfecb34-52a7-49f0-a470-cde5f54360ec', '5', '754 3263063349');