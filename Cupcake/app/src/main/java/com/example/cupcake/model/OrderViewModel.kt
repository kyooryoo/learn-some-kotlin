package com.example.cupcake.model

import androidx.lifecycle.Transformations
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

private const val PRICE_PER_CUPCAKE = 2.00
private const val PRICE_FOR_SAME_DAY_PICKUP = 3.00

class OrderViewModel : ViewModel() {
    private val _quantity = MutableLiveData<Int>()
    val quantity: LiveData<Int> = _quantity

    private val _flavor = MutableLiveData<String>()
    val flavor: LiveData<String> = _flavor

    lateinit var dateOptions: List<String>
    private val _date = MutableLiveData<String>()
    val date: LiveData<String> = _date

    private val _price = MutableLiveData<Double>()
    val price: LiveData<String> = Transformations.map(_price) {
        NumberFormat.getCurrencyInstance().format(it)
    }

    private val _name = MutableLiveData<String>()
    var name: LiveData<String> = _name

    init {
        setPickupOptions()
        resetOrder()
    }

    fun setQuantity(numberCupcakes: Int) {
        _quantity.value = numberCupcakes
        updatePrice()
    }

    fun setFlavor(desiredFlavor: String) {
        _flavor.value = desiredFlavor
        setPickupOptions()
    }

    fun setDate(pickupDate: String) {
        _date.value = pickupDate
        updatePrice()
    }

    fun hasNoFlavorSet(): Boolean {
        return _flavor.value.isNullOrEmpty()
    }

    fun setName(username: String) {
        _name.value = username
    }

    fun resetOrder() {
        _quantity.value = 0
        _flavor.value = ""
        _date.value = dateOptions[0]
        _price.value = 0.0
        _name.value = "there"
    }

    private fun updatePrice() {
        var calculatedPrice = (quantity.value ?: 0) * PRICE_PER_CUPCAKE
        if (dateOptions[0] == _date.value) {
            calculatedPrice += PRICE_FOR_SAME_DAY_PICKUP
        }
        _price.value = calculatedPrice
    }

    private fun setPickupOptions() {
        val options = mutableListOf<String>()
        val formatter = SimpleDateFormat("E, MMM d, yyyy", Locale.getDefault())
        val calendar = Calendar.getInstance()
        if (flavor.value.toString() == "Special Flavor (ONLY Weekend)") {
            while (options.size < 4) {
                if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY ||
                    calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY
                ) {
                    options.add(formatter.format(calendar.time))
                }
                calendar.add(Calendar.DATE, 1)
            }
        } else {
            repeat(4) {
                options.add(formatter.format(calendar.time))
                calendar.add(Calendar.DATE, 1)
            }
        }
        this.dateOptions = options
    }
}