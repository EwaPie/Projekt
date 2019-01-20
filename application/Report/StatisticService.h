//
// Created by User on 2019-01-13.
//

#ifndef PROJEKT_STATISTICSERVICE_H
#define PROJEKT_STATISTICSERVICE_H

#include "Bill.h"
#include <memory>

class StatisticService {
public:
    virtual bool addEvent(shared_ptr<Bill> event) = 0;

    virtual ~StatisticService() = 0;
};


#endif //PROJEKT_STATISTICSERVICE_H
