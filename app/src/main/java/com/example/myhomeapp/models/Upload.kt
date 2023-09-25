package com.example.myhomeapp.models

class Upload {
    var image: String = ""
    var name: String = ""
    var price: String = ""
    var description: String = ""
    var id: String = ""


    constructor(image: String, name: String, price: String, description: String, id: String) {
        this.image = image
        this.name = name
        this.price = price
        this.description = description
        this.id = id
    }
    constructor()
}

