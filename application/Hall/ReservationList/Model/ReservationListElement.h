//
// Created by Mateusz on 31.12.2018.
//

#ifndef RESTAURANT_RESERVATIONLISTELEMENT_H
#define RESTAURANT_RESERVATIONLISTELEMENT_H

#include "../../Reservation/Reservation.h"

using namespace std;

class ReservationListElement {
public:
    Reservation reservation;

    ReservationListElement* pNext;

    /**
     *
     * @param Reservation reservation
     * @param ReservationListElement* pNext
     */
    ReservationListElement(const Reservation &reservation, ReservationListElement *pNext);
    ReservationListElement();
};


#endif //RESTAURANT_RESERVATIONLISTELEMENT_H
