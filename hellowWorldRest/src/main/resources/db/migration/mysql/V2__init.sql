
CREATE TABLE IF NOT EXISTS `registro` (
  
`id` int(11) NOT NULL AUTO_INCREMENT,
  
`nome` varchar(200) NOT NULL,
  
`telefone` varchar(30) DEFAULT NULL,
  
`email` varchar(100) DEFAULT NULL,

`dataCriacao` date DEFAULT NULL,
  
`dataAtualizacao` date DEFAULT NULL,
PRIMARY KEY (`id`)
) 
ENGINE=MyISAM DEFAULT CHARSET=utf8;

