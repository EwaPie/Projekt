#include <cstdio>
#include "UserService.h"
#include "../Repository/FileUserRepository.h"
#include "../Repository/FileAclRepository.h"
#include "../Validator/UsernameValidator.h"
#include "../Model/User.h"
#include "../Exception/PermissionDeniedException .h"
#include "../Exception/UserIsNotLoggedException.h"
#include "../Exception/UserNameNotUniqueException.h"

UserService* UserService::getInstance()
{
    if(instance == nullptr)
        instance = new UserService(new FileUserRepository("users"), new FileAclRepository("acl"));

    return instance;
}


UserService* UserService::instance = nullptr;

UserService::UserService(AbstractUserRepository *pLoader, AbstractACLRepository *pAclRepository)
        : pRepository(pLoader), pAclRepository(pAclRepository) {
    try
    {
        this->users = pLoader->load();
    }
    catch (const std::exception &exception)
    {
        this->users = std::vector<User>();
    }

    try
    {
        this->acls = pAclRepository->load();
    }
    catch (const std::exception &exception)
    {
        this->acls = std::vector<ACL>();
    }
}

UserService::~UserService()
{
    this->pRepository->save(this->users);
    delete pAclRepository;
    delete pRepository;
    delete UserService::instance;
}

void UserService::addUser(User &user)
{
    if(!this->canLoggedUser("admin"))
    {
        throw PermissionDeniedException();
    }
    if(!this->validateUser(user))
        return;
    unsigned int newID = 1;

    if(!this->users.empty())
    {
        newID += this->users.back().getId();
    }

    user.setId(newID);
    this->users.push_back(user);
    this->pRepository->save(this->users);
}

bool UserService::validateUniqueness(const User &user)
{
    for(const auto &savedUser : this->users)
    {
        if(user.getUserName() == savedUser.getUserName())
            return false;
    }
    return true;
}



bool UserService::canLoggedUser(std::string name)
{
    if(logedUser == nullptr)
    {
        throw UserIsNotLoggedException();
    }
    for(const ACL &acl : this->acls)
    {
        if(acl.getName() == name)
        {
            return this->logedUser->hasRole(acl.getRole());
        }
    }
    return false;
}

bool UserService::login(std::string userName, std::string password)
{
   for(User &user :this->users)
   {
       if(user.getUserName() == userName && user.getPassword() == password)
       {
           this->logedUser = &user;
           return true;
       }
   }
    return false;
}

bool UserService::validateUser(User &user) {
    if(!this->validateUniqueness(user))
        throw UserWrongLengthException();
    UsernameValidator usernameValidator(user.getUserName());
    if(!usernameValidator.validateLength())
        throw UserWrongLengthException();
    return true;
}

bool UserService::deleteUserById(unsigned int id)
{
    for(int i = 0; i < this->users.size(); i++)
    {
        if(this->users[i].getId() == id)
        {
            users.erase(users.begin()+i);
            this->pRepository->save(this->users);
            return true;
        }
    }
    return false;
}

const std::vector<User> &UserService::getUsers() const {
    return users;
}
