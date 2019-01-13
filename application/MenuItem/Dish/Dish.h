//
// Created by Mateusz on 31.12.2018.
//

#ifndef RESTAURANT_DISH_H
#define RESTAURANT_DISH_H

#include "../MenuItem.h"


class Dish: public MenuItem {
protected:
    string type;
public:

    Dish(const string &name, float priceNetto, float discountedPriceNetto, float taxRate, const string &type);

    const string &getType() const;

    /**
     *
     * @param type
     */
    void setType(const string &type);

};


#endif //RESTAURANT_DISH_H
