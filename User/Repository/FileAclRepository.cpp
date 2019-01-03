#include <fstream>
#include <sstream>
#include "FileAclRepository.h"
#include "../Exception/InvalidFilenameLengthException.h"
#include "../Exception/CouldNotOpenFileException.h"

std::vector<ACL> FileAclRepository::load() {
    if(this->fileName.length() == 0)
        throw InvalidFilenameLengthException();

    std::fstream file(this->fileName);
    if(!file.good() || !file.is_open())
        throw CouldNotOpenFileException();

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
