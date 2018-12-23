package fuck;

import java.io.InputStream;

public class ItemsDao{
	private String sellerId;
	private String itemName;
	private String price;
	private InputStream pic;
	public ItemsDao() {
		super();
	}
	public ItemsDao(String sellerId,String itemName,String price,InputStream pic) 
	{
		super();
		this.sellerId=sellerId;
		this.itemName=itemName;
		this.price=price;
		this.pic=pic;
	}
	public String getSellerId() {
		return sellerId;
	}
	public String getItemName() {
		return itemName;
	}
	public String getPrice() {
		return price;
	}
	public InputStream getPic() {
		return pic;
	}
}
