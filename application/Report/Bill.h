//
// Created by User on 2019-01-13.
//

#ifndef PROJEKT_BILL_H
#define PROJEKT_BILL_H

#include <list>
#include <string>

#include "../MenuItem/MenuItem.h"
#include "BillType.h"

using namespace std;

class Bill {
private:
    list<MenuItem *> *menuItems;
    list<string> *discounts;
    BillType *billType;
    double currentAmount;
public:
    Bill();
    ~Bill();

    bool addMenuItem(MenuItem *item);

    bool removeMenuItem(MenuItem *item);

    double getCurrentAmount();

    bool addDiscount(string discount);

    bool removeDiscount(string discount);

    list<string> *getDiscounts();

    void setBillType(BillType *billType);

    BillType *getBillType();

    unsigned char *createBillPrintFile();

    bool closeBill();
};


#endif //PROJEKT_BILL_H
