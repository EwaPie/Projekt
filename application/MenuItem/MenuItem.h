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
    float priceNetto;
    float priceBrutto;
    float discountedPriceNetto;
    float discountedPriceBurtto;
    float taxRate;
public:
    MenuItem(const string &name, float priceNetto, float discountedPriceNetto, float taxRate);

    virtual ~MenuItem();

    const string &getName() const;

    void setName(const string &name);

    float getPriceNetto() const;

    void setPriceNetto(float priceNetto);

    float getPriceBrutto() const;

    void setPriceBrutto(float priceBrutto);

    float getDiscountedPriceNetto() const;

    void setDiscountedPriceNetto(float discountedPriceNetto);

    float getDiscountedPriceBurtto() const;

    void setDiscountedPriceBurtto(float discountedPriceBurtto);

    float getTaxRate() const;

    void setTaxRate(float taxRate);
};


#endif //RESTAURANT_MENUITEM_H
