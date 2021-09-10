CREATE TABLE libro (
    idLibro int(10) NOT NULL AUTO_INCREMENT,
    idAutor int(10) NOT NULL,
    isbn int(10) NOT NULL,
    titulo varchar(100)  NOT NULL,
    FOREIGN KEY (isbn) REFERENCES edicion (isbn),
    FOREIGN KEY (idAutor) REFERENCES autor (idAutor),
    PRIMARY KEY (idLibro)
);
