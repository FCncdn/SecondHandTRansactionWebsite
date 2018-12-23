package fuck;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
public class ItemDaoImp extends BaseDao implements MethodDao
{
	public static void sellItem(ItemsDao item) throws Exception
	{
		Connection conn = null;
		PreparedStatement ps=null;
        String itemName = item.getItemName();
        String sellerId = item.getSellerId();
        String price = item.getPrice();
        InputStream  itemPic = item.getPic();

		try
		{
            conn = BaseDao.getConnection();
            ps= conn.prepareStatement("INSERT INTO items(item_name,item_price,seller_id,item_pic) VALUES(?,?,?,?)");
            ps.setString(1, itemName);
            ps.setString(2, price);
            ps.setString(3, sellerId);
            ps.setBinaryStream(4,itemPic,itemPic.available());
            ps.executeUpdate();
        
        } catch(SQLException se) {
            se.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }finally
		{
            try
            {
                if(ps!=null)
                ps.close();
            }catch(SQLException se2)
            {
            }
            try
            {
                if(conn!=null)
                conn.close();
            }catch(SQLException se)
            {
                se.printStackTrace();
            }
        }

    }
	@Override
	public boolean setUpDatabase() {
		// TODO 
//		CREATE TABLE IF NOT EXISTS `items`(
//		 
//		`item_id` INT UNSIGNED AUTO_INCREMENT,
//		   
//		`item_name` VARCHAR(100) NOT NULL,
//		  
//		`item_price` VARCHAR(100) NOT NULL,
//		   
//		`seller_id` VARCHAR(40) NOT NULL,
//		  
//		`item_pic` MEDIUMBLOB NOT NULL,
//		PRIMARY KEY ( `item_id` )
//
//		)ENGINE=InnoDB DEFAULT CHARSET=utf8;
		return false;
	}
	public static void showItemPic(int id) throws Exception  {
		// TODO Auto-generated method stub
		Connection conn = null;
		FileOutputStream fs=null;
		PreparedStatement ps=null;
		try{
            conn = BaseDao.getConnection();
            ps= conn.prepareStatement("SElECT item_pic from items where item_id ="+id);
            ResultSet rset=ps.executeQuery();
            byte b[];
            Blob blob;
            int i=0;
            while(rset.next())
            {
             i++;
             File f=new File("D:\\TomcatUpload\\images\\" + i + ".jpg");
             fs=new FileOutputStream(f);
             blob=rset.getBlob("item_pic");
             b=blob.getBytes(1, (int)blob.length());
             fs.write(b);
            }
        } catch(SQLException se) {
            se.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }finally{
            try{
                if(ps!=null)
                	ps.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null)
                conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
            try 
            {
            	if(fs!=null)
            		fs.close();
            }catch(IOException ioe)
            {
            	ioe.printStackTrace();
            }
        }
		
	}
}
