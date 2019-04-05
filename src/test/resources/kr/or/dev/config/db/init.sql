-- getProSeq Test (시퀀스 삭제/추가) - PL
DROP SEQUENCE pro_no_seq;
CREATE SEQUENCE pro_no_seq;

-- kind_no_seq - PL
DROP SEQUENCE kind_no_seq;
CREATE SEQUENCE kind_no_seq;

-- box_no_seq - PL
DROP SEQUENCE box_no_seq;
CREATE SEQUENCE box_no_seq;

-- getSchdSeq Test - TA
DROP SEQUENCE schd_no_seq;
CREATE SEQUENCE schd_no_seq;

-- chat_no_seq - AA
DROP SEQUENCE chat_no_seq;
CREATE SEQUENCE chat_no_seq;

-- chat_con_no_seq - AA
DROP SEQUENCE chat_con_no_seq;
CREATE SEQUENCE chat_con_no_seq;

-- chat_file_no_seq - AA
DROP SEQUENCE chat_file_no_seq;
CREATE SEQUENCE chat_file_no_seq;

-- basic_no_seq - UA
DROP SEQUENCE basic_no_seq;
CREATE SEQUENCE basic_no_seq;

-- task_no_seq - UA
DROP SEQUENCE task_no_seq;
CREATE SEQUENCE task_no_seq;

-- task_user_no_seq - UA
DROP SEQUENCE task_user_no_seq;
CREATE SEQUENCE task_user_no_seq;

-- todo_no_seq - UA
DROP SEQUENCE todo_no_seq;
CREATE SEQUENCE todo_no_seq;

-- todo_item_no_seq - UA
DROP SEQUENCE ti_no_seq;
CREATE SEQUENCE ti_no_seq;

-- vote_no_seq - PL
DROP SEQUENCE vote_no_seq;
CREATE SEQUENCE vote_no_seq;

-- vi_no_seq - PL
DROP SEQUENCE vi_no_seq;
CREATE SEQUENCE vi_no_seq;

-- emo_no_seq - PL
DROP SEQUENCE emo_no_seq;
CREATE SEQUENCE emo_no_seq;

-- emo_user_no_seq - PL
DROP SEQUENCE emo_user_no_seq;
CREATE SEQUENCE emo_user_no_seq;

-- files_no_seq - PL
DROP SEQUENCE files_no_seq;
CREATE SEQUENCE files_no_seq;

-- rep_no_seq - PL
DROP SEQUENCE rep_no_seq;
CREATE SEQUENCE rep_no_seq;

-- coll_no_seq - PL
DROP SEQUENCE coll_no_seq;
CREATE SEQUENCE coll_no_seq;



-- delete
DELETE FROM emoticon_user;
DELETE FROM emoticon;
DELETE FROM collection;
DELETE FROM important;
DELETE FROM box_project;
DELETE FROM box;
DELETE FROM files;
DELETE FROM reply;
DELETE FROM schedule;
DELETE FROM basic;
DELETE FROM task_user;
DELETE FROM task;
DELETE FROM todo_item;
DELETE FROM todo;
DELETE FROM vote_item_user;
DELETE FROM vote_item;
DELETE FROM vote;
DELETE FROM project_user;
DELETE FROM project;
DELETE FROM kind;
DELETE FROM chat_con;
DELETE FROM chat_user;
DELETE FROM chat_file;
DELETE FROM chat;	
DELETE FROM partner;
DELETE FROM member;

-- member
INSERT INTO member(mem_id, mem_name, mem_nick, mem_pw, mem_date, mem_chk, mem_alim_kind, mem_phone, mem_howjoin)
	VALUES('test', '테스트', '테스트닉', '1234', sysdate, 'y', 'y', '01000000000', 'b');
	
INSERT INTO member(mem_id, mem_name, mem_nick, mem_pw, mem_date, mem_chk, mem_alim_kind, mem_phone, mem_howjoin)
	VALUES('test1', '테스트1', '테스트닉1', '1234', sysdate, 'y', 'y', '01000000000', 'k');
	
INSERT INTO member(mem_id, mem_name, mem_nick, mem_pw, mem_date, mem_chk, mem_alim_kind, mem_phone, mem_howjoin)
	VALUES('test2', '테스트2', '테스트닉2', '1234', sysdate, 'y', 'y', '01000000000', 'b');

