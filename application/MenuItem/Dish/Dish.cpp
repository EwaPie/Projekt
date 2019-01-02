//
// Created by Mateusz on 31.12.2018.
//

#include "Dish.h"

Dish::Dish(const string &name, float price, float discountedPrice, const string &type) : MenuItem(name, price,
                                                                                                  discountedPrice),
                                                                                         type(type) {}

const string &Dish::getType() const {
    return type;
}

void Dish::setType(const string &type) {
    Dish::type = type;
}
