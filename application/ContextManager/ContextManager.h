//
// Created by Mateusz on 13.01.2019.
//

#ifndef RESTAURANT_CONTEXTMANAGER_H
#define RESTAURANT_CONTEXTMANAGER_H

#include "../Hall/HallManager.h"
#include "../Hall/Table/Table.h"
#include "../Hall/ReservationList/ReservationList.h"
#include "../Hall/ReservationList/Model/ReservationListElement.h"
#include "../Hall/Reservation/Reservation.h"
#include "../Hall/Reservation/ReservationData/ReservationData.h"

class ContextManager {
public:
    HallManager *hallManager;

    ContextManager();

    virtual ~ContextManager();

private:

    void initialize();


};


#endif //RESTAURANT_CONTEXTMANAGER_H
