//
// Created by Mateusz on 31.12.2018.
//

#pragma once

#include "../../Reservation/Reservation.h"

class ReservationListElement {
public:
    Reservation reservation;

    ReservationListElement* pNext;

    /**
     *
     * @param Reservation reservation
     * @param ReservationListElement* pNext
     */
    ReservationListElement(const Reservation &reservation, ReservationListElement* pNext);
    ReservationListElement();
};