INSERT INTO member(mem_id, mem_name, mem_nick, mem_pw, mem_date, mem_chk, mem_alim_kind, mem_phone, mem_howjoin)
	VALUES('test3', '테스트3', '테스트닉3', '1234', sysdate, 'y', 'y', '01000000000', 'b');
	
-- kind
INSERT INTO kind(kind_no, kind_name, kind_date, kind_del_chk)
	VALUES(10000, 'init테스트분류', sysdate, 'n');
	
-- project
INSERT INTO project (pro_no, pro_name, pro_cont, pro_del_chk, pro_date, kind_no, mem_id)
	VALUES (10000, 'initTest', 'test', 'n', sysdate, 10000, 'test');

INSERT INTO project (pro_no, pro_name, pro_cont, pro_del_chk, pro_date, kind_no, mem_id)
	VALUES (10001, 'initTest', 'test', 'n', sysdate, 10000, 'test');
	
-- project_user
INSERT INTO project_user (pro_no, mem_id, pro_user_man_chk, pro_user_date, pro_user_color)
	VALUES (10000, 'test', 'n', sysdate, 'default-back-color');
	
INSERT INTO project_user (pro_no, mem_id, pro_user_man_chk, pro_user_date, pro_user_color)
	VALUES (10000, 'test1', 'n', sysdate, 'default-back-color');
	
INSERT INTO project_user (pro_no, mem_id, pro_user_man_chk, pro_user_date, pro_user_color)
	VALUES (10001, 'test', 'n', sysdate, 'default-back-color');
	
INSERT INTO project_user (pro_no, mem_id, pro_user_man_chk, pro_user_date, pro_user_color)
	VALUES (10001, 'test2', 'n', sysdate, 'default-back-color');
	
-- basic
INSERT INTO basic (basic_no, basic_cont, basic_time, basic_del_chk, basic_fix_chk, pro_no, mem_id)
	VALUES (10001, 'basic test content', sysdate, 'n', 'n', 10001, 'test');
	
-- task
INSERT INTO task (task_no, task_title, task_state, task_cont, task_start_date, task_end_date, task_rate,
	task_priority, task_del_chk, task_fix_chk, task_time, pro_no, mem_id)
	VALUES (10001, 'task test title', '진행', 'task test content', '2018-10-18 14:00', '2018-10-18 17:20', 100,
	'긴급', 'n', 'n', sysdate, 10000, 'test');

-- task user
INSERT INTO task_user (task_user_no, task_no, tu_mem_id)
	VALUES (10001, 10001, 'test');
	
-- todo
INSERT INTO todo (todo_no, todo_title, todo_time, todo_rate, todo_del_chk, todo_fix_chk, pro_no, mem_id)
	 VALUES (10001, 'todo test title', sysdate, 20, 'n', 'n', 10001, 'test');

-- todo_item
INSERT INTO todo_item (ti_no, ti_cont, ti_date, ti_chk, todo_no, ti_mem_id)
	 VALUES (10001, 'todo item content test', sysdate, 'n', 10001, 'test');

-- vote
INSERT INTO vote (vote_no, vote_title, vote_time, vote_del_chk, vote_fix_chk, pro_no, mem_id, vote_end_time)
	VALUES (10000, 'init vote test', sysdate, 'n', 'n', 10000, 'test', '2018-10-18');
	
-- vote_item
INSERT INTO vote_item(vi_no, vi_cont, vi_del_chk, vote_no)
	VALUES(10000, 'init vote_item test', 'n', 10000);

-- vote_item_user
INSERT INTO vote_item_user(vi_no, mem_id, viu_date)
	VALUES(10000, 'test', sysdate);
	
-- box
INSERT INTO box (box_no, box_name, box_index, box_date, mem_id, box_del_chk)
	VALUES (10000, 'initTest', '1', sysdate, 'test', 'n');

-- box_project
INSERT INTO box_project (pro_no, box_no, box_pro_date)
	VALUES (10000, 10000, sysdate);

-- important
INSERT INTO important (pro_no, mem_id, imp_date)
	VALUES (10000, 'test', sysdate);
	
-- partner
INSERT INTO partner (ptn_no, ptn_apply_date, ptn_accept_date, ptn_chk, ptn_apply, ptn_accept)
	VALUES (10000, sysdate, sysdate, 'y', 'test1', 'test');

INSERT INTO partner (ptn_no, ptn_apply_date, ptn_accept_date, ptn_chk, ptn_apply, ptn_accept)
	VALUES(10001, sysdate, sysdate, 'y', 'test2', 'test');
	
