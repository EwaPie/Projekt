//
// Created by Mateusz on 31.12.2018.
//

#ifndef RESTAURANT_DRINK_H
#define RESTAURANT_DRINK_H

#include "../MenuItem.h"


class Drink: public MenuItem {
protected:
    bool isAlcohol;
public:

    Drink(const string &name, float priceNetto, float discountedPriceNetto, float taxRate, int realizationTime,
          bool isAlcohol);

    bool isIsAlcohol() const;

    void setIsAlcohol(bool isAlcohol);
};


#endif //RESTAURANT_DRINK_H
