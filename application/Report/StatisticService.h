//
// Created by User on 2019-01-13.
//
#pragma once

#include "Bill.h"
#include <memory>

class StatisticService {
public:
    StatisticService(){}

    virtual bool addEvent(shared_ptr<Bill> event) = 0;

    virtual ~StatisticService(){}
};

