create database BD_T2_APELLIDO;
use BD_T2_APELLIDO;

-------------------------
create table categoria
(
id_cate int primary key,
descripcion varchar(100),
frecuencia_compra int
);

create table productos (
    id_prod int AUTO_INCREMENT primary key,
    nom_prod varchar(100),
    id_cate int,
    stock_actual int,
    FOREIGN KEY (id_cate) REFERENCES categoria(id_cate)
);

create table inventario (
    nro_inventario int AUTO_INCREMENT primary key,
    fecha date,
    id_prod int,
    costo_ingreso DECIMAL(10,2),
    FOREIGN KEY (id_prod) REFERENCES productos(id_prod)
);

-------------------------
INSERT INTO categoria (id_cate, descripcion, frecuencia_compra) VALUES 
(1, 'Electrónica', 30),
(2, 'Ropa', 15),
(3, 'Alimentos', 7);

INSERT INTO productos (nom_prod, id_cate, stock_actual) VALUES
('Televisor', 1, 50),
('Camiseta', 2, 100),
('Pan', 3, 200);

INSERT INTO inventario (fecha, id_prod, costo_ingreso) VALUES
('2024-10-10', 1, 300.00),
('2024-10-11', 2, 20.00),
('2024-10-12', 3, 1.50);

-------------------------
SELECT * FROM categoria;
SELECT * FROM productos;
SELECT * FROM inventario;