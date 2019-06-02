package it.aust.model;

/**
 * 图书实体
 * @author Administrator
 *
 */
public class Book {

	private int id; // 编号
	private String bookName; // 图书名称
	private String author; // 作者
	private String sex; // 性别
	private Float price; // 图书价格
	private String bookDesc; // 备注
	private Integer bookTypeId; // 图书类型Id
	private String BookTypeName; // 图书类型名称
	
	
	
	



	


	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Book(String bookName, String author, String sex, Float price, String bookDesc, Integer bookTypeId) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.sex = sex;
		this.price = price;
		this.bookDesc = bookDesc;
		this.bookTypeId = bookTypeId;
	}
	
	
	
	


	public Book(Integer id,String bookName, String author, String sex, Float price, String bookDesc, Integer bookTypeId) {
		super();
		this.id=id;
		this.bookName = bookName;
		this.author = author;
		this.sex = sex;
		this.price = price;
		this.bookDesc = bookDesc;
		this.bookTypeId = bookTypeId;
	}


	public Book(String bookName, String author, Integer bookTypeId) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.bookTypeId = bookTypeId;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getBookDesc() {
		return bookDesc;
	}
	public void setBookDesc(String bookDesc) {
		this.bookDesc = bookDesc;
	}
	public Integer getBookTypeId() {
		return bookTypeId;
	}
	public void setBookTypeId(Integer bookTypeId) {
		this.bookTypeId = bookTypeId;
	}
	public String getBookTypeName() {
		return BookTypeName;
	}
	public void setBookTypeName(String bookTypeName) {
		BookTypeName = bookTypeName;
	}
	
}
