import com.book.modal.Book
import java.sql.ResultSet

class BookUtil{
    var dbcon=DbConnection()
    var connection=dbcon.connect()
    fun createBook(){
        var stmt=connection.createStatement()
        stmt.execute("create table book (bookId varchar(50),title varchar(50), author varchar(50) ,category varchar(50), price DOUBLE);")
    }
    fun insertdata(book:Book){
        var stmt=connection.prepareStatement("insert into book values(?,?,?,?,?);")
        stmt.setString(1,book.bookId)
        stmt.setString(2,book.title)
        stmt.setString(3,book.author)
        stmt.setString(4,book.category)
        stmt.setDouble(5,book.price)
        var res=stmt.executeUpdate()
        if(res>0){
            println("${res} rows inserted")
        }
    }
    fun updatedata(book:Book){
        var stmt=connection.prepareStatement("update book SET title=? ,author=? ,category=? , price=? where bookId=?;")

        stmt.setString(1,book.title)
        stmt.setString(2,book.author)
        stmt.setString(3,book.category)
        stmt.setDouble(4,book.price)
        stmt.setString(5,book.bookId)
        var res=stmt.executeUpdate()
        if(res>0){
            println("${res} rows updated")
        }
        else{
            println("No data found with the given Bookid")
        }
    }
    fun deletedata(bookId:String){
        var stmt=connection.prepareStatement("delete from book where bookId = ?;")
        stmt.setString(1,bookId)
        var res=stmt.executeUpdate()
        if(res>0){
            println("${res} rows deleted")
        }
        else{
            println("No row present with given bookId")
        }
    }

    fun getbookbyTitle(title:String){
        var stmt=connection.prepareStatement("SELECT * FROM book where title=? ; ")
        stmt.setString(1,title)
        var result=stmt.executeQuery()
        display(result)

    }
    fun getbookbyAuthor(author:String){
        var stmt=connection.prepareStatement("SELECT * FROM book where author=? ; ")
        stmt.setString(1,author)
        var result=stmt.executeQuery()
        display(result)
    }
    fun getbookbybookId(bookId: String){
        var stmt=connection.prepareStatement("SELECT * FROM book where bookId=? ; ")
        stmt.setString(1,bookId)
        var result=stmt.executeQuery()
        display(result)
    }
    fun displayallBooks(){
        var stmt=connection.createStatement()
        var result=stmt.executeQuery("select * from book; ")
       display(result)
    }
    fun display(result:ResultSet){
        var bookList= mutableListOf<Book>()
        while(result.next()){
            val bookId = result.getString("bookId")
            val title = result.getString("title")
            val author = result.getString("author")
            val category = result.getString("category")
            val price = result.getDouble("price")
            bookList.add(Book(bookId,title,author,category,price))
        }
        if(bookList.count()>0){
            println("bookid    title    author    category      price")
            for(book in bookList){
                println("${book.bookId}    ${book.title}      ${book.author}       ${book.category}   ${book.price}")
            }
        }
        else{
            println("No Books")
        }

    }
}