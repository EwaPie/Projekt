//
// Created by Mateusz on 31.12.2018.
//

#include "Drink.h"

Drink::Drink(const string &name, float price, float discountedPrice, bool isAlcohol) : MenuItem(name, price,
                                                                                                discountedPrice),
                                                                                       isAlcohol(isAlcohol) {}

bool Drink::isIsAlcohol() const {
    return isAlcohol;
}

void Drink::setIsAlcohol(bool isAlcohol) {
    Drink::isAlcohol = isAlcohol;
}
