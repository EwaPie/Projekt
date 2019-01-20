//
// Created by Mateusz on 31.12.2018.
//

#pragma once


#include "../MenuItem.h"


class Dish: public MenuItem {
protected:
    string type;
public:

    Dish(const string &name, float priceNetto, float discountedPriceNetto, float taxRate, int realizationTime,
         const string &type);

    const string &getType() const;

    /**
     *
     * @param type
     */
    void setType(const string &type);

};


