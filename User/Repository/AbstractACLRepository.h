//
// Created by Usamaru on 29.12.18.
//

#ifndef USER_ABSTRACTACLREPOSITORY_H
#define USER_ABSTRACTACLREPOSITORY_H


#include <vector>
#include "../Model/ACL.h"

class AbstractACLRepository
{
public:
    virtual std::vector<ACL> load() = 0;

    virtual ~AbstractACLRepository() {}
};


#endif //USER_ABSTRACTACLREPOSITORY_H
