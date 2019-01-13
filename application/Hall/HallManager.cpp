//
// Created by Mateusz on 31.12.2018.
//

#include "HallManager.h"

HallManager::HallManager(Hall *hall) : hall(hall) {}

list<Table*> *HallManager::getTableList() {
    return hall->getTableList();
}

int HallManager::deleteTable(Table* table) {

    this->hall->getTableList()->remove(table);
    return 1;
}

int HallManager::addTable(Table *table) {
    hall->getTableList()->push_back(table);
    return 1;
}

int HallManager::addReservation(Reservation *reservation) {

    bool wasFound = false;

    for (auto it : *this->getTableList()) {
        if (it->getNumberOfSeats() == reservation->getReservationData().getNumberOfPeople())
            wasFound = true;
    }

    if (!wasFound)
    {
        cout << "Brak stolika w zadanej konfiguracji!" << endl;
        return 0;
    }

    (*hall->getPReservationList()).pushFront(reservation);
    return 1;
}

int HallManager::deleteReservation(Reservation **reservation) {

    auto temp = hall->getPReservationList()->pHead;

    while (temp != nullptr)
    {
        if (temp->reservation.getReservationData() == (*reservation)->getReservationData())
        {
            (*hall->getPReservationList()).deleteElement(reservation);
            return 1; //znalezione i usuniete
        }
        temp = temp->pNext;
    }

    return 0; //nie znaleziono tej rezerwacji
}

Hall *HallManager::getHall() {
    return hall;
}

ReservationList *HallManager::getReservationList() {
    return hall->getPReservationList();
}

HallManager::~HallManager() {

    delete this->hall;
}
