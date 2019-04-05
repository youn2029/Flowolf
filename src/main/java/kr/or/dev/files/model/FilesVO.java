package kr.or.dev.files.model;

import java.util.Date;

public class FilesVO implements Comparable<FilesVO> {

	private int files_no;			// 파일번호(pk)
	private String files_name;		// 파일명
	private String files_path;		// 파일경로
	private String files_upload;	// 업로드파일명
	private String files_size;		// 파일크기
	private String files_kind;		// 첨부 구분
	private Date files_time;		// 작성일시
	private int basic_no;			// 일반글번호
	private int task_no;			// 업무글번호
	private int rep_no;				// 댓글번호	
	private int post_no;			// 게시글번호
	private String pro_name;		// 프로젝트명(vo에서만 사용)
	private String mem_nick;		// 작성자(vo에서만 사용)	

	public int getFiles_no() {
		return files_no;
	}

	public void setFiles_no(int files_no) {
		this.files_no = files_no;
	}

	public String getFiles_name() {
		return files_name;
	}

	public void setFiles_name(String files_name) {
		this.files_name = files_name;
	}

	public String getFiles_path() {
		return files_path;
	}

	public void setFiles_path(String files_path) {
		this.files_path = files_path;
	}

	public String getFiles_upload() {
		return files_upload;
	}

	public void setFiles_upload(String files_upload) {
		this.files_upload = files_upload;
	}

	public Date getFiles_time() {
		return files_time;
	}

	public void setFiles_time(Date files_time) {
		this.files_time = files_time;
	}

	public int getBasic_no() {
		return basic_no;
	}

	public void setBasic_no(int basic_no) {
		this.basic_no = basic_no;
	}

	public int getTask_no() {
		return task_no;
	}

	public void setTask_no(int task_no) {
		this.task_no = task_no;
	}

	public int getRep_no() {
		return rep_no;
	}

	public void setRep_no(int rep_no) {
		this.rep_no = rep_no;
	}

	public int getPost_no() {
		return post_no;
	}

	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}

	public String getFiles_kind() {
		return files_kind;
	}

	public void setFiles_kind(String files_kind) {
		this.files_kind = files_kind;
	}

	public String getFiles_size() {
		return files_size;
	}

	public void setFiles_size(String files_size) {
		this.files_size = files_size;
	}

	public String getPro_name() {
		return pro_name;
	}

	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}

	public String getMem_nick() {
		return mem_nick;
	}

	public void setMem_nick(String mem_nick) {
		this.mem_nick = mem_nick;
	}

	@Override
	public int compareTo(FilesVO filesVo) {
		return filesVo.getFiles_time().compareTo(files_time);
	}
	
}
