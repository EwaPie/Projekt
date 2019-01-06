#include "ACL.h"

ACL::ACL(const std::string &name, const std::string &role) : name(name), role(role) {}

std::ostream &operator<<(std::ostream &os, const ACL &acl) {
    os << acl.name << ";" << acl.role << std::endl;
    return os;
}

const std::string &ACL::getName() const {
    return name;
}

const std::string &ACL::getRole() const {
    return role;
}
