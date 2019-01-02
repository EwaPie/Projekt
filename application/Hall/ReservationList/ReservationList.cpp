//
// Created by Mateusz on 31.12.2018.
//

#include "ReservationList.h"

ReservationList::ReservationList(ReservationListElement **pHead, ReservationListElement **pTail) : pHead(pHead),
                                                                                                   pTail(pTail) {}

int ReservationList::pushFront(Reservation** reservation) {

    if (*pHead == nullptr)
    {
        auto *reservationListElement = new ReservationListElement(**reservation, nullptr);
        *this->pHead = reservationListElement;
        *this->pTail = reservationListElement;
        return 1;
    }

    auto *reservationListElement = new ReservationListElement(**reservation, (*this->pHead)->pNext);
    reservationListElement->pNext = *this->pHead;
    *this->pHead = reservationListElement;
    return 1;
}

int ReservationList::pushBack(Reservation** reservation) {
    if (*pHead == nullptr)
    {
        auto *reservationListElement = new ReservationListElement(**reservation, nullptr);
        *this->pHead = reservationListElement;
        *this->pTail = reservationListElement;
        return 1;
    }

    auto *reservationListElement = new ReservationListElement(**reservation, nullptr);
    (*this->pTail)->pNext = reservationListElement;
    (*this->pTail) = reservationListElement;
    return 1;
}

int ReservationList::deleteElement(Reservation **reservation) {

    ReservationListElement *current = *this->pHead;
    ReservationListElement *prev = nullptr;

    while (current != nullptr) {
        if (current->reservation.getReservationData() == (*reservation)->getReservationData()) {

            if (prev == nullptr)
            {
                (*this->pHead) = current->pNext;
                delete current;
                delete prev;
                return 1;
            }
            else
            {
                prev->pNext = current->pNext;
                delete current;
                return 1;
            }
        }

        prev = current;
        current = current->pNext;
    }

    return 0; //nothing has been deleted
}
