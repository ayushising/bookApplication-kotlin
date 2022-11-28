import com.book.modal.Book
import com.book.service.BookStore
import java.util.Scanner
fun main() {
    var bookStore= BookStore()
    println("=======================================")
    while(true){
        println("***************WELCOME TO BOOK STORE*********************")
        println("=============Enter Your Choice=================")
        println("1.Insert  2.Delete  3.Diplay  4.Search Author 5.Search  Title 6.Search Id  7.ModifyBook 8.Exit")
        println("enter value:")
        var sc=Scanner(System.`in`)
        var value=sc.nextInt()
        when(value) {
            1 -> {
                println("Enter values:")
                bookStore.addBook(getvalues("insert"))
            }

            2 -> {
                println("Enter id:")
                bookStore.deleteproduct(getvalues("delete").bookId)
            }
            3->{
                println("==========view all books===========")
                bookStore.displayAll()
                println("=======================================")
            }
            4 -> {
                println("The given Author book Details:")
                bookStore.searchByAuthor(getvalues("searchByAuthor").author)
                println("=======================================")

            }
            5->{
                println("The given Title book Details:")
                bookStore.searchByTitle(getvalues("searchByTitle").title)
                println("=======================================")
            }
            6->{
                println("The given bookid book Details:")
                bookStore.searchBybookId(getvalues("searchBybookId").bookId)
                println("=======================================")
            }
            7->{
                println("Enter values to modify:")
                bookStore.modifyBook(getvalues("modify"))
            }
            else -> {
                println("===========Execution completed===========")
                break
            }
        }
    }

}
fun getvalues(action:String):Book{
    var sc=Scanner(System.`in`)

    if(action=="insert"||action=="modify")
    {
        println("bookId:")
        var bookId=sc.next()
        println("Title:")
        var title=sc.next()
        println("Author:")
        var author=sc.next()
        println("Category:")
        var category=sc.next()
        println("price:")
        var price=sc.nextDouble()
        return Book(bookId,title,author,category,price)
    }
    else{
        if(action=="Search Author"){
            println("Author:")
            var author=sc.next()
            return Book("","",author,"",0.0)
        }
        else if(action=="delete"|| action=="Search Id"){
            println("bookId:")
            var bookId=sc.next()
            return Book(bookId,"","","",0.0)
        }
        else if(action=="Search Title"){
            println("Title:")
            var title=sc.next()
            return Book("",title,"","",0.0)
        }
        else{
            return Book("","","","",0.0)
        }

    }
}