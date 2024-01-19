-- Generated with GPT-3.5

INSERT INTO task (title, category, task_condition)
VALUES ('Вычисление факториала',
        'ML',
        'Напишите программу для вычисления факториала заданного числа. На вход подается натуральное число, на выходе необходимо получить его факториал.'),

       ('Поиск минимума в массиве',
        NULL,
        'Реализуйте алгоритм поиска минимального элемента в массиве целых чисел. Ваша программа должна находить и выводить наименьший элемент массива.'),

       ('Сортировка массива',
        'DESIGN',
        'Напишите функцию для сортировки массива целых чисел методом быстрой сортировки (quicksort). Входные данные - массив, выходные данные - отсортированный массив.'),

       ('Симулятор банковской системы',
        'HIGHLOAD',
        'Разработайте класс, моделирующий базовую банковскую систему. В классе должны быть реализованы основные операции: открытие счета, внесение и снятие денег, запрос баланса.'),

       ('Проверка палиндрома',
        NULL,
        'Напишите функцию, которая проверяет, является ли заданная строка палиндромом. Палиндром - это строка, читаемая одинаково слева направо и справа налево.'),

       ('Поиск элемента в бинарном дереве',
        'EXTREME',
        'Реализуйте программу для работы с бинарным деревом поиска. Программа должна включать возможности добавления элемента, удаления элемента и поиска элемента в дереве.'),

       ('Вычисление последовательности Фибоначчи',
        'EXTREME',
        'Напишите функцию для вычисления n-го числа в последовательности Фибоначчи. Функция должна принимать на вход номер числа и возвращать его значение в последовательности.');

INSERT INTO tournament(title, text, category,  start_date, finish_date)
VALUES ('Олимпиада по информатике', 'Описание олимпиады по информатике', 'ML','2024-08-15','2024-08-15'),
       ('Чемпионат по программированию','Описание чемпионата по программированию', 'EXTREME','2024-11-21','2024-11-21'),
       ('Турнир "Кодеры будущего"', 'Описание Турнир "Кодеры будущего"', 'EXTREME', '2024-09-10', '2024-09-10'),
       ('Открытый кубок по алгоритмике', 'Описание открытый кубок по алгоритмике','DESIGN', '2024-10-05','2024-10-05'),
       ('Чемпионат мира по разработке ПО','Описание чемпионат мира по разработке ПО','HIGHLOAD' , '2024-12-02', '2024-10-05'),
       ('Технокубок 2023-2024','Ежегодная олимпиада по программированию для учащихся 8 –11 классов, организаторами которой являются компания VK, МФТИ и МГТУ им. Н.Э. Баумана. Победители и призеры олимпиады могут поступить в вуз без экзаменов или получить 100 баллов за ЕГЭ по информатике, привилегии при поступлении в образовательные проекты VK и подарки от партнеров.',
       NULL , '2024-12-02', '2024-10-05');

INSERT INTO test (task_id, input, output)
VALUES (1, '5', '120'),
       (1, '0', '1'),
       (1, '10', '3628800'),
       (2, '[5, 8, 3, 1, 9, 6]', '1'),
       (2, '[100, 200, 150, 175, 120]', '100'),
       (2, '[0, 0, 0, 0, 0]', '0'),
       (3, '[3, 7, 2, 1, 8, 5, 9, 4, 6]', '[1, 2, 3, 4, 5, 6, 7, 8, 9]'),
       (3, '[9, 8, 7, 6, 5, 4, 3, 2, 1]', '[1, 2, 3, 4, 5, 6, 7, 8, 9]'),
       (3, '[1, 2, 3, 4, 5]', '[1, 2, 3, 4, 5]'),
       (4, 'открытие счета с начальным балансом 1000', 'успешное создание счета с балансом 1000'),
       (4, 'внесение 500 на счет', 'баланс становится 1500'),
       (4, 'снятие со счета 300', 'баланс становится 1200'),
       (5, '"radar"', 'true'),
       (5, '"hello"', 'false'),
       (5, '"A man a plan a canal Panama"', 'true'),
       (6, 'добавление элементов {5, 3, 7, 2, 4, 6, 8} и поиск элемента 4', 'успешный поиск элемента 4'),
       (6, 'добавление элементов {50, 30, 70, 20, 40, 60, 80} и поиск элемента 55', 'элемент 55 не найден'),
       (6, 'добавление элементов {10, 5, 15, 3, 7, 12, 20} и поиск элемента 10', 'успешный поиск элемента 10'),
       (7, '6', '8'),
       (7, '1', '1'),
       (7, '12', '144');


INSERT INTO "user" (username, email, password, role)
VALUES
    ('admin', 'unknown', '$2a$12$PYxBhzAOwlq3RxYbpHCw9OEMoMwPTX7lm3EWQaQRNqVqwgSSCiHsy', 'ROLE_ADMIN'),
    ('tutor', 'unknown', '$2a$12$tr.yF5fvuCGncFTwnjvmgeKLUjX978IKr5JGQUIBnktmMprJYK30.', 'ROLE_TUTOR'),
    ('member', 'unknown', '$2a$12$DAPCqyFSbuguh50Ex4siPeZ73Pdxc.hLMs.ZC0Jy1tZ3uKYP4Q0nK', 'ROLE_MEMBER')