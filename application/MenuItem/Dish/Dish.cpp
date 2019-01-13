//
// Created by Mateusz on 31.12.2018.
//

#include "Dish.h"


const string &Dish::getType() const {
    return type;
}

void Dish::setType(const string &type) {
    Dish::type = type;
}

Dish::Dish(const string &name, float priceNetto, float discountedPriceNetto, float taxRate, const string &type)
        : MenuItem(name, priceNetto, discountedPriceNetto, taxRate), type(type) {}