INSERT INTO partner (ptn_no, ptn_apply_date, ptn_accept_date, ptn_chk, ptn_apply, ptn_accept)
	VALUES(10002, sysdate, sysdate, 'y', 'test', 'test3');
	
-- schedule
INSERT INTO schedule(schd_no,schd_title,schd_loc,schd_memo,schd_start_time,schd_end_time,schd_alarm,schd_time,schd_del_chk,schd_fix_chk,schd_fix_date,pro_no,mem_id, schd_lon, schd_lat)
    VALUES(schd_no_seq.nextval,'일정삽입테스트','대한민국 대전광역시 서구 월평동 400','데헿','2018-10-01 10:30','2018-10-01 12:30','2018-10-01 08:30',sysdate,'n','n',sysdate,10000,'test', '39.000','23.2134');
		      			
INSERT INTO schedule(schd_no,schd_title,schd_loc,schd_memo,schd_start_time,schd_end_time,schd_alarm,schd_time,schd_del_chk,schd_fix_chk,schd_fix_date,pro_no,mem_id,schd_lon, schd_lat)
    VALUES(schd_no_seq.nextval,'초대이벤트 ','대한민국 대전광역시 서구 월평동 400','대한민국임시정부수립날','2018-10-05 10:30','2018-10-05 12:30','2018-10-05 08:30',sysdate,'n','n',sysdate,10000,'test','39.000','23.2134');

-- chat 
INSERT INTO chat (chat_no, chat_title, chat_time, chat_del_chk, mem_id, chat_ip, chat_port)
	VALUES (10000, '채팅방 init테스트1', sysdate, 'n', 'test2', '192.168.207.234', 8180);
	
INSERT INTO chat (chat_no, chat_title, chat_time, chat_del_chk, mem_id, chat_ip, chat_port)
	VALUES (10001, '채팅방 init테스트2', sysdate, 'n', 'test', '192.168.207.235', 8180);
	
-- chat_user
INSERT INTO chat_user (chat_no, mem_id, chat_user_date)
	VALUES (10000, 'test', sysdate);
	
INSERT INTO chat_user (chat_no, mem_id, chat_user_date)
	VALUES (10000, 'test1', sysdate);
	
INSERT INTO chat_user (chat_no, mem_id, chat_user_date)
	VALUES (10000, 'test2', sysdate);
	
INSERT INTO chat_user (chat_no, mem_id, chat_user_date)
	VALUES (10001, 'test', sysdate);
	
INSERT INTO chat_user (chat_no, mem_id, chat_user_date)
	VALUES (10001, 'test1', sysdate);
	
-- chat_con
INSERT INTO chat_con (chat_con_no, chat_con_time, chat_no, chat_cont, mem_id)
	VALUES (10000, sysdate, 10000, 'init채팅방내용테스트1', 'test');
	
INSERT INTO chat_con (chat_con_no, chat_con_time, chat_no, chat_cont, mem_id)
	VALUES (10001, sysdate, 10001, 'init채팅방내용테스트2', 'test1');
	
INSERT INTO chat_con (chat_con_no, chat_con_time, chat_no, chat_cont, mem_id)
	VALUES (10002, sysdate, 10000, 'init채팅방내용테스트3', 'test2');
	
-- emoticon
INSERT INTO emoticon (emo_no, emo_name, emo_pic_name, emo_pic_upload, emo_pic_path, emo_date, emo_del_chk)
	VALUES (10001, 'emo init test', 'init pic_name', 'init pic_upload', 'init pic_path', sysdate, 'n');
	
-- emoticon_user
INSERT INTO emoticon_user (emo_user_no, emo_user_date, emo_no, basic_no, mem_id)
	VALUES (10001, sysdate, 10001, 10001, 'test');
	
-- files
INSERT INTO files (files_no, files_name, files_path, files_upload, files_time, basic_no, files_kind)
	VALUES (10001, 'init files name', 'init files path', 'init files upload', sysdate, 10001, 'file');
	
-- reply
INSERT INTO reply (rep_no, rep_cont, rep_time, rep_del_chk, mem_id, basic_no)
	VALUES (10001, 'init rep cont', sysdate, 'n', 'test', 10001);

-- collction
INSERT INTO collection (coll_no, coll_date, mem_id, todo_no)
	VALUES (10001, sysdate, 'test', 10001);