package com.example.affirmations.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Affirmation(
    // use arg comment to distinguish different types of args
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
    ) {
}