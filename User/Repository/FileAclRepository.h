#ifndef USER_FILEROLEREPOSITORY_H
#define USER_FILEROLEREPOSITORY_H


#include "AbstractUserRepository.h"
#include "AbstractACLRepository.h"

class FileAclRepository : public AbstractACLRepository
{
private:
    std::string fileName;
public:
    FileAclRepository(const std::string &fileName);

    std::vector<ACL> load() override;


    ACL getACLFromLine(std::string line);
};


#endif //USER_FILEROLEREPOSITORY_H
