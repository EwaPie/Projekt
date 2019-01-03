#ifndef USER_USERNAMENOTUNIQUEEXCEPTION_H
#define USER_USERNAMENOTUNIQUEEXCEPTION_H


#include <exception>

struct UserWrongLengthException : public std ::exception
{
    const char * what () const noexcept {
        return "Username is not unique";
    }
};
#endif //USER_USERNAMENOTUNIQUEEXCEPTION_H
