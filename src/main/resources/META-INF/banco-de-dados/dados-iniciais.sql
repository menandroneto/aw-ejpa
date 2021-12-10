insert into produto (id, nome, preco, descricao) values (1, 'Kindle', 499.0, 'Conheça o novo Kindle, agora com iluminação embutida ajustável, que permite que você leia em ambientes abertos ou fechados, a qualquer hora do dia.');
insert into produto (id, nome, preco, descricao) values (3, 'Câmera GoPro Hero 7', 1400.0, 'Desempenho 2x melhor.');

insert into cliente (id, nome) values (1, 'Fernando Medeiros');
insert into cliente (id, nome) values (2, 'Marcos Mariano');

insert into pedido (id, cliente_id, data_pedido, total, status) values (1, 1, sysdate(), 100.0, 'AGUARDANDO');
insert into item_pedido (id, pedido_id, produto_id, preco_produto, quantidade) values (1, 1, 1, 5.0, 2);
insert into item_pedido (id, pedido_id, produto_id, preco_produto, quantidade) values (2, 1, 1, 5.0, 2);
insert into item_pedido (id, pedido_id, produto_id, preco_produto, quantidade) values (3, 1, 1, 5.0, 2);





insert into produto (id, nome, preco, descricao) values (32, 'ADRENALINA 1 ML AMP', 0.62, 'ADRENALINA 1 ML AMP');
insert into produto (id, nome, preco, descricao) values (36, 'ENDOZIME SOLUÇÃO 40ML', 2.5, 'ENDOZIME SOLUÇÃO 40ML');
insert into produto (id, nome, preco, descricao) values (75, 'COLETOR URINA SISTEMA FECHADO 2000ML', 11.34, 'COLETOR URINA SISTEMA FECHADO 2000ML');
insert into produto (id, nome, preco, descricao) values (67, 'FORMOL 40% 100ML', 0.9, 'FORMOL 40% 100ML');
insert into produto (id, nome, preco, descricao) values (398, 'BENZETACIL 1.200.000 UI', 10.01, 'BENZETACIL 1.200.000 UI');
insert into produto (id, nome, preco, descricao) values (812, 'COLTRAX -NAO USAR', 3.07, 'COLTRAX -NAO USAR');
insert into produto (id, nome, preco, descricao) values (33, 'CETAMINA 50 mg/ml - 10 mL FRASCO AMPOLA', 0, 'CETAMINA 50 mg/ml - 10 mL FRASCO AMPOLA');
insert into produto (id, nome, preco, descricao) values (34, 'PROPOFOL 10MG/ML 20ML AMP', 0, 'PROPOFOL 10MG/ML 20ML AMP');
insert into produto (id, nome, preco, descricao) values (65, 'MIDAZOLAM 15MG 3ML AMP', 0, 'MIDAZOLAM 15MG 3ML AMP');
insert into produto (id, nome, preco, descricao) values (377, 'AMPICILINA 250mg / 5 mL SUSPENSÃO ORAL', 0, 'AMPICILINA 250mg / 5 mL SUSPENSÃO ORAL');
insert into produto (id, nome, preco, descricao) values (813, 'COLTRAX Solucao Injetavel', 3.07, 'COLTRAX Solucao Injetavel');
insert into produto (id, nome, preco, descricao) values (885, 'DEXAMETASONA 4MG/ML 2,5ML FR/AM', 7.48, 'DEXAMETASONA 4MG/ML 2,5ML FR/AM');
insert into produto (id, nome, preco, descricao) values (388, 'SONDA URETRAL Nº 24', 0, 'SONDA URETRAL Nº 24');
insert into produto (id, nome, preco, descricao) values (762, 'BENZETACIL 1.200.000 UI - FRASCO-AMPOLA', 0, 'BENZETACIL 1.200.000 UI - FRASCO-AMPOLA');
insert into produto (id, nome, preco, descricao) values (80, 'EFORTIL 0,01 G. 1 CC AMP', 0.39, 'EFORTIL 0,01 G. 1 CC AMP');
insert into produto (id, nome, preco, descricao) values (91, 'FLUMAZENIL 0,1MG/ML 5ML AMP', 0, 'FLUMAZENIL 0,1MG/ML 5ML AMP');
