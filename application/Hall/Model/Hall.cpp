//
// Created by Mateusz on 31.12.2018.
//

#include "Hall.h"

Hall::Hall(std::list<Table*> *tableList, ReservationList *pReservationList) : tableList(tableList),
                                                                               pReservationList(pReservationList) {}

Hall::~Hall() {
    for (Table *tab : *tableList)
    {
        delete tab;
    }
    delete tableList;
}

std::list<Table*> *Hall::getTableList() {
    return tableList;
}

void Hall::setTableList(std::list<Table*> *tableList) {
    Hall::tableList = tableList;
}

ReservationList *Hall::getPReservationList() const {
    return Hall::pReservationList;
}

void Hall::setPReservationList(ReservationList *pReservationList) {
    Hall::pReservationList = pReservationList;
}
