//
// Created by Mateusz on 13.01.2019.
//

#include "ContextManager.h"

ContextManager::ContextManager() {

    this->initialize();
}

void ContextManager::initialize() {

    auto *tableList = new list<Table*>;
    auto *reservationListElement = new ReservationListElement();
    auto *reservationList = new ReservationList(reservationListElement, reservationListElement);
    Hall *hall = new Hall(tableList, reservationList);

    auto *table = new Table(1, 4);
    auto *table2 = new Table(2, 2);
    auto *table3 = new Table(3, 8);
    auto *table4 = new Table(4, 4);
    auto *table5= new Table(5, 10);

    this->hallManager = new HallManager(hall);

    hallManager->addTable(table);
    hallManager->addTable(table2);
    hallManager->addTable(table3);
    hallManager->addTable(table4);
    hallManager->addTable(table5);
}

ContextManager::~ContextManager() {

        delete hallManager;
}


