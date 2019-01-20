#include <utility>

//
// Created by User on 2019-01-13.
//

#include "Bill.h"

bool Bill::addMenuItem(shared_ptr<MenuItem> item) {
    menuItems.push_back(item);
    refreshCurrentAmount();

    return true;
}

void Bill::refreshCurrentAmount() {
    double amount = 0;
    for (const auto &item : menuItems) {
        amount += item->getPriceBrutto();
    }

    for (const auto &item : discounts) {
        amount *= stoi(item);
        break;
    }

    currentAmount = amount;
}

bool Bill::removeMenuItem(shared_ptr<MenuItem> item) {
    for (auto it = menuItems.begin(); it != menuItems.end();) {
        if (*it == item) {
            menuItems.erase(it);
            refreshCurrentAmount();
        }
    }
}

double Bill::getCurrentAmount() {
    return currentAmount;
}

bool Bill::addDiscount(string discount) {
    for (auto it = discounts.begin(); it != discounts.end();) {
        if (*it == discount) {
            return true;
        }
    }
    discounts.push_back(discount);
}

bool Bill::removeDiscount(string discount) {
    for (auto it = discounts.begin(); it != discounts.end();) {
        if (*it == discount) {
            discounts.erase(it);
            return true;
        }
    }
    return false;
}

vector<string> Bill::getDiscounts() {
    return discounts;
}

void Bill::setBillType(shared_ptr<BillType> billType) {
    this->billType = move(billType);
}

string Bill::createBillPrintFile() {
    if (!paid) {
        return "";
    }
    string result = getFileHeader();
    result + "Data sporządzenia : " + getCurrentDateTime() + "\n";
    result + "Do zapłaty: " + to_string(currentAmount) + "\n";

    return result;
}

string Bill::getCurrentDateTime() const {
    time_t rawtime;
    struct tm *timeinfo;
    char buffer[80];

    time(&rawtime);
    timeinfo = localtime(&rawtime);

    strftime(buffer, sizeof(buffer), "%d-%m-%Y %H:%M:%S", timeinfo);
    string str(buffer);
    return str;
}

string Bill::getFileHeader() const {
    switch (*billType) {
        case BILL: {
            return "\t\tPARAGON\n";
        }
        case INVOICE: {
            return "\t\tFAKTURA\n";
        }
        default: {
            return "NIE_WYBRANO_TYPU\n";
        }
    }
}

bool Bill::closeBill() {
    if (!canClose()) {
        return false;
    }
    ContextManager::getInstance()->getStatisticService()->addEvent(make_shared<Bill>(this));
    closed = true;
    return true;
}

shared_ptr<BillType> Bill::getBillType() {
    return billType;
}

bool Bill::canClose() {
    return paid && !closed;
}

bool Bill::payYour() {
    if (!closed && !paid) {
        paid = true;
        return true;
    }
    return false;
}


