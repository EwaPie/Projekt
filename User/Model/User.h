#ifndef USER_USER_H
#define USER_USER_H


#include <string>
#include <ostream>
#include <vector>

class User
{
private:
    unsigned int id;
    std::string userName;
    std::string password;
    std::vector<std::string> roles;

public:
    friend std::ostream &operator<<(std::ostream &os, const User &user);

    User(unsigned int id, const std::string &userName, const std::string &password,
             std::vector<std::string> roles);

    unsigned int getId() const;

    void setId(unsigned int id);

    const std::string &getUserName() const;

//    User(const std::string &userName, const std::string &password);

    const std::string &getPassword() const;

    bool hasRole(const std::string &role);

};


#endif
