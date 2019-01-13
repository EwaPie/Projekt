//
// Created by User on 2019-01-13.
//

#ifndef PROJEKT_STATISTICSERVICE_H
#define PROJEKT_STATISTICSERVICE_H

#include "Bill.h"
class StatisticService {
public:
    virtual bool addEvent(Bill* event) = 0;
};


#endif //PROJEKT_STATISTICSERVICE_H
