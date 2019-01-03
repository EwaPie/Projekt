#ifndef USER_USERISNOTLOGGEDEXCEPTION_H
#define USER_USERISNOTLOGGEDEXCEPTION_H


#include <exception>

struct UserIsNotLoggedException : public std::exception
{
    const char * what () const noexcept {
        return "Permission Denied";
    }
};

#endif //USER_USERISNOTLOGGEDEXCEPTION_H
