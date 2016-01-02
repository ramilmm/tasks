INSERT INTO POLL(ID, TITLE, DESCRIPTION)
    VALUES (1, 'Удовлетворенность курсом Java', 'Понравились ли вам занятия по Java'),
           (2, 'Удовлетворенность курсом Oracle', 'Понравились ли вам занятия по Oracle');
INSERT INTO POLL_CHOICE(ID, CHOICE_TEXT, VOTES, POLL_ID)
    VALUES (1, 'Да' , 0, 1),
           (2,'Нет', 3, 2);