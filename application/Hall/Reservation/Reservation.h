//
// Created by Mateusz on 31.12.2018.
//

#pragma once

#include <string>
#include "ReservationData/ReservationData.h"
#include "../../InterfacesForFutureClasses/Bill.h"

using namespace std;

class Reservation {
protected:
    ReservationData reservationData;
    Bill bill;
public:
    /**
     *
     * @param ReservationData reservationData
     * @param Bill bill
     */
    Reservation(const ReservationData &reservationData, const Bill &bill);

    Reservation();

    /**
     *
     * @return ReservationData
     */
    const ReservationData &getReservationData() const;

    /**
     *
     * @param ReservationData reservationData
     */
    void setReservationData(const ReservationData &reservationData);

    const Bill &getBill() const;

    /**
     *
     * @param Bill bill
     */
    void setBill(const Bill &bill);
};

