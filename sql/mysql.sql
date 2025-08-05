DROP DATABASE IF EXISTS furn_ssm;
CREATE DATABASE furn_ssm;
USE furn_ssm;
CREATE TABLE furn(
`id` INT(11) PRIMARY KEY AUTO_INCREMENT, ##id自增长
`name` VARCHAR(64) NOT NULL, ##家具名字
`maker` VARCHAR(64) NOT NULL, ##厂商名字
`price` DECIMAL(11,2) NOT NULL, ##价格
`sales` INT(11) NOT NULL, ##销量
`stock` INT(11) NOT NULL, ##库存
`img_path` VARCHAR(256) NOT NULl ##照片路径
);