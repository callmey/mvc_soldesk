package vo;

public class MBoardVO {
	private int bno;
	private String title;
	private String contents;
	private String writer;
	private String ip;
	private int hits;
	private String wdate;
	
	public MBoardVO() {
		// TODO Auto-generated constructor stub
	}

	public MBoardVO(int bno, String title, String contents, String writer, String ip, int hits, String wdate) {
		super();
		this.bno = bno;
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.ip = ip;
		this.hits = hits;
		this.wdate = wdate;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	
	
}
