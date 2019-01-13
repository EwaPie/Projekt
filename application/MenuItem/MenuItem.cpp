//
// Created by Mateusz on 31.12.2018.
//

#include "MenuItem.h"


MenuItem::MenuItem(const string &name, float priceNetto, float discountedPriceNetto, float taxRate, int realizationTime) : name(name),
                                                                                                      priceNetto(
                                                                                                              priceNetto),
                                                                                                      discountedPriceNetto(
                                                                                                              discountedPriceNetto),
                                                                                                      taxRate(taxRate),
                                                                                                      realizationTime(realizationTime){
    priceBrutto = priceNetto + priceNetto*taxRate;
    discountedPriceBurtto = discountedPriceNetto * discountedPriceNetto*taxRate;
}

const string &MenuItem::getName() const {
    return name;
}

void MenuItem::setName(const string &name) {
    MenuItem::name = name;
}

float MenuItem::getPriceNetto() const {
    return priceNetto;
}

void MenuItem::setPriceNetto(float priceNetto) {
    MenuItem::priceNetto = priceNetto;
}

float MenuItem::getPriceBrutto() const {
    return priceBrutto;
}

void MenuItem::setPriceBrutto(float priceBrutto) {
    MenuItem::priceBrutto = priceBrutto;
}

float MenuItem::getDiscountedPriceNetto() const {
    return discountedPriceNetto;
}

void MenuItem::setDiscountedPriceNetto(float discountedPriceNetto) {
    MenuItem::discountedPriceNetto = discountedPriceNetto;
}

float MenuItem::getDiscountedPriceBurtto() const {
    return discountedPriceBurtto;
}

void MenuItem::setDiscountedPriceBurtto(float discountedPriceBurtto) {
    MenuItem::discountedPriceBurtto = discountedPriceBurtto;
}

float MenuItem::getTaxRate() const {
    return taxRate;
}

void MenuItem::setTaxRate(float taxRate) {
    MenuItem::taxRate = taxRate;
}

int MenuItem::getRealizationTime() const {
    return realizationTime;
}

void MenuItem::setRealizationTime(int realizationTime) {
    MenuItem::realizationTime = realizationTime;
}

MenuItem::~MenuItem() = default;
