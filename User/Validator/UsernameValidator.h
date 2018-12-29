//
// Created by Usamaru on 29.12.18.
//

#ifndef USER_USERNAMEVALIDATOR_H
#define USER_USERNAMEVALIDATOR_H
#define USERNAME_MAXLENGTH 50;
#define USERNAME_MINLENGTH 50;

#include <string>

class UsernameValidator
{
public:
    UsernameValidator(const std::string &username);

    bool validateLenght();

private:
    std::string username;
};


#endif //USER_USERNAMEVALIDATOR_H
