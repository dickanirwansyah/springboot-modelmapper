CREATE TABLE kategori(

    idkategori serial,
    nama varchar(255) not null,
    deskripsi varchar(255) not null,

    CONSTRAINT pk_kategori_idkategori PRIMARY KEY(idkategori)

);

insert into kategori(nama, deskripsi) values('samsung', 'samsung mobile');
insert into kategori(nama, deskripsi) values('iphone', 'iphone mobile');
insert into kategori(nama, deskripsi) values('Sony', 'sony mobile');
insert into kategori(nama, deskripsi) values('xiaomi', 'xiaomi mobile');

CREATE TABLE product(

    idproduct serial primary key,
    nama varchar(255) not null,
    jumlah int not null,
    price DECIMAL(12,5),
    idkategori int not null,

    CONSTRAINT fk_product_idkategori FOREIGN KEY (idkategori)
    REFERENCES kategori(idkategori)
    match simple on update no action on delete no action

);

insert into product(nama, jumlah, price, idkategori)
values('samsung galaxy note', 5, 10, 1);
