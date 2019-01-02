//
// Created by Mateusz on 31.12.2018.
//

#include "Reservation.h"

Reservation::Reservation(const ReservationData &reservationData, const Bill &bill) : reservationData(reservationData),
                                                                                     bill(bill) {}

const ReservationData &Reservation::getReservationData() const {
    return reservationData;
}

void Reservation::setReservationData(const ReservationData &reservationData) {
    Reservation::reservationData = reservationData;
}

const Bill &Reservation::getBill() const {
    return bill;
}

void Reservation::setBill(const Bill &bill) {
    Reservation::bill = bill;
}

Reservation::Reservation() = default;
