//
// Created by Mateusz on 13.01.2019.
//

#pragma once

#include "../Hall/HallManager.h"
#include "../Hall/Table/Table.h"
#include "../Hall/ReservationList/ReservationList.h"
#include "../Hall/ReservationList/Model/ReservationListElement.h"
#include "../Hall/Reservation/Reservation.h"
#include "../Hall/Reservation/ReservationData/ReservationData.h"
#include "../Report/StatisticService.h"
#include "../Report/BufferedStatisticService.h"
#include "../Report/ReportService.h"

class ContextManager {
private:

    ContextManager();

    shared_ptr<HallManager> hallManager;
    shared_ptr<StatisticService> statisticService;
    shared_ptr<ReportService> reportService;

    MenuItem menuItems[1] = {MenuItem("Nazwa", 20, 16, 0.23, 32542364)};

    void initialize();

public:
    static shared_ptr<ContextManager> getInstance() {
        static shared_ptr<ContextManager> instance;
        return instance;
    }

    shared_ptr<HallManager> getHallManager() const;

    shared_ptr<StatisticService>getStatisticService() const;

    const shared_ptr<ReportService> &getReportService() const;

    std::list<MenuItem> getMenuItems();
};

