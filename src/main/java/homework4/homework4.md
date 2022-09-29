[//]: # (-- Duration_table definition)

CREATE TABLE Duration_table (
id INTEGER,
duration INTEGER NOT NULL,
CONSTRAINT Duration_table_PK PRIMARY KEY (id)
);

[//]: # (-- Films_table definition)

CREATE TABLE Films_table (
id INTEGER,
film_name TEXT(256),
CONSTRAINT Films_table_PK PRIMARY KEY (id)
);

[//]: # (-- Session_time_table definition)

CREATE TABLE Session_time_table (
id INTEGER,
time REAL NOT NULL,
CONSTRAINT Session_time_table_PK PRIMARY KEY (id)
);

[//]: # (-- Ticket_price_table definition)

CREATE TABLE Ticket_price_table (
id INTEGER,
price INTEGER NOT NULL,
CONSTRAINT Ticket_price_table_PK PRIMARY KEY (id)
);

[//]: # (-- Session_table definition)

CREATE TABLE Session_table (
id INTEGER,
film_name INTEGER,
duration INTEGER,
time INTEGER,
price INTEGER,
CONSTRAINT Session_table_PK PRIMARY KEY (id),
CONSTRAINT Session_table_FK FOREIGN KEY (film_name) REFERENCES Films_table(id),
CONSTRAINT Session_table_FK_1 FOREIGN KEY (duration) REFERENCES Duration_table(id),
CONSTRAINT Session_table_FK_2 FOREIGN KEY (price) REFERENCES Ticket_price_table(id),
CONSTRAINT Session_table_FK_3 FOREIGN KEY (time) REFERENCES Session_time_table(id)
);

[//]: # (-- Fact_of_purchase_table definition)

CREATE TABLE Fact_of_purchase_table (
id INTEGER,
"session" INTEGER,
CONSTRAINT Fact_of_purchase_table_PK PRIMARY KEY (id),
CONSTRAINT Fact_of_purchase_table_FK FOREIGN KEY ("session") REFERENCES Session_table(id)
);

[//]: # (Выборка данных)

SELECT
ft.film_name,
stt.time,
dt.duration,
(SELECT COUNT(fopt."session")
FROM Fact_of_purchase_table fopt
WHERE st.id = fopt."session") AS tickets
FROM Session_table st
INNER JOIN Films_table ft ON ft.id = st.film_name
INNER JOIN Session_time_table stt ON stt.id = st.time
INNER JOIN Duration_table dt ON dt.id = st.duration
ORDER BY dt.duration ASC;