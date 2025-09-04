CREATE DATABASE db_shopapp;
USE db_shopapp;

CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    fullName VARCHAR(100) DEFAULT '',
    phone_number VARCHAR(10) NOT NULL,
    address VARCHAR(200) DEFAULT '',
    password VARCHAR(100) NOT NULL DEFAULT '', -- mật khẩu đã mã hóa
    created_at DATETIME,
    updated_at DATETIME,
    is_active TINYINT(1) DEFAULT 1,
    date_of_birth DATE,
    facebook_account_id INT DEFAULT 0,
    google_account_id INT DEFAULT 0
);

ALTER TABLE users ADD COLUMN role_id INT;

CREATE TABLE roles (
	id INT PRIMARY KEY,
    name VARCHAR(20) NOT NULL
);

ALTER TABLE users ADD FOREIGN KEY (role_id) REFERENCES roles(id);

CREATE TABLE tokens (
	id INT PRIMARY KEY AUTO_INCREMENT,
    token VARCHAR(255) UNIQUE NOT NULL,
    token_type VARCHAR(50) NOT NULL,
    expiration_date DATETIME,
    revoked TINYINT(1) NOT NULL,
    expired TINYINT(1) NOT NULL,
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE social_accounts (
	id INT PRIMARY KEY AUTO_INCREMENT,
    provider VARCHAR(20) NOT NULL COMMENT 'Tên nhà social network',
    provider_id VARCHAR(50) NOT NULL,
    email VARCHAR(150) NOT NULL COMMENT 'Email tài khoản',
    name VARCHAR(100) NOT NULL COMMENT 'Tên người dùng',
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Danh mục sản phẩm
CREATE TABLE categories (
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(100) NOT NULL DEFAULT '' COMMENT 'Tên danh mục, vd: đồ điện tử'
);

-- Bảng chứa sản phẩm
CREATE TABLE products (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(350) COMMENT 'Tên sản phẩm',
    price FLOAT NOT NULL CHECK (price >= 0),
    thumbnail VARCHAR(300) DEFAULT '',
    description LONGTEXT,
    created_at DATETIME,
    updated_at DATETIME,
    category_id INT,
    FOREIGN KEY (category_id) REFERENCES categories(id)
);

CREATE TABLE product_image (
    id INT PRIMARY KEY AUTO_INCREMENT,
    product_id INT,
    FOREIGN KEY (product_id) REFERENCES products(id),
    -- Nếu xóa products => product_image sẽ bị xóa theo
    CONSTRAINT fk_product_images_product_id FOREIGN KEY (product_id) REFERENCES products(id) ON DELETE CASCADE,
    image_url VARCHAR(300)
);

-- Đặt hàng - orders
CREATE TABLE orders (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES users(id),
	fullName VARCHAR(100) DEFAULT '',
    email VARCHAR(100) DEFAULT '',
    phone_number VARCHAR(20) NOT NULL,
    address VARCHAR(200) NOT NULL, -- địa chỉ nơi gửi
    note  VARCHAR(100) DEFAULT '',
    order_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(20),
    total_money FLOAT CHECK(total_money >= 0)
);

ALTER TABLE orders ADD COLUMN shipping_method VARCHAR(100); -- phương thức vận chuyển
ALTER TABLE orders ADD COLUMN shipping_address VARCHAR(100); -- địa chỉ ship đến
ALTER TABLE orders ADD COLUMN shipping_date VARCHAR(100); -- ngày nào gửi đến
ALTER TABLE orders ADD COLUMN tracking_number VARCHAR(100); -- số vận đơn
ALTER TABLE orders ADD COLUMN payment_method VARCHAR(100); -- phương thức thanh toán
ALTER TABLE orders ADD COLUMN active TINYINT(1); -- xóa 1 đơn hàng => xóa mềm
-- trạng thái đơn hàng chỉ dc phép nhận "1 số giá trị cụ thể"
ALTER TABLE orders
MODIFY COLUMN status ENUM('pending', 'processing', 'shipped', 'delivered', 'cancelled')
COMMENT 'Trạng thái đơn hàng';

CREATE TABLE order_detail (
    id INT PRIMARY KEY AUTO_INCREMENT,
	order_id INT,
    FOREIGN KEY (order_id) REFERENCES orders(id),
    product_id INT,
    FOREIGN KEY (product_id) REFERENCES products(id),
    price FLOAT CHECK (price >= 0),
    number_of_products INT CHECK (number_of_products > 0),
    total_money INT CHECK (total_money >= 0),
    color VARCHAR(20) DEFAULT ''
);

ALTER TABLE product_image RENAME TO product_images;
ALTER TABLE order_detail RENAME TO order_details;

-- SET SQL_SAFE_UPDATES = 0;
-- delete from db_shopapp.products

-- alter table products auto_increment = 1;

-- INSERT INTO users(fullname, phone_number, address, date_of_birth, password)
-- VALUES('Nguyen Van A', '0964896239', 'address 123', '1993-12-22', 'hashedddd paasssss');




