#include <utility>

#include "User.h"

std::ostream &operator<<(std::ostream &os, const User &user) {
    os <<  user.id << " ;" << user.userName << " ;" << user.password << ";" << std::endl;
    return os;
}

User::User(unsigned int id, const std::string &userName, const std::string &password,
           std::vector<std::string> roles) :
        id(id),
        userName(userName),
        password(password), roles(std::move(std::move(roles))) {}

unsigned int User::getId() const {
    return this->id;
}

void User::setId(unsigned int id) {
    User::id = id;
}

const std::string &User::getUserName() const {
    return userName;
}

void User::setUserName(const std::string &userName) {
    User::userName = userName;
}

const std::string &User::getPassword() const {
    return password;
}

void User::setPassword(const std::string &password) {
    User::password = password;
}

User::User(const std::string &userName, const std::string &password) : userName(userName), password(password) {}

bool User::hasRole(const std::string &role)
{
    for(const std::string &userRole : this->roles)
    {
        if(role == userRole)
            return true;
    }
    return false;
}
