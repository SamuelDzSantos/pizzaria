/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Eduardo e Christian
 * Created: 21/06/2023
 */

"SELECT tb_pedido.id_pedido, nome_cliente, tb_idstatus.nome AS nome_status,"
                     " (SELECT SUM(valor_pedido_item) FROM tb_pedido_pizza WHERE tb_pedido_pizza.id_pedido = tb_pedido.id_pedido) AS total_pedido,"
                     " (SELECT COUNT(id) FROM tb_pedido_pizza WHERE tb_pedido_pizza.id_pedido = tb_pedido.id_pedido) AS qtd_itens"
                     " FROM tb_pedido"
                         " INNER JOIN tb_cliente ON (tb_pedido.id_cliente = tb_cliente.id_cliente)"
                         " INNER JOIN tb_idstatus ON (tb_idstatus.id = tb_pedido.id_status_pedido)"