package com.ynov.qcm_pass.model

enum class Category {
    CAT1,
    CAT2,
    CAT3;



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


