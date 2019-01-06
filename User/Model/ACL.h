#ifndef USER_ACL_H
#define USER_ACL_H


#include <string>
#include <ostream>

class ACL
{
private:
    std::string name;
    std::string role;

public:
    ACL(const std::string &name, const std::string &role);

    friend std::ostream &operator<<(std::ostream &os, const ACL &acl);

    const std::string &getName() const;

    const std::string &getRole() const;
};


#endif //USER_ACL_H
