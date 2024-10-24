package com.example.gootaxtestproject.data

import com.example.gootaxtestproject.R
import com.example.gootaxtestproject.data.network.model.Suggestion

sealed class Items {

    data class PromoUiItems(val items: List<PromoItems>) : Items()

    data class PromoBannerUiIItems(val items: List<PromoBannerItems>) : Items()

    data class PromotionalItemsUiItems(val items: List<PromotionalItems>) : Items()

    data class CategoriesUiItems(val items: List<CategoriesItems>) : Items()
}
sealed class ItemList {
    data class AddressItemsList(val address: Suggestion) : ItemList()
}

data class PromoItems(
    val image: Int,
    val name: String,
)

data class PromoBannerItems(
    val bannerColor: Int
)

data class PromotionalItems(
    val sale: String,
    val image: Int,
    val name: String,
    val weight: String,
    val oldPrice: String,
    val priceNow: String
)

data class CategoriesItems(
    val image: Int,
    val name: String,
    val background: String
)

val itemsForContainer = listOf(
    Items.PromoUiItems(
        listOf(
            PromoItems(R.drawable.image_169_1, "Летний пикник"),
            PromoItems(R.drawable.image_170, "Летний обед"),
            PromoItems(R.drawable.image_172, "На завтрак"),
            PromoItems(R.drawable.image_173, "На ужин"),
            PromoItems(R.drawable.image_169_1, "На обед"),
            PromoItems(R.drawable.image_172, "На поминки"),
        )
    ),
    Items.PromoBannerUiIItems(
        listOf(
            PromoBannerItems(R.drawable.image_149),
            PromoBannerItems(R.drawable.i_1),
            PromoBannerItems(R.drawable.i_1),
            PromoBannerItems(R.drawable.image_149),
            PromoBannerItems(R.drawable.i_1),
            PromoBannerItems(R.drawable.i_2),
            PromoBannerItems(R.drawable.image_149),
        )
    ),
    Items.PromotionalItemsUiItems(
        listOf(
            PromotionalItems(
                "25%",
                R.drawable.image_199,
                "Черные спагетти с торфом",
                "360г",
                "360p",
                "260p"
            ),
            PromotionalItems(
                "15%",
                R.drawable.image_197,
                "Казаречче с индейкой и томатами",
                "560г",
                "560p",
                "260p"
            ),
            PromotionalItems(
                "13%",
                R.drawable.image_190,
                "Равиоли с грибами",
                "360г",
                "1260p",
                "760p"
            ),
            PromotionalItems(
                "15%",
                R.drawable.image_183,
                "Казаречче с гречкой и сливами",
                "660г",
                "460p",
                "560p"
            ),
            PromotionalItems(
                "15%",
                R.drawable.image_188,
                "Пицца с креветкой и крекером",
                "360г",
                "360p",
                "260p"
            ),
            PromotionalItems(
                "15%",
                R.drawable.image_199,
                "Фирменный риганинни с томатом",
                "360г",
                "360p",
                "260p"
            ),
            PromotionalItems(
                "15%",
                R.drawable.image_197,
                "Улялямбус под шафэ",
                "360г",
                "360p",
                "260p"
            )
            )
    ),
    Items.CategoriesUiItems(
        listOf(
            CategoriesItems(R.drawable.image_199, "Наборы", "#FFC1B6"),
            CategoriesItems(R.drawable.image_199, "Пицца", "#FFE1AD"),
            CategoriesItems(R.drawable.image_197, "Паста", "#BAB892"),
            CategoriesItems(R.drawable.image_197, "Ризотто", "#C4D3CE"),
            CategoriesItems(R.drawable.image_199, "Салаты", "#B9C4C8"),
            CategoriesItems(R.drawable.image_182, "Полу\nфабрикаты", "#A3AE9D"),
            CategoriesItems(R.drawable.image_186, "Десерты", "#FFE6B6"),
            CategoriesItems(R.drawable.image_199, "Добавки\nк блюдам", "#D3C4C4"),
            CategoriesItems(R.drawable.image_186, "Напитки", "#FFD4AD"),
        )
    )
)