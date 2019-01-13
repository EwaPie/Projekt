//
// Created by User on 2019-01-13.
//

#include "Bill.h"

bool Bill::addMenuItem(MenuItem *item) {
    menuItems->push_back(item);
    return true;
}

Bill::Bill() {
    menuItems = new list<MenuItem *>;
    discounts = new list<string>;
}

bool Bill::removeMenuItem(MenuItem *item) {
    for (auto it = menuItems->begin(); it != menuItems->end();) {
        if (*it == item) {
            menuItems->erase(it);
        }
    }
}

double Bill::getCurrentAmount() {
    return currentAmount;
}

bool Bill::addDiscount(string discount) {
    for (auto it = discounts->begin(); it != discounts->end();) {
        if (*it == discount) {
            return true;
        }
    }
    discounts->push_back(discount);
}

bool Bill::removeDiscount(string discount) {
    for (auto it = discounts->begin(); it != discounts->end();) {
        if (*it == discount) {
            discounts->erase(it);
            return true;
        }
    }
    return false;
}

list<string> *Bill::getDiscounts() {
    return discounts;
}

void Bill::setBillType(BillType *billType) {
    this->billType = billType;
}

unsigned char *Bill::createBillPrintFile() {
    return nullptr;
}

bool Bill::closeBill() {
    return false;
}

Bill::~Bill() {
    delete menuItems;
    delete discounts;
}

BillType *Bill::getBillType() {
    return billType;
}


