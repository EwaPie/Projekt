//
// Created by Mateusz on 31.12.2018.
//

#include "Drink.h"

bool Drink::isIsAlcohol() const {
    return isAlcohol;
}

void Drink::setIsAlcohol(bool isAlcohol) {
    Drink::isAlcohol = isAlcohol;
}

Drink::Drink(const string &name, float priceNetto, float discountedPriceNetto, float taxRate, int realizationTime,
             bool isAlcohol) : MenuItem(name, priceNetto, discountedPriceNetto, taxRate, realizationTime),
                               isAlcohol(isAlcohol) {}