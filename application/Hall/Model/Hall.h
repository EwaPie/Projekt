//
// Created by Mateusz on 31.12.2018.
//

#pragma once
#include <iostream>
#include <list>
#include "../ReservationList/ReservationList.h"
#include "../Reservation/Reservation.h"
#include "../Table/Table.h"


class Hall {
protected:
    list<Table*> *tableList;
    ReservationList *pReservationList;
public:
    /**
     * @param tableList
     * @param pReservationList
     */
    Hall(list<Table*> *tableList, ReservationList *pReservationList);

    virtual ~Hall();

    list<Table*> *getTableList();

    /**
     * @param tableList
     */
    void setTableList(list<Table*> *tableList);


    ReservationList *getPReservationList() const;

    /**
     * @param pReservationList
     */
    void setPReservationList(ReservationList *pReservationList);
};

