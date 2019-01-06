//
// Created by Mateusz on 31.12.2018.
//

#include "ReservationListElement.h"

ReservationListElement::ReservationListElement(const Reservation &reservation, ReservationListElement *pNext)
        : reservation(reservation), pNext(pNext) {}

ReservationListElement::ReservationListElement() = default;
