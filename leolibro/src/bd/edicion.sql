CREATE TABLE edicion (
    isbn int(10) NOT NULL,
    annio int(100)  NOT NULL,
    idioma varchar(10)  NOT NULL,
    copias int(10)  NOT NULL,
    PRIMARY KEY (isbn)
);
