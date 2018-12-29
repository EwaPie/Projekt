#include <cstdio>
#include "UserService.h"
#include "../Loader/FileUserRepository.h"
#include "../Loader/FileAclRepository.h"
#include "../Validator/UsernameValidator.h"

UserService* UserService::getInstance()
{
    if(instance == nullptr)
        instance = new UserService(new FileUserRepository("users"), new FileAclRepository("acl"));

    return instance;
}


UserService* UserService::instance = nullptr;

UserService::UserService(AbstractUserRepository *pLoader, AbstractACLRepository *pAclRepository)
        : pRepository(pLoader), pAclRepository(pAclRepository) {
    this->users = pLoader->load();
    this->acls = pAclRepository->load();
}

UserService::~UserService()
{
    this->pRepository->save(this->users);
    this->pAclRepository->save(this->acls);
    delete pAclRepository;
    delete pRepository;
    delete UserService::instance;
}

void UserService::addUser(User &user)
{
    if(!this->validateUser(user))
    {
        //TODO throw exception
        return;
    }
    unsigned int newID = 1;

    if(!this->users.empty())
    {
        newID += this->users.back().getId();
    }



    user.setId(newID);
    this->users.push_back(user);
    this->pRepository->save(this->users);
}

bool UserService::validateUniquness(const User &user)
{
    for(const auto &savedUser : this->users)
    {
        if(user.getUserName() == savedUser.getUserName())
            return false;
    }
    return true;
}

void UserService::addACL(const ACL &acl)
{
    if(!this->validateUniquness(acl))
    {
        //TODO throw exception
        return;
    }

    this->acls.push_back(acl);
    this->pAclRepository->save(this->acls);
}

bool UserService::validateUniquness(const ACL &acl)
{
    for(const ACL &savedAcl : this->acls)
    {
        if(savedAcl.getName().compare(acl.getName()))
            return false;
    }

    return true;
}

bool UserService::canLogedUser(std::string name)
{
    if(logUser == nullptr)
    {
        // TODO: exception
        return false;
    }
    for(const ACL &acl : this->acls)
    {
        if(acl.getName() == name)
        {
            return this->logUser->hasRole(acl.getRole());
        }
    }
    return false;
}

bool UserService::login(std::string userName, std::string password)
{
   for(auto user :this->users)
   {
       if(user.getUserName() == userName && user.getPassword() == password)
       {
           this->logUser = &user;
           return true;
       }
   }
    return false;
}

bool UserService::validateUser(User &user) {
    if(this->validateUniquness(user))
        return false;
        //TODO: exception
    UsernameValidator usernameValidator(user.getUserName());
    if(!usernameValidator.validateLenght())
        return false; //TODO exception
    return true;
}

