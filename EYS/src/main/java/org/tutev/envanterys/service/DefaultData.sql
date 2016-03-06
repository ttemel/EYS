/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Hoca
 * Created: 27.Şub.2016
 */



insert into auth_kullanici  (id,username,pass) values (1,'test','1');

--select 'insert into auth_rol (rol_id,kod,tanim ) values ( '|| rol_id ||', '''||kod||''','''||tanim||''' ); ' from auth_rol
insert into auth_rol (rol_id,kod,tanim ) values ( 1, 'STKYON','Stok Yöneticisi' ); 
insert into auth_rol (rol_id,kod,tanim ) values ( 2, 'ENVYON','Envanter Yöneticisi' ); 
insert into auth_rol (rol_id,kod,tanim ) values ( 3, 'ADM','Admin Rolü' ); 

