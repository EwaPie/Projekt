#include <iostream>
#include <fstream>
#include <string>
#include <sstream>
#include "FileUserRepository.h"

std::vector<User> FileUserRepository::load()
{
    if(this->fileName.length() == 0)
    {
        //TODO: throw exception
    }

    std::ifstream file(this->fileName);
    if(!file.good() || !file.is_open())
    {
        //TODO: thorw exception
    }
    std::vector<User> users;
    while (!file.eof())
    {
         std::string line = "";
         getline(file, line);
         if(!line.empty())
         {
             User user = this->getUserFromLine(line);
             users.push_back(user);
         }
    }
    file.close();
    return users;
}

bool FileUserRepository::save(std::vector<User> userList)
{
    std::ofstream file(this->fileName, std::ios::trunc);

    if(!file.good() || !file.is_open())
    {
        //TODO: thorw exception
    }

    for(const auto &user: userList)
    {
        file << user;
    }
    file.close();
    return true;
}

FileUserRepository::FileUserRepository(const std::string &fileName) : fileName(fileName) {}

User FileUserRepository::getUserFromLine(std::string line)
{
    unsigned int id;
    std::string password;
    std::string userName;
    std::string helpLine;
    std::istringstream iss(line);

    getline(iss, helpLine, ';');
    id = static_cast<unsigned int>(std::stoi(helpLine));

    getline(iss, helpLine, ';');
    userName = helpLine;

    getline(iss, helpLine, ';');
    password = helpLine;

    std::vector<std::string> roles;
    for(std::string role; getline(iss, role, ';');)
    {
        roles.push_back(role);
    }
    return User(id, userName, password, roles);
}
