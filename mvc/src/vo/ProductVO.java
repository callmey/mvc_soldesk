package vo;

public class ProductVO {
	private int pno;
	private String pname;
	private int price;
	private int dcratio;
	private String prodesc;
	private int qty;
	private String imgfile;
	private String bgfile;
	
	public ProductVO() {}
	
	public ProductVO(String pname, int price, int dcratio, String prodesc, int qty, String imgfile, String bgfile) {
		super();
		this.pname = pname;
		this.price = price;
		this.dcratio = dcratio;
		this.prodesc = prodesc;
		this.qty = qty;
		this.imgfile = imgfile;
		this.bgfile = bgfile;
	}

	public ProductVO(int pno, String pname, int price, int dcratio, String prodesc, int qty, String imgfile,
			String bgfile) {
		super();
		this.pno = pno;
		this.pname = pname;
		this.price = price;
		this.dcratio = dcratio;
		this.prodesc = prodesc;
		this.qty = qty;
		this.imgfile = imgfile;
		this.bgfile = bgfile;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDcratio() {
		return dcratio;
	}

	public void setDcratio(int dcratio) {
		this.dcratio = dcratio;
	}

	public String getProdesc() {
		return prodesc;
	}

	public void setProdesc(String prodesc) {
		this.prodesc = prodesc;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getImgfile() {
		return imgfile;
	}

	public void setImgfile(String imgfile) {
		this.imgfile = imgfile;
	}

	public String getBgfile() {
		return bgfile;
	}

	public void setBgfile(String bgfile) {
		this.bgfile = bgfile;
	}
	
	
	
	
}
