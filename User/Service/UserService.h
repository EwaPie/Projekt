#ifndef USER_USERSERVICE_H
#define USER_USERSERVICE_H


#include "../Repository/AbstractUserRepository.h"
#include "../Repository/AbstractACLRepository.h"
#include "../Exception/PermissionDeniedException .h"
#include "../Exception/CouldNotOpenFileException.h"

class UserService
{
public:
    UserService(AbstractUserRepository *pLoader, AbstractACLRepository *pAclRepository);
    virtual ~UserService();

    static UserService* getInstance();
    void addUser(User &user) noexcept(false);
    bool deleteUserById(unsigned int id);
    bool canLoggedUser(std::string name) noexcept;
    bool login(std::string userName, std::string password);

private:
    static UserService* instance;

    AbstractUserRepository* pRepository;
    AbstractACLRepository* pAclRepository;
    std::vector<User> users;

    bool validateUniqueness(const User &user);

    std::vector<ACL> acls;

    bool validateUser(User &user);

    User* logedUser = nullptr;
};


#endif //USER_USERSERVICE_H
