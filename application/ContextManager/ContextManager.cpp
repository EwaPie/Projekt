//
// Created by Mateusz on 13.01.2019.
//

#include "ContextManager.h"

ContextManager::ContextManager() {
    this->initialize();
}

void ContextManager::initialize() {

    statisticService = shared_ptr<StatisticService>(new BufferedStatisticService());
    reportService = make_shared<ReportService>();

    auto *tableList = new list<Table *>;
    auto *reservationListElement = new ReservationListElement();
    auto *reservationList = new ReservationList(reservationListElement, reservationListElement);
    Hall *hall = new Hall(tableList, reservationList);

    auto *table = new Table(1, 4);
    auto *table2 = new Table(2, 2);
    auto *table3 = new Table(3, 8);
    auto *table4 = new Table(4, 4);
    auto *table5 = new Table(5, 10);

    this->hallManager = shared_ptr<HallManager>(new HallManager(hall));

    hallManager->addTable(table);
    hallManager->addTable(table2);
    hallManager->addTable(table3);
    hallManager->addTable(table4);
    hallManager->addTable(table5);
}

shared_ptr<HallManager> ContextManager::getHallManager() const {
    return hallManager;
}

shared_ptr<StatisticService> ContextManager::getStatisticService() const {
    return statisticService;
}

const shared_ptr<ReportService> &ContextManager::getReportService() const {
    return reportService;
}


