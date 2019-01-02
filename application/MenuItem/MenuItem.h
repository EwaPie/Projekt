//
// Created by Mateusz on 31.12.2018.
//

#ifndef RESTAURANT_MENUITEM_H
#define RESTAURANT_MENUITEM_H

#include <iostream>
#include <string>

using namespace std;

class MenuItem {
protected:
    string name;
    float price;
    float discountedPrice;
public:
    /**
     *
     * @param string name
     * @param float price
     * @param float discountedPrice
     */
    MenuItem(const string &name, float price, float discountedPrice);

    const string &getName() const;

    /**
     *
     * @param string name
     */
    void setName(const string &name);

    float getPrice() const;

    /**
     *
     * @param float price
     */
    void setPrice(float price);

    float getDiscountedPrice() const;

    /**
     *
     * @param float discountedPrice
     */
    void setDiscountedPrice(float discountedPrice);

    float getRealPrice();

};


#endif //RESTAURANT_MENUITEM_H
