//
// Created by Mateusz on 31.12.2018.
//

#pragma once

#include "Model/ReservationListElement.h"
#include "../Reservation/Reservation.h"

class ReservationList {
public:
    ReservationListElement * pHead;
    ReservationListElement * pTail;

    /**
     *
     * @param ReservationListElement* pHead
     * @param ReservationListElement* pTail
     */
    ReservationList(ReservationListElement* pHead, ReservationListElement* pTail);

     /*
     * @param Reservation* reservation
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
