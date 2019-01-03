#ifndef USER_USERWRONGLENGTHEXCEPTION_H
#define USER_USERWRONGLENGTHEXCEPTION_H

#include <exception>

struct UserWrongLengthException : public std::exception
{
    const char * what () const noexcept {
        return "Username should be between 4 and 50";
    }
};

#endif //USER_USERWRONGLENGTHEXCEPTION_H
