#pragma once

#include <string>
#include <memory>

using namespace std;

enum BillType {
    BILL, INVOICE
};

inline string toString(const shared_ptr<BillType> &v) {
    switch (*v) {
        case BILL:
            return "BILL";
        case INVOICE:
            return "INVOICE";
        default:
            return "Unknown";
    }
}

