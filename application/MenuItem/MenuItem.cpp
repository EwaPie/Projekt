//
// Created by Mateusz on 31.12.2018.
//

#include "MenuItem.h"

MenuItem::MenuItem(const string &name, float price, float discountedPrice) : name(name), price(price),
                                                                             discountedPrice(discountedPrice) {}

const string &MenuItem::getName() const {
    return name;
}

void MenuItem::setName(const string &name) {
    MenuItem::name = name;
}

float MenuItem::getPrice() const {
    return price;
}

void MenuItem::setPrice(float price) {
    MenuItem::price = price;
}

float MenuItem::getDiscountedPrice() const {
    return discountedPrice;
}

void MenuItem::setDiscountedPrice(float discountedPrice) {
    MenuItem::discountedPrice = discountedPrice;
}


float MenuItem::getRealPrice() {
    return discountedPrice < price ? discountedPrice : price;
}