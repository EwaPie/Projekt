//
// Created by User on 2019-01-13.
//

#ifndef PROJEKT_BILLTYPE_H
#define PROJEKT_BILLTYPE_H

#include<string>

enum BillType {
    BILL, INVOICE
};

inline std::string toString(BillType *v) {
    switch (*v) {
        case BILL:
            return "BILL";
        case INVOICE:
            return "INVOICE";
        default:
            return "Unknown";
    }
}

#endif //PROJEKT_BILLTYPE_H
