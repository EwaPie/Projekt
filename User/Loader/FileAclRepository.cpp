#include <fstream>
#include <sstream>
#include "FileAclRepository.h"

std::vector<ACL> FileAclRepository::load() {
    if(this->fileName.length() == 0)
    {
        //TODO: throw exception
    }

    std::fstream file(this->fileName);
    if(!file.good() || !file.is_open())
    {
        //TODO: thorw exception
        return std::vector<ACL>();
    }
    std::vector<ACL> acls;
    while (!file.eof())
    {
        std::string line;
        getline(file, line);
        if(!line.empty())
        {
            ACL acl = this->getACLFromLine(line);
            acls.push_back(acl);
        }
    }
    file.close();
    return acls;
}

bool FileAclRepository::save(std::vector<ACL> aclList) {
    std::ofstream file(this->fileName, std::ios::trunc);

    if(!file.good() || !file.is_open())
    {
        //TODO: thorw exception
    }

    for(const auto &acl: aclList)
    {
        file << acl;
    }
    file.close();
    return true;
}

FileAclRepository::FileAclRepository(const std::string &fileName) : fileName(fileName) {}

ACL FileAclRepository::getACLFromLine(std::string line)
{
    std::string name;
    std::string role;
    std::istringstream iss(line);

    getline(iss, name, ';');
    getline(iss, role, ';');

    return ACL(name, role);
}
