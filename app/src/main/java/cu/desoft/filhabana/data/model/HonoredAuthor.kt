package cu.desoft.filhabana.data.model

import androidx.annotation.DrawableRes

class HonoredAuthor(
    val stringName: String,
    val stringDescription: String,
    var contentExpandable: Boolean,
    @DrawableRes
    val imageResourceId: Int
)