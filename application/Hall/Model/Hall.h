//
// Created by Mateusz on 31.12.2018.
//

#ifndef RESTAURANT_HALL_H
#define RESTAURANT_HALL_H

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


#endif //RESTAURANT_HALL_H
