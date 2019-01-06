#ifndef USER_PERMISSIONDENIED_H
#define USER_PERMISSIONDENIED_H

#include <exception>

struct PermissionDeniedException : public std::exception
{
    const char * what () const noexcept {
        return "Permission Denied";
    }
};

#endif //USER_PERMISSIONDENIED_H
