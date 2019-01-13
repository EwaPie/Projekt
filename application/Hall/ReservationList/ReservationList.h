//
// Created by Mateusz on 31.12.2018.
//

#ifndef RESTAURANT_RESERVATIONLIST_H
#define RESTAURANT_RESERVATIONLIST_H

#include "Model/ReservationListElement.h"
#include "../Reservation/Reservation.h"

using namespace std;

class ReservationList {
public:
    ReservationListElement* pHead;
    ReservationListElement* pTail;

    /**
     *
     * @param ReservationListElement** pHead
     * @param ReservationListElement** pTail
     */
    ReservationList(ReservationListElement *pHead, ReservationListElement *pTail);

    /**
     *
     * @param Reservation** reservation
     * @return int
     */
    int pushFront(Reservation* reservation);

    /**
     *
     * @param Reservation** reservation
     * @return int
     */
    int pushBack(Reservation** reservation);

    /**
     *
     * @param Reservation** reservation
     * @return int
     */
    int deleteElement(Reservation** reservation);

};


#endif //RESTAURANT_RESERVATIONLIST_H
