import com.book.modal.Book
import com.book.service.BookStore
import java.util.Scanner
fun main() {
    var bookStore= BookStore()
    println("=======================================")
    while(true){
        println("***************WELCOME TO BOOK STORE*********************")
        println("=============Enter Your Choice=================")
        
        println("1.Insert  Book")
        println("2.Delete Book")  
        println("3.Diplay ")  
        println("4.Search Author")
        prinltn("5.Search  Title")
        println("6.Search Id")
        println("7.ModifyBook")
        println("8.Exit")
        
        
        println("Enter values:")
        var sc=Scanner(System.`in`)
        var value=sc.nextInt()
        when(value) {
            1 -> {
                println("Enter values:")
                bookStore.addBook(getvalues("Insert Book"))
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
                bookStore.searchByAuthor(getvalues("Search Author").author)
                println("=======================================")

            }
            5->{
                println("The given Title book Details:")
                bookStore.searchByTitle(getvalues("Searc title").title)
                println("=======================================")
            }
            6->{
                println("The given bookid book Details:")
                bookStore.searchBybookId(getvalues("Search bookId").bookId)
                println("=======================================")
            }
            7->{
                println("Enter values to modify:")
                bookStore.modifyBook(getvalues("Modify Book"))
            }
            else -> {
                println("===========Done===========")
                break
            }
        }
    }

}

}
