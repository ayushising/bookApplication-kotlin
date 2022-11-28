package com.book.service

import BookUtil
import InvalidBookException
import com.book.modal.Book

class BookStore {
    var bookUtil=BookUtil()
    fun addBook(book: Book){
        validate(book)
        bookUtil.insertdata(book)
    }
    fun modifyBook(book: Book){
        validate(book)
        bookUtil.updatedata(book)
    }
    fun searchByTitle(title:String){
        bookUtil.getbookbyTitle(title)
    }
    fun searchByAuthor(author:String){
        bookUtil.getbookbyAuthor(author)
    }
    fun searchBybookId(bookId:String){
        bookUtil.getbookbybookId(bookId)
    }
    fun deleteproduct(bookId:String){
        bookUtil.deletedata(bookId)
    }
    fun displayAll(){
        bookUtil.displayallBooks()
    }
    fun validate(book:Book){
        var exeptionstring=""
        var cateories= mutableListOf<String>("Science","Fiction","Technology","others")
        if(book.bookId.toString().length==4 && book.bookId.toString()[0]=='B'){
            exeptionstring+=""
        }
        else{
            exeptionstring+="The given Book Id is not Appropriate."
        }
        if(book.price>0){
            exeptionstring+=""
        }
        else{
            exeptionstring+="Price should be greater than 0."
        }
        if(book.category in cateories){
            exeptionstring+=""
        }
        else{
            exeptionstring+="Categories should Science,Fiction,Technology,others"
        }
        try{
            if(exeptionstring.length>0)
                throw InvalidBookException(exeptionstring)
        }
        catch (e:InvalidBookException){
            println(e.message)
            System.exit(0)
        }
    }

}