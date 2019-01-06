#include "UsernameValidator.h"

UsernameValidator::UsernameValidator(const std::string &username) : username(username) {}

bool UsernameValidator::validateLength()
{
    unsigned long length = this->username.length();
    bool min = length > USERNAME_MINLENGTH;
    return min && length < USERNAME_MAXLENGTH;
}
