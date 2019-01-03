#ifndef USER_USERNAMEVALIDATOR_H
#define USER_USERNAMEVALIDATOR_H

#define USERNAME_MAXLENGTH 50;
#define USERNAME_MINLENGTH 4;

#include <string>

class UsernameValidator
{
public:
    UsernameValidator(const std::string &username);

    bool validateLength();

private:
    std::string username;
};


#endif //USER_USERNAMEVALIDATOR_H
