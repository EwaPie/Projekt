#ifndef USER_INVALIDFILENAMELENGTHEXCEPTION_H
#define USER_INVALIDFILENAMELENGTHEXCEPTION_H


#include <exception>

struct InvalidFilenameLengthException : public std::exception
{
    const char * what () const noexcept
    {
        return "Filename shluld be grater than 0";
    }
};
#endif //USER_INVALIDFILENAMELENGTHEXCEPTION_H
