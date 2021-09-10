CREATE TABLE copias (
    idCopias int(10) NOT NULL AUTO_INCREMENT,
    isbn int(10)  NOT NULL,
    rut varchar(100) NOT NULL,
    FOREIGN KEY (isbn) REFERENCES edicion (isbn),
    FOREIGN KEY (rut) REFERENCES usuario (rut),
    PRIMARY KEY (idCopias)
);
