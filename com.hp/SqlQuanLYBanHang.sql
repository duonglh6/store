create database dbdongho char set utf8 collate utf8_general_ci
use dbdongho;
create table CHUCVU(
 machucvu integer not null auto_increment,
 tenchucvu nvarchar(30),
 primary key (machucvu)
);
create table NHANVIEN(
 manhanvien integer not null auto_increment,
 hoten nvarchar(30),
 diachi nvarchar(100),
 gioitinh tinyint,
 cmnd char(14),
 email nvarchar(50),
 tendangnhap varchar(50) not null,
 matkhau varchar(50) not null,
 machucvu integer not null,
 primary key (manhanvien),
 constraint fk_nhanvien_chucvu foreign key(machucvu)
 references CHUCVU(machucvu)
);
create table DANHMUCSANPHAM(
  madanhmuc integer not null auto_increment,
  tendanhmuc nvarchar(50),
  hinhanhdanhmuc text,
  primary key (madanhmuc)
);



create table SANPHAM(
 masanpham integer not null auto_increment,
 tensanpham nvarchar(100),
 giatien varchar(50),
 mota text,
 hinhanhsanpham text,
 madanhmuc integer,
 primary key(masanpham),
 constraint fk_sanpham_danhmuc foreign key(madanhmuc) references DANHMUCSANPHAM(madanhmuc)
 
);
create table MAUSANPHAM(
  mamau integer auto_increment,
  tenmau nvarchar(50),
  primary key(mamau)
);
create table SIZESANPHAM(
  masize integer auto_increment,
  size nvarchar(20),
  primary key(masize)
);
create table CHITIETSANPHAM(
machitietsanpham integer auto_increment,
masanpham integer,
masize integer,
mamau integer,
soluong integer,
ngaynhap timestamp,
primary key(machitietsanpham),
constraint fk_chitiet_sanpham foreign key(masanpham) references SANPHAM(masanpham),
constraint fk_chitiet_size foreign key(masize) references SIZESANPHAM(masize),
constraint fk_chitiet_mau foreign key(mamau) references MAUSANPHAM(mamau)
);
create table KHUYENMAI(
   makhuyenmain integer auto_increment,
   tenkhuyenmai nvarchar(200),
   thoigianbatdau datetime,
   thoigianketthuc datetime,
   mota text,
   hinhthuckhuyenmai text,
   primary key(makhuyenmain)
   
);
create table CHITIETKHUYENMAI(
   machitietkhuyenmai integer auto_increment,
   makhuyenmai integer,
   masanpham integer,
   giamgia integer,
   primary key(machitietkhuyenmai),
   constraint fk_chitietkhuyenmain_sanpham foreign key(masanpham) references SANPHAM(masanpham),
   constraint fk_chitietkhuyenmai_khuyenmai foreign key(makhuyenmai) references KHUYENMAI(makhuyenmain)
);
create table HOADON(
  mahoadon integer auto_increment,
  manhanvien integer,
  sodt char(12),
  diachigiaohang nvarchar(200),
  tinhtrang tinyint,
  ngaygiao datetime,
  primary key(mahoadon),
  constraint fk_hoadon_nhanvien foreign key(manhanvien) references NHANVIEN(manhanvien)
);
create table BINHLUAN(
  mabinhluan integer auto_increment,
  noidungbinhluan text,
  masanpham integer,
  manhanvien integer,
  primary key (mabinhluan),
  constraint fk_binhluan_nhanvien foreign key(manhanvien) references NHANVIEN(manhanvien),
  constraint fk_binhluan_sanpham foreign key(masanpham) references SANPHAM(masanpham)
  
);
create table CHITIETHOADON(
  machitiethoadon integer auto_increment,
  mahoadon integer ,
  machitietsanpham integer,
  soluong integer,
  giatien varchar(100),
  primary key (machitiethoadon),
    constraint fk_chitiethoadon_hoadon foreign key(mahoadon) references HOADON(mahoadon),
  constraint fk_chitiethoadon_chitietsanpham foreign key(machitietsanpham) references CHITIETSANPHAM(machitietsanpham)
)