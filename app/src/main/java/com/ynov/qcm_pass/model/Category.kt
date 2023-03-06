package com.ynov.qcm_pass.model

enum class Category(val uc: String, val label: String) {
    UC7("UC7","Inégalités de santé, Violence et maltraitance, Histoire des politiques de santé publique"),
    UC66("UC?","?"),//factice crée pour le remplissage
    UC67("UC?","? bis");//factice crée pour le remplissage


    //permet de faire la list de l'énum peut importe le nombre ou son contenue
    companion object {
        fun list(): List<Category> {
            val itemList = mutableListOf<Category>()

            for (category in Category.values()) {
                itemList.add(category)
            }
            return itemList
        }
    }
}


