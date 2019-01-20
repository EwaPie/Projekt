//
// Created by Mateusz on 31.12.2018.
//

#pragma once
#include <iostream>
#include <list>
#include "../ReservationList/ReservationList.h"
#include "../Table/Table.h"

class Hall {
protected:
    std::list<Table*> *tableList;
    ReservationList *pReservationList;
public:
    /**
     * @param tableList
     * @param pReservationList
     */
    Hall( std::list<Table *> * tableList, ReservationList *pReservationList);

    virtual ~Hall();

    std::list<Table*> *getTableList();

    /**
     * @param tableList
     */
    void setTableList(std::list<Table*> *tableList);


    ReservationList *getPReservationList() const;

    /**
     * @param pReservationList
     */
    void setPReservationList(ReservationList *pReservationList);
};

