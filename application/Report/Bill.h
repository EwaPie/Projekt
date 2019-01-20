//
// Created by User on 2019-01-13.
//

#ifndef PROJEKT_BILL_H
#define PROJEKT_BILL_H

#include <vector>
#include <string>

#include "../MenuItem/MenuItem.h"
#include "BillType.h"
#include "../ContextManager/ContextManager.h"
#include <memory>

using namespace std;

class Bill {
private:
    vector<shared_ptr<MenuItem>> menuItems;
    vector<string> discounts;
    shared_ptr<BillType> billType;
    bool paid = false;
    bool closed = false;
    double currentAmount;
public:

    bool addMenuItem(shared_ptr<MenuItem> item);

    bool removeMenuItem(shared_ptr<MenuItem> item);

    double getCurrentAmount();

    bool addDiscount(string discount);

    bool removeDiscount(string discount);

    vector<string> getDiscounts();

    void setBillType(shared_ptr<BillType> billType);

    shared_ptr<BillType> getBillType();

    string createBillPrintFile();

    bool closeBill();

    bool canClose();

    bool payYour();

    string getFileHeader() const;

    string getCurrentDateTime() const;

    void refreshCurrentAmount();
};


#endif //PROJEKT_BILL_H
