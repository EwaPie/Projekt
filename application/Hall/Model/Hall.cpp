//
// Created by Mateusz on 31.12.2018.
//

#include "Hall.h"

Hall::Hall(const list<Table> &tableList, ReservationList **pReservationList) : tableList(tableList),
                                                                               pReservationList(pReservationList) {}

Hall::~Hall() {

}

list<Table> &Hall::getTableList() {
    return tableList;
}

void Hall::setTableList(const list<Table> &tableList) {
    Hall::tableList = tableList;
}

ReservationList *Hall::getPReservationList() const {
    return *Hall::pReservationList;
}

void Hall::setPReservationList(ReservationList **pReservationList) {
    Hall::pReservationList = pReservationList;
}
