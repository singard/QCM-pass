package com.ynov.qcm_pass.model

enum class Category(val ue: String, val label: String) {
    UE7("ue7","Inégalités de santé, Violence et maltraitance, Histoire des politiques de santé publique"),
    UE66("ue?","?"),//factice crée pour le remplissage
    UE67("ue?","? bis");//factice crée pour le remplissage


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


