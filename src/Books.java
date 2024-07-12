import java.sql.*;
public class Books extends DatabaseConnection {
	
	// Method to add a new Book
	public void addBook(String title,String author,String published_date,boolean available){
		String sql ="INSERT INTO books(title,author,published_date,available) VALUES (?,?,?,?)";
		try(Connection connection = getConnection();
			PreparedStatement pstmt = connection.prepareStatement(sql)){
				pstmt.setString(1, title);
				pstmt.setString(2, author);
				pstmt.setDate(3, java.sql.Date.valueOf(published_date));
				pstmt.setBoolean(4, available);
				pstmt.executeUpdate();
				System.out.println("Book added successfully.");
		}
	
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//Method to get all the books
	public void getAllBooks() {
		String sql = "SELECT * FROM books";
		try (Connection connection = DatabaseConnection.getConnection();
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(sql)){
			while(rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				java.sql.Date published_date = rs.getDate("published_date");
				boolean available = rs.getBoolean("available");
				System.out.printf("ID: %d, Title: %s, Author: %s, Published Date: %s, Available: %b%n", 
	                    id, title, author, published_date, available);
			}
			
		} catch (SQLException e) {
			e.getStackTrace();
		}
	}
		
		//Method to update book
		public void updateBook(int id,String title,String author,String published_date, boolean available) {
		String sql = "UPDATE books SET title = ?, author = ?, published_date = ?, available = ? Where id = ?";
		try(Connection connection = DatabaseConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(sql)){
				pstmt.setString(1, title);
				pstmt.setString(2, author);
				pstmt.setDate(3, java.sql.Date.valueOf(published_date));
				pstmt.setBoolean(4, available);
				pstmt.setInt(5, id);
				pstmt.executeUpdate();
				System.out.println("Book updated successfully.");
				
		}
		catch (SQLException e) {
            e.printStackTrace();
        }
		}
		
		//Method to delete book
		public void deleteBook(int id) {
	        String sql = "DELETE FROM books WHERE id = ?";
	        try (Connection connection = DatabaseConnection.getConnection();
	             PreparedStatement pstmt = connection.prepareStatement(sql)) {
	            pstmt.setInt(1, id);
	            pstmt.executeUpdate();
	            System.out.println("Book deleted successfully!");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    
		}
}

		
	
		


		
		
		
		
		
		
		
		
	
	
	

	



