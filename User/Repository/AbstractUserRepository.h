#ifndef USER_ABSTRACTLOADER_H
#define USER_ABSTRACTLOADER_H

#include <vector>
#include "../Model/User.h"

class AbstractUserRepository
{
public:
     virtual std::vector<User> load() = 0;
     virtual bool save(std::vector<User> userList) = 0;

    virtual ~AbstractUserRepository() {}
};


#endif //USER_ABSTRACTLOADER_H
