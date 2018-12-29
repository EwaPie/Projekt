#ifndef USER_USERSERVICE_H
#define USER_USERSERVICE_H


#include "../Loader/AbstractUserRepository.h"
#include "../Loader/AbstractACLRepository.h"

class UserService
{
public:
    UserService(AbstractUserRepository *pLoader, AbstractACLRepository *pAclRepository);
    virtual ~UserService();

    static UserService* getInstance();
    void addUser(User &user);
    bool canLogedUser(std::string name);
    void addACL(const ACL &acl);
    bool login(std::string userName, std::string password);

private:
    static UserService* instance;

    AbstractUserRepository* pRepository;
    AbstractACLRepository* pAclRepository;
    std::vector<User> users;

    bool validateUniquness(const User& user);
    bool validateUniquness(const ACL& acl);

    std::vector<ACL> acls;

    bool validateUser(User &user);

    User* logUser = nullptr;
};


#endif //USER_USERSERVICE_H
