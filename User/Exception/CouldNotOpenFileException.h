#include <utility>

#ifndef USER_COULDNOTOPENFILEEXCEPTION_H
#define USER_COULDNOTOPENFILEEXCEPTION_H


#include <exception>
#include <string>
#include <cstring>

struct CouldNotOpenFileException : public std::exception
{
    const char * what () const noexcept
    {
        return "Could not open the file";
    }
};
#endif //USER_COULDNOTOPENFILEEXCEPTION_H
