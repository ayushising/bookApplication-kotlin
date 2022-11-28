package com.book.modal


class Book{
    var bookId=""
    var title=""
    var author=""
    var category=""
    var price=0.0
    constructor(bookId:String,title:String,author:String,category:String,price:Double){
        this.bookId=bookId
        this.title=title
        this.author=author
        this.category=category
        this.price=price

    }
}